let nomePrograma = document.querySelector('#nomePrograma');
let formPrograma = document.querySelector("#form-programa");

function addPrograma(evento) {
    evento.preventDefault();
    let ajax = new XMLHttpRequest();
        let params = "nomePrograma=" + nomePrograma.value;

        ajax.open("POST", "http://localhost:3000/addPrograma");
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
}

let selectPrograma = document.querySelector('#tablePrograma');
let textDangerPrograma = document.querySelector('#textDangerPrograma');

function listarPrograma(){
    selectPrograma.innerHTML = "";
    textDangerPrograma.innerHTML = "";
    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/listarPrograma",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){
            
            //console.log(ajax.responseText);
            jsonString = JSON.parse(ajax.responseText);
            var th1 = document.createElement('th');
            var th2 = document.createElement('th');
            var th4 = document.createElement('th');
            th1.innerHTML = "Código";
            th2.innerHTML = "Nome";
            th4.innerHTML = "Ação";
            textDangerPrograma.appendChild(th1);
            textDangerPrograma.appendChild(th2);
            textDangerPrograma.appendChild(th4);
            selectPrograma.appendChild(textDangerPrograma);
            for(let i=0;i<jsonString.length;i++){
                var tr = document.createElement('tr');
                var td = document.createElement('td');
                td.innerHTML = jsonString[i].codPrograma;
                var tr1 = document.createElement('tr');
                var td1 = document.createElement('td');
                td1.innerHTML = jsonString[i].nomePrograma;
                var tr3 = document.createElement('tr');
                var td3 = document.createElement('td');
                td3.innerHTML = `<td class="td-actions" id="tdClassAction" value=""><button type="button" rel="tooltip" title="Editar" class="btn btn-just-icon btn-link btn-sm" onclick="editarPrograma(${jsonString[i].codPrograma})"><i class="material-icons">edit</i></button><button type="button" rel="tooltip" title="Remover" class="btn btn-danger btn-link btn-sm" onclick="exluirPrograma(${jsonString[i].codPrograma})"><i class="material-icons">close</i></button></td>`;
                tr.appendChild(td);
                selectPrograma.appendChild(tr);
                tr.appendChild(td1);
                selectPrograma.appendChild(tr1);
                tr.appendChild(td3);
                selectPrograma.appendChild(tr3);
                
            }

            
        }
    }
    ajax.send();
}

function exluirPrograma(cod){
    let ajax = new XMLHttpRequest();
        let params = "codPrograma=" + cod;

        ajax.open("POST", "http://localhost:3000/excluirPrograma");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                //console.log(ajax.responseText);
                var jsonString = JSON.parse(ajax.responseText);
                if(jsonString.affectedRows > 0){
                    alert("Programa excluído com sucesso.");
                    window.location.assign('../examples/tools.html');
                }else{
                    alert("Ocorreu um erro ao excluir o programa.");
                }
            }
    
        }
    ajax.send(params);
}

formPrograma.addEventListener("submit", addPrograma);