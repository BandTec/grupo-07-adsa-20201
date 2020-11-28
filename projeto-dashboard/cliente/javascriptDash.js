

let divCheck = document.querySelector('#checkBoxes');

function listarComponenteMaquina(){
    divCheck.innerHTML = "";
    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/listarComponenteMaquina",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){
            
            var jsonString = JSON.parse(ajax.responseText);
            for(let i=0;i<jsonString.length;i++){

                divCheck.innerHTML += `<label class="form-check-label">
                <input class="form-check-input" type="checkbox" value="${jsonString[i].codComponente}" name="pacote" id="pacote">
                ${jsonString[i].nomeComponente} - ${jsonString[i].descComponente}
                  <span class="form-check-sign">
                  <span class="check"></span>
                </span>
              </label><br><br>`;
              
            }
        }
    }
    ajax.send();
}

let divCheckMaquina = document.querySelector('#checkBoxesMaquina');

function listarFuncionarioMaquina(){
  divCheckMaquina.innerHTML = "";
    let ajax = new XMLHttpRequest();
    ajax.open("GET","http://localhost:3000/listarFuncionarioMaquina",true);
    ajax.onreadystatechange =function(){
        if(ajax.readyState==XMLHttpRequest.DONE){
            
            var jsonString = JSON.parse(ajax.responseText);
            for(let i=0;i<jsonString.length;i++){

              divCheckMaquina.innerHTML += `<label class="form-check-label">
                <input class="form-check-input" type="checkbox" value="${jsonString[i].codMaquina}" name="pacoteMaquina" id="pacoteMaquina">
                ${jsonString[i].nomeMaquina} - ${jsonString[i].modeloMaquina}
                  <span class="form-check-sign">
                  <span class="check"></span>
                </span>
              </label><br><br>`;
              
            }
        }
    }
    ajax.send();
}
