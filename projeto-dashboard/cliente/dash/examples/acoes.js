

function sair(){
    window.location.assign('../../index.html');
}

function verDetalhes(cod){
    alert("chegou aqui");
    let ajax = new XMLHttpRequest();
    let params = "codMaquina=" + cod;

    ajax.open("POST", "http://localhost:3000/listarDadosCpu");
    ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    ajax.onreadystatechange = function () {
        if (ajax.status == 200 & ajax.readyState == 4) {
            
            var jsonString = JSON.parse(ajax.responseText);
            console.log(jsonString);
        }

    }
ajax.send(params);

}

