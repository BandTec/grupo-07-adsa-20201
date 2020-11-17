let btnProdutos = document.querySelector('#textorecado');
let jsonString;
function abrirProduto(){
    let select = document.querySelector('#listaProdutos');
    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/abrirProduto",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){

            console.log(ajax.responseText);
            jsonString = JSON.parse(ajax.responseText);
            for(let i=0;i<jsonString.length;i++){
                var opt = document.createElement('option');
                opt.value = jsonString[i].codProduto;
                opt.innerHTML = jsonString[i].nomeProduto;
                select.appendChild(opt);
                produtos.style.display = 'block';
            }
        }
    }
    ajax.send();
}
let valorTotal = 0;
let itens = [];

function addItem(){
    pedidoCliente.style.display = 'block';
    divValor.style.display = 'block';
    let nomeProduto = '';
    let valorProduto = 0;
    let cod = 0;
    for(let i=0;i<jsonString.length;i++){
        if(jsonString[i].codProduto == listaProdutos.value){
            if(quantidade.value >= 5){
                valorProduto = jsonString[i].precoAtacado;
                nomeProduto = jsonString[i].nomeProduto;
                cod = jsonString[i].codProduto;
            }else{
                valorProduto = jsonString[i].precoVarejo;
                nomeProduto = jsonString[i].nomeProduto;
                cod = jsonString[i].codProduto;
            }
        }
    }
    itens.push(cod);
    valorTotal = valorTotal + valorProduto * quantidade.value;
    pedidoCliente.innerHTML += `<label>Produto: ${nomeProduto}</label>`;
    pedidoCliente.innerHTML += `<label>Quantidade: ${quantidade.value}</label>`;
    pedidoCliente.innerHTML += `<label>Valor por litro/unidade R$: ${valorProduto.toFixed(2)}</label><br>`;
    total.innerHTML = `VALOR TOTAL:<br> R$ ${valorTotal.toFixed(2)}`;
}

let form = document.querySelector('#formulario');
let logradouro = document.querySelector('#logradouro');
let ncasa = document.querySelector('#ncasa');
let cep = document.querySelector('#cep');
let fixo = document.querySelector('#fixo');
let celular = document.querySelector('#celular');
let bairro = document.querySelector('#bairro');
let cidade = document.querySelector('#cidade');
let email = document.querySelector('#email');
let senha = document.querySelector('#senha');

function addPedido(evento) {
    evento.preventDefault();
    let ajax = new XMLHttpRequest();
        let params = "logradouro=" + logradouro.value + "&ncasa=" + ncasa.value + "&cep=" + cep.value + "&fixo=" + fixo.value + "&celular=" + celular.value + "&bairro="+ bairro.value + "&cidade="+ cidade.value + "&email="+ email.value + "&senha=" + senha.value;

        ajax.open("POST", "http://localhost:3000/addPedido");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                //console.log(ajax.responseText);
                var jsonString = JSON.parse(ajax.responseText);
                if(jsonString.affectedRows > 0){
                    recuperarCliente();
                }else{
                    alert("Ocorreu um problema com os seus dados. Por favor, tente novamente");
                }
            }
    
        }

    
    ajax.send(params);
}
form.addEventListener("submit", addPedido);

function recuperarCliente(){
    let ajax = new XMLHttpRequest();
        let params = "email="+ email.value + "&senha=" + senha.value;

        ajax.open("POST", "http://localhost:3000/recuperarCliente");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                //console.log(ajax.responseText);
                var jsonString = JSON.parse(ajax.responseText);
                if(jsonString[0].codigoUsuario > 0){
                    addVenda(jsonString[0].codigoUsuario);
                }else{
                    alert("Usuário não encontrado. Por favor, tente novamente.");
                }
            }
    
        } 
    ajax.send(params);
}

function addVenda(codigo){
    let ajax = new XMLHttpRequest();
    var date;
    date = new Date();
    date = date.getUTCFullYear() + '-' +
    ('00' + (date.getUTCMonth()+1)).slice(-2) + '-' +
    ('00' + date.getUTCDate()).slice(-2) + ' ' + 
    ('00' + date.getUTCHours()).slice(-2) + ':' + 
    ('00' + date.getUTCMinutes()).slice(-2) + ':' + 
    ('00' + date.getUTCSeconds()).slice(-2);
        let params = "codigo="+ codigo + "&agora=" + date + "&total=" + valorTotal;

        ajax.open("POST", "http://localhost:3000/addVenda");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                //console.log(ajax.responseText);
                var jsonString = JSON.parse(ajax.responseText);
                if(jsonString.affectedRows > 0){
                    recuperarVenda();
                }else{
                    alert("Ocorreu um problema ao cadastrar a sua venda. Por favor, tente novamente");
                }
            }
    
        } 
    ajax.send(params);
}

function recuperarVenda(){
    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/recuperarVenda",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){
            //console.log(ajax.responseText);
            jsonString = JSON.parse(ajax.responseText);    
            if(jsonString[0].ultimoRegistro > 0){
                addItensPedido(jsonString[0].ultimoRegistro);
            }else{
                alert("Ocorreu um problema com os dados da sua venda. Por favor, tente novamente");
            }
        }
    }
    ajax.send();
}

function addItensPedido(fkpedido){
    let jsonString;
    let ajax = new XMLHttpRequest();
        for(let i=0;i<itens.length;i++){
        let params = "itens="+ itens[i] + "&fkpedido=" + fkpedido;
        ajax.open("POST", "http://localhost:3000/addItensPedido");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                //console.log(ajax.responseText);
                jsonString = JSON.parse(ajax.responseText);

                if(jsonString.affectedRows > 0){
                    alert("Pedido realizado com sucesso.");
                    window.location.assign('dash.html');
                }else{
                    alert("Ocorreu um problema ao cadastrar os itens do seu pedido");

                }
            }
    
        } 
        ajax.send(params);
        }
}



function finalizar() {
    DadosCliente.style.display = "block";
}
function abrirTabela() {
    conteudo2.style.display = 'block';
    conteudo.style.display = 'none';
    conteudo3.style.display = 'none';
}

function abrirPedidos(){
    conteudo2.style.display = 'none';
    conteudo.style.display = 'none';
    conteudo3.style.display = 'block';
}

function abrirInicio() {
    conteudo2.style.display = 'none';
    conteudo.style.display = 'block';
    conteudo3.style.display = 'none';
}
function abrirMenu() {
    menulateral.style.width = '270px';
    menulateral.style.transition = '0.3s';
    imgAbrirMenu.style.display = 'none'
    imgFecharMenu.style.display = 'block';
    menulateral.style.border = '5px';
    menulateral.style.borderRight = 'solid rgba(50, 100, 50, 0.2)';
    conteudo.style.width = '80%';
    conteudo.style.transition = '0.3s';
    conteudo2.style.width = '80%';
    conteudo2.style.transition = '0.3s';
    conteudo3.style.width = '80%';
    conteudo3.style.transition = '0.3s';
    frame.style.marginLeft = '15px';
    frame.style.transition = '0.3s';
}

function fecharMenu() {
    menulateral.style.width = '0px';
    menulateral.style.transition = '0.3s';
    imgFecharMenu.style.display = 'none';
    imgAbrirMenu.style.display = 'block'
    menulateral.style.border = '0px';
    conteudo.style.width = '97%';
    conteudo.style.transition = '0.3s';
    conteudo2.style.width = '97%';
    conteudo2.style.transition = '0.3s';
    conteudo3.style.width = '97%';
    conteudo3.style.transition = '0.3s';
    frame.style.marginLeft = '150px';
    frame.style.transition = '0.3s';
    divValor.style.transition = '0.3s';
}