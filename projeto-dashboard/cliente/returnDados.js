
    let formlogin = document.querySelector('#form-login');
    let login = document.querySelector('#login');
    let senhalogin = document.querySelector('#senha');
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



    formlogin.addEventListener("submit", user);
 
    