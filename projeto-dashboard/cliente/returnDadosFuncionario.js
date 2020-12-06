let formFuncionario = document.querySelector('#form-funcionario');
let nomeFunc = document.querySelector('#nomeFuncionario');

function addFuncionario(evento) {   
        evento.preventDefault();
        let ajax = new XMLHttpRequest();
        var date;
        var loginFuncionario = nomeFunc.value + "_";
        loginFuncionario += textoAleatorio(4);
        var senhaFuncionario = textoAleatorio(8);
        date = new Date(); 
        date = date.getUTCFullYear() + '-' +
        ('00' + (date.getUTCMonth()+1)).slice(-2) + '-' +
        ('00' + date.getUTCDate()).slice(-2) + ' ' + 
        ('00' + date.getUTCHours()).slice(-2) + ':' + 
        ('00' + date.getUTCMinutes()).slice(-2) + ':' + 
        ('00' + date.getUTCSeconds()).slice(-2); 

        if(nomeFunc.value != ""){
        
        let params = "nomeFuncionario=" + nomeFunc.value + "&loginFuncionario=" + loginFuncionario + "&senhaFuncionario=" + senhaFuncionario + "&dataCadastro=" + date;

            ajax.open("POST", "http://localhost:3000/addFuncionario");
            ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            ajax.onreadystatechange = function () {
                if (ajax.status == 200 & ajax.readyState == 4) {    
                    //console.log(ajax.responseText);
                    var jsonString = JSON.parse(ajax.responseText);
                    if((jsonString.affectedRows) > 0){
                        buscarUltimoFuncionario();
                        alert("Funcionario cadastrado com sucesso: Nome:"+ nomeFuncionario.value + "Login: "+ loginFuncionario + "Senha: " + senhaFuncionario);
                        window.location.assign('../examples/tools.html');
                        
                    }else {
                        alert("Um erro ocorreu");
                        
                    }

                }
        
            }
    
        
        ajax.send(params);

        }else {
            alert("Preencha o campo corretamente.");
        }
}

function textoAleatorio(tamanho)
{
    var letras = '123456789ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz';
    var aleatorio = '';
    for (var i = 0; i < tamanho; i++) {
        var rnum = Math.floor(Math.random() * letras.length);
        aleatorio += letras.substring(rnum, rnum + 1);
    }
    console.log(aleatorio);
    return aleatorio;
}

function buscarUltimoFuncionario(){

    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/buscarUltimoFuncionario",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){
            
            console.log(ajax.responseText);
            jsonString = JSON.parse(ajax.responseText);

            if(jsonString[0].UltimoRegistro > 0){
                getValuesFuncionario(jsonString[0].UltimoRegistro);
                //alert("ultimo: "+ jsonString[0].UltimoRegistro );
            }else{
                alert("Ocorreu um erro"); 
            }

        }
    }
    ajax.send();
}

function getValuesFuncionario(codFuncionario) {
    let aray = [];
    var listaMarcados = document.getElementsByTagName("input");
    let jsonString;
    let ajax = new XMLHttpRequest();

    for (loop = 0; loop < listaMarcados.length; loop++) {
       var item = listaMarcados[loop];
       if (item.type == "checkbox" && item.checked) {
         aray.push(item.value);
       }
    }

    for(let i=0;i<aray.length;i++){
        let params = "fkFuncionario=" + codFuncionario + "&pacoteFuncionario="+ aray[i];
        ajax.open("POST", "http://localhost:3000/getValuesFuncionario");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                console.log(ajax.responseText);
                jsonString = JSON.parse(ajax.responseText);
            }
    
        } 
        ajax.send(params);
        }
        
}



let selectFuncionario = document.querySelector('#tableFuncionario');
let textDangerFuncionario = document.querySelector('#textDangerFuncionario');

function listarFuncionario(){
    selectFuncionario.innerHTML = "";
    textDangerFuncionario.innerHTML = "";
    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/listarFuncionario",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){
            
            //console.log(ajax.responseText);
            var jsonString = JSON.parse(ajax.responseText);
            var th1 = document.createElement('th');
            var th2 = document.createElement('th');
            var th3 = document.createElement('th');
            var th4 = document.createElement('th');
            th1.innerHTML = "Código";
            th2.innerHTML = "Nome";
            th3.innerHTML = "Login";
            th4.innerHTML = "Ação";
            textDangerFuncionario.appendChild(th1);
            textDangerFuncionario.appendChild(th2);
            textDangerFuncionario.appendChild(th3);
            textDangerFuncionario.appendChild(th4);
            selectFuncionario.appendChild(textDangerFuncionario);
            for(let i=0;i<jsonString.length;i++){
                var tr = document.createElement('tr');
                var td = document.createElement('td');
                td.innerHTML = jsonString[i].codUsuario;
                var tr1 = document.createElement('tr');
                var td1 = document.createElement('td');
                td1.innerHTML = jsonString[i].nomeUsuario;
                var tr2 = document.createElement('tr');
                var td2 = document.createElement('td');
                td2.innerHTML = jsonString[i].loginUsuario;
                var tr3 = document.createElement('tr');
                var td3 = document.createElement('td');
                td3.innerHTML = `<td class="td-actions" id="tdClassAction" value=""><button type="button" rel="tooltip" title="Editar" class="btn btn-just-icon btn-link btn-sm" onclick="editarFuncionario(${jsonString[i].codUsuario})"><i class="material-icons">edit</i></button><button type="button" rel="tooltip" title="Remover" class="btn btn-danger btn-link btn-sm" onclick="excluirFuncionarioMaquina(${jsonString[i].codUsuario})"><i class="material-icons">close</i></button></td>`;
                tr.appendChild(td);
                selectFuncionario.appendChild(tr);
                tr.appendChild(td1);
                selectFuncionario.appendChild(tr1);
                tr.appendChild(td2);
                selectFuncionario.appendChild(tr2);
                tr.appendChild(td3);
                selectFuncionario.appendChild(tr3);
                
            }

            
        }
    }
    ajax.send();
}

function excluirFuncionarioMaquina(cod){
        
    let ajax = new XMLHttpRequest();
        let params = "codFuncionario=" + cod;

        ajax.open("POST", "http://localhost:3000/excluirFuncionarioMaquina");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                
                var jsonString = JSON.parse(ajax.responseText);
                if(jsonString.affectedRows > 0){
                    excluirFuncionario(cod);
                }else{
                    alert("Ocorreu um erro ao excluir o usuário.");
                }
            }
    
        }
    ajax.send(params);
}

function excluirFuncionario(cod){
        
    let ajax = new XMLHttpRequest();
        let params = "codFuncionario=" + cod;

        ajax.open("POST", "http://localhost:3000/excluirFuncionario");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                
                var jsonString = JSON.parse(ajax.responseText);
                if(jsonString.affectedRows > 0){
                    alert("Usuário excluído com sucesso.");
                    window.location.assign('../examples/tools.html');
                }else{
                    alert("Ocorreu um erro ao excluir o usuário.");
                }
            }
    
        }
    ajax.send(params);
}


formFuncionario.addEventListener("submit", addFuncionario);