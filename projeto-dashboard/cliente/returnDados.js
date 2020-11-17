

// --- BUSCAR UM USUÁRIO ---


//let msg = document.querySelector('#msgErroCadastro');
//let form = document.querySelector("#formulario");
//let nome = document.querySelector('#input_nome');
//let email = document.querySelector('#input_email');
//let senha = document.querySelector('#input_senha');
//let confsenha = document.querySelector('#input_confsenhacad');


// --- ADICIONAR USUÁRIO ---

/*
function addUser(evento) {
    evento.preventDefault();
    let ajax = new XMLHttpRequest();
    let contador = 0;

    if (senha.value != confsenha.value || senha.value == '' || confsenha.value == '') {
        msg.innerHTML += 'As senhas não conferem<br>';
        confsenha.style.borderColor = '#ff3838';
        senha.style.borderColor = '#ff3838';
        contador++;
    }

    if ((email.value).indexOf('@') < 0 || (email.value).indexOf('.com') < 0 || (email.value).length < 7 || email.value == '') {
        email.style.borderColor = '#ff3838';
        msg.innerHTML += 'Email inválido<br>';
        contador++;
    }

    if (senha.value == '' && confsenha.value == '' && nome.value == '' && email.value == '') {
        msg.innerHTML += 'Preencha os campos<br>';
        contador++;
    }

    if (contador == 0) {

        let params = "nome=" + nome.value + "&email=" + email.value + "&senha=" + senha.value;

        ajax.open("POST", "http://localhost:3000/addUser");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                console.log(ajax.responseText);
            }

        }

        ajax.send(params);
        alert('Cadastro efetuado com sucesso');
        divrecuperacao.style.display = 'none';
        divcadastro.style.display = 'none';
        divlogin.style.display = 'block';


    }


} */

    //VERIFICAR USUÁRIO NO BANCO
        //VARIÁVEIS
        let formlogin = document.querySelector('#form-login');
        let login = document.querySelector('#login');
        let senhalogin = document.querySelector('#senha');
        //VARIAVEIS

        function user(evento) {
            
            evento.preventDefault();
            let ajax = new XMLHttpRequest();
                let params = "login=" + login.value + "&senha=" + senhalogin.value;

                ajax.open("POST", "http://localhost:3000/user");
                ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                ajax.onreadystatechange = function () {
                    if (ajax.status == 200 & ajax.readyState == 4) {    
                        console.log(ajax.responseText);
                        var jsonString = JSON.parse(ajax.responseText);
                        if((jsonString[0].id) > 0){
                            window.location.assign('../dash/examples/dashboard.html');
                        }else {
                            msgErroLogin.innerHTML =  'Email ou login incorretos. Por favor, tente novamente';
                            msgErroLogin.style.color = 'red';
                            
                        }

                    }
            
                }

            
            ajax.send(params);

        }
    
    //VERIFICAR USUARIOS NO BANCO
/*
let formRecado = document.querySelector("#formMensagem");
let nomeMensagem = document.querySelector('#nomerecado');
let emailMensagem = document.querySelector('#emailrecado');
let textoMensagem = document.querySelector('#textorecado');

function addMsg(evento) {
    evento.preventDefault();
    let ajax = new XMLHttpRequest();

    if ((emailMensagem.value).indexOf('@') < 0 || (emailMensagem.value).indexOf('.com') < 0 || (emailMensagem.value).length < 7 || emailMensagem.value == '') {
        msgErroContato.innerHTML += 'Email inválido.<br>';

    }else {
        let params = "nomeMensagem=" + nomeMensagem.value + "&emailMensagem=" + emailMensagem.value + "&textoMensagem="+ textoMensagem.value;

        ajax.open("POST", "http://localhost:3000/addMsg");
        ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        ajax.onreadystatechange = function () {
            if (ajax.status == 200 & ajax.readyState == 4) {
                console.log(ajax.responseText);
                var jsonString = JSON.parse(ajax.responseText);
                if((jsonString.affectedRows) > 0){
                    msgErroContato.innerHTML = 'Mensagem enviada com sucesso.';
                    document.querySelector('#nomerecado').value = "";
                    document.querySelector('#emailrecado').value = "";
                    document.querySelector('#textorecado').value = "";
                }else {
                    msgErroLogin.innerHTML =  'Erro ao enviar mensagem.';

                }
            }
    
        }
        ajax.send(params);
    }
    

}
*/
//form.addEventListener("submit", addUser);
formlogin.addEventListener("submit", user);
//formRecado.addEventListener("submit", addMsg);
