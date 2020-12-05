let formMaquina = document.querySelector('#form-maquina');
let nomeMaquina = document.querySelector('#nomeMaquina');
let modeloMaquina = document.querySelector('#modeloMaquina');

function addMaquina(evento) {

        evento.preventDefault();
        let ajax = new XMLHttpRequest();
        var date;
        date = new Date();
        date = date.getUTCFullYear() + '-' +
        ('00' + (date.getUTCMonth()+1)).slice(-2) + '-' +
        ('00' + date.getUTCDate()).slice(-2) + ' ' + 
        ('00' + date.getUTCHours()).slice(-2) + ':' + 
        ('00' + date.getUTCMinutes()).slice(-2) + ':' + 
        ('00' + date.getUTCSeconds()).slice(-2);
        
        let params = "nomeMaquina=" + nomeMaquina.value + "&modeloMaquina=" + modeloMaquina.value + "&dataCadastro=" + date;
    
            ajax.open("POST", "http://localhost:3000/addMaquina");
            ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
            ajax.onreadystatechange = function () {
                if (ajax.status == 200 & ajax.readyState == 4) {    
                    //console.log(ajax.responseText);
                    var jsonString = JSON.parse(ajax.responseText);
                    if((jsonString.affectedRows) > 0){
                        alert("Máquina cadastrada com sucesso");
                        //window.location.assign('../examples/tools.html');
                        buscarUltimaMaquina();
                       
                    }else {
                        alert("alert");
                        
                    }

                }
        
            }
    
        
        ajax.send(params);
}


function buscarUltimaMaquina(){

    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/buscarUltimaMaquina",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){
            
            console.log(ajax.responseText);
            jsonString = JSON.parse(ajax.responseText);

            if(jsonString[0].UltimoRegistro > 0){
                getValues(jsonString[0].UltimoRegistro);
            }else{
                alert("Ocorreu um erro"); 
            }

        }
    }
    ajax.send();
}

function getValues(codMaquina) {
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
        let params = "pacote="+ aray[i] + "&fkMaquina=" + codMaquina;
        ajax.open("POST", "http://localhost:3000/getValues");
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

function excluirMaquina(cod){
        
    let ajax = new XMLHttpRequest();
        let params = "codMaquina=" + cod;

        ajax.open("POST", "http://localhost:3000/excluirMaquina");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                
                var jsonString = JSON.parse(ajax.responseText);
                if(jsonString.affectedRows > 0){
                    alert("Máquina excluída com sucesso.");
                    window.location.assign('../examples/tools.html');
                }else{
                    alert("Ocorreu um erro ao excluir a máquina.");
                }
            }
    
        }
    ajax.send(params);
}

let selectMaquina = document.querySelector('#tableMaquina');
let textDangerMaquina = document.querySelector('#textDangerMaquina');

function listarMaquina(){
    selectMaquina.innerHTML = "";
    textDangerMaquina.innerHTML = "";
    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/listarMaquina",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){
            
            console.log(ajax.responseText);
            jsonString = JSON.parse(ajax.responseText);
            var th1 = document.createElement('th');
            var th2 = document.createElement('th');
            var th3 = document.createElement('th');
            var th4 = document.createElement('th');
            var th5 = document.createElement('th');
        
            th1.innerHTML = "Código";
            th2.innerHTML = "Nome";
            th3.innerHTML = "Modelo";
            th4.innerHTML = "Cadastro";
            th5.innerHTML = "Ação";
            
            textDangerMaquina.appendChild(th1);
            textDangerMaquina.appendChild(th2);
            textDangerMaquina.appendChild(th3);
            textDangerMaquina.appendChild(th4);
            textDangerMaquina.appendChild(th5);
            selectMaquina.appendChild(textDangerMaquina);



            for(let i=0;i<jsonString.length;i++){

                var tr = document.createElement('tr');
                var td = document.createElement('td');
                td.innerHTML = jsonString[i].codMaquina;
                var tr1 = document.createElement('tr');
                var td1 = document.createElement('td');
                td1.innerHTML = jsonString[i].userMaquina;
                var tr2 = document.createElement('tr');
                var td2 = document.createElement('td');
                td2.innerHTML = jsonString[i].modeloMaquina;
                var tr3 = document.createElement('tr');
                var td3 = document.createElement('td');
                td3.innerHTML = jsonString[i].dataCadastradoMaquina;
                var tr5 = document.createElement('tr');
                var td5 = document.createElement('td');
                
                td5.innerHTML = `<td class="td-actions" id="tdClassAction" value=""><button type="button" rel="tooltip" title="Editar" class="btn btn-just-icon btn-link btn-sm" onclick="editarMaquina(${jsonString[i].codMaquina})"><i class="material-icons">edit</i></button><button type="button" rel="tooltip" title="Remover" class="btn btn-danger btn-link btn-sm" onclick="excluirMaquina(${jsonString[i].codMaquina})"><i class="material-icons">close</i></button></td>`;
                tr.appendChild(td);
                selectMaquina.appendChild(tr);
                tr.appendChild(td1);
                selectMaquina.appendChild(tr1);
                tr.appendChild(td2);
                selectMaquina.appendChild(tr2);
                tr.appendChild(td3);
                selectMaquina.appendChild(tr3);
                tr.appendChild(td5);
                selectMaquina.appendChild(tr5);
                
               
            }
                
            
        }
    }
    ajax.send();
}
    

   formMaquina.addEventListener("submit", addMaquina); 