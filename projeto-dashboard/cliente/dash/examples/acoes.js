

function sair(){
    window.location.assign('../../index.html');
}

function getAvgComponents(cod){

            tableMaquina.style.display = 'none';

            fetch("http://localhost:3000/listarDadosMem", { 
        
            method: "POST", 

            body: JSON.stringify({  
                codMaquina: cod 
            }), 

            headers: { 
                "Content-type": "application/json; charset=UTF-8"
            } 
        }).then(response =>

            response.json().then(res => {
                const processos = res
                gerarGraficoMem(Math.round(processos[0].mediaMem));
            }))

            fetch("http://localhost:3000/listarDadosCpu", { 
                
                method: "POST", 
                
                body: JSON.stringify({  
                    codMaquina: cod 
                }), 
                
                headers: { 
                    "Content-type": "application/json; charset=UTF-8"
                } 
            }).then(response =>
            
            response.json().then(res => {
                const processos = res
                gerarGraficoCpu(Math.round(processos[0].mediaCpu));
                
            }))



}




