

function sair(){
    window.location.assign('../../index.html');
}

function getAvgComponents(cod){
            
            rowMaquinas.style.display = 'none';
            col1.style.display = 'block';
            col2.style.display = 'block';

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
                console.log(processos);
                if(processos[0][0].mediaMem < processos[1][0].mediaMemTotal){
                    memMedia.innerHTML = "Abaixo da média geral ("+ processos[1][0].mediaMemTotal.toFixed(2)+"%)";
                }else {
                    memMedia.innerHTML = "Acima da média geral ("+processos[1][0].mediaMemTotal.toFixed(2)+"%)";
                }
                gerarGraficoMem(processos[0][0].mediaMem, processos[1][0].mediaMemTotal);
                
            }))

            fetch("http://localhost:3000/listarDadosCpu", { 
                
                method: "POST", 
                
                body: JSON.stringify({  
                    codMaquina: cod,
                    cod1: cod
                }), 
                
                headers: { 
                    "Content-type": "application/json; charset=UTF-8"
                } 
            }).then(response =>
            
            response.json().then(res => {
                const processos = res
                console.log(processos);
                if(processos[0][0].mediaCpu < processos[1][0].mediaCpuTotal){
                    cpuMedia.innerHTML = "Abaixo da média geral ("+ processos[1][0].mediaCpuTotal.toFixed(2)+"%)";
                }else {
                    cpuMedia.innerHTML = "Acima da média geral ("+ processos[1][0].mediaCpuTotal.toFixed(2)+"%)";
                }
                gerarGraficoCpu(processos[0][0].mediaCpu, processos[1][0].mediaCpuTotal);
                
            }))

}






