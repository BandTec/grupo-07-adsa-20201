let descComponente = document.querySelector('#descComponente');
let nomeComponente = document.querySelector('#nomeComponente');
let formComponente = document.querySelector("#form-componente");

function addComponente(evento) {
    evento.preventDefault();
let ajax = new XMLHttpRequest();

    if(nomeComponente.value != "" && descComponente.value != ""){

    
    let params = "nomeComponente=" + nomeComponente.value + "&descComponente=" + descComponente.value;

    ajax.open("POST", "http://localhost:3000/addComponente");
    ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    ajax.onreadystatechange = function() {
        if (ajax.status == 200 & ajax.readyState == 4) {
            var jsonString = JSON.parse(ajax.responseText);
            if((jsonString.affectedRows) > 0){
                alert("Cadastrado com sucesso");
                window.location.assign('../examples/tools.html');
            }else {
                alert("Houve um erro ao cadastrar");

            }
        }

    }    
    ajax.send(params);

    }else {
        alert("Preencha os campos corretamente.");
    }
}

//let btnProdutos = document.querySelector('#textorecado');
let select = document.querySelector('#tableComponentes');
let textDanger = document.querySelector('#textDanger');
function listarComponentes(){
    select.innerHTML = "";
    textDanger.innerHTML = "";
    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/listarComponentes",true);
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
            th3.innerHTML = "Descrição";
            th4.innerHTML = "Ação";
            textDanger.appendChild(th1);
            textDanger.appendChild(th2);
            textDanger.appendChild(th3);
            textDanger.appendChild(th4);
            select.appendChild(textDanger);
            for(let i=0;i<jsonString.length;i++){
                var tr = document.createElement('tr');
                var td = document.createElement('td');
                td.innerHTML = jsonString[i].codComponente;
                var tr1 = document.createElement('tr');
                var td1 = document.createElement('td');
                td1.innerHTML = jsonString[i].nomeComponente;
                var tr2 = document.createElement('tr');
                var td2 = document.createElement('td');
                td2.innerHTML = jsonString[i].descComponente;
                var tr3 = document.createElement('tr');
                var td3 = document.createElement('td');
                td3.innerHTML = `<td class="td-actions" id="tdClassAction" value=""><button type="button" rel="tooltip" title="Editar" class="btn btn-just-icon btn-link btn-sm" onclick="editarComponente(${jsonString[i].codComponente})"><i class="material-icons">edit</i></button><button type="button" rel="tooltip" title="Remover" class="btn btn-danger btn-link btn-sm" onclick="exluirComponente(${jsonString[i].codComponente})"><i class="material-icons">close</i></button></td>`;
                tr.appendChild(td);
                select.appendChild(tr);
                tr.appendChild(td1);
                select.appendChild(tr1);
                tr.appendChild(td2);
                select.appendChild(tr2);
                tr.appendChild(td3);
                select.appendChild(tr3);
                
            }

            
        }
    }
    ajax.send();
}

function editarComponente(cod){
    let ajax = new XMLHttpRequest();
        let params = "codComponente=" + cod;

        ajax.open("POST", "http://localhost:3000/editarComponente");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                //console.log(ajax.responseText);
                var jsonString = JSON.parse(ajax.responseText);
                for(let i=0;i<jsonString.length;i++){

                }
            }
    
        }
    ajax.send(params);
}

function exluirComponente(cod){
    let ajax = new XMLHttpRequest();
        let params = "codComponente=" + cod;

        ajax.open("POST", "http://localhost:3000/excluirComponente");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                //console.log(ajax.responseText);
                var jsonString = JSON.parse(ajax.responseText);
                if(jsonString.affectedRows > 0){
                    alert("Componente excluído com sucesso.");
                    window.location.assign('../examples/tools.html');
                }else{
                    alert("Ocorreu um erro ao excluir o componente.");
                }
            }
    
        }
    ajax.send(params);
}

formComponente.addEventListener("submit", addComponente);