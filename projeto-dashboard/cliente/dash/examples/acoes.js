let improperProcess = document.getElementById("improper-process");
window.onload = function() {
    maquinasAtivas();
  };

function sair(){
    window.location.assign('../../index.html');
}

fetch("http://localhost:3000/getImproperProcess").then(response => {

    if(response.ok){
        response.json().then(res =>{
            let count = res[0].count;

            improperProcess.innerHTML = `${count}  <small>programas</small>`;
        })
    }

})
function maquinasAtivas(){

    let maquinasAtivas = [];

    fetch("http://localhost:3000/getMaquinasAtivas").then(response => {

        if(response.ok){
            response.json().then(res =>{
                
                let ativas = res.length;
                qtdConectados.innerHTML = ativas + " <small>pessoas</small>";
                res.forEach(elem => {
                   maquinasAtivas.push(elem.maquina);
                   console.log(document.getElementById(String(elem.maquina)));
                   try {
                    document.getElementById(String(elem.maquina));

                        document.getElementById(String(elem.maquina)).className = 'material-icons text-success';
                     
                } catch (error) {
                    console.log(document.getElementById(String(elem.maquina)))
                }


                });
    
            })
        }
    
    })
    //console.log(maquinasAtivas)
    return maquinasAtivas;
}


function getAvgComponents(cod, nome){
            
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
                    if(processos[1][0].mediaMemTotal - processos[0][0].mediaMem < 10){
                    memMedia.innerHTML = "Dentro da média geral ("+ processos[1][0].mediaMemTotal.toFixed(2)+"%)";
                    document.getElementById("corCardStatusMem").className = "card-header card-header-icon card-header-success";
                    iconCardStatusMem.innerHTML = "check";
                    }else{
                    memMedia.innerHTML = "Abaixo da média geral ("+ processos[1][0].mediaMemTotal.toFixed(2)+"%)";
                    document.getElementById("corCardStatusMem").className += "card-header-danger";
                    iconCardStatusMem.innerHTML = "arrow_downward";
                    }
                    
                }else {
                    if(processos[0][0].mediaMem - processos[1][0].mediaMemTotal < 10){
                    memMedia.innerHTML = "Dentro da média geral ("+ processos[1][0].mediaMemTotal.toFixed(2)+"%)";
                    document.getElementById("corCardStatusMem").className = "card-header card-header-icon card-header-success";
                    iconCardStatusMem.innerHTML = "check";
                    }else {
                    memMedia.innerHTML = "Acima da média geral ("+ processos[1][0].mediaMemTotal.toFixed(2)+"%)";
                    document.getElementById("corCardStatusMem").className = "card-header card-header-icon card-header-danger";
                    iconCardStatusMem.innerHTML = "arrow_upward";
                    }
                }
                gerarGraficoMem(processos[0][0].mediaMem, processos[1][0].mediaMemTotal, nome);
                
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
                    if(processos[1][0].mediaCpuTotal - processos[0][0].mediaCpu < 10){
                        cpuMedia.innerHTML = "Dentro da média geral ("+ processos[1][0].mediaCpuTotal.toFixed(2)+"%)";
                        document.getElementById("corCardStatusCpu").className = "card-header card-header-icon card-header-success";
                        iconCardStatusCpu.innerHTML = "check";
                        }else{
                        cpuMedia.innerHTML = "Abaixo da média geral ("+ processos[1][0].mediaCpuTotal.toFixed(2)+"%)";
                        document.getElementById("corCardStatusCpu").className += "card-header card-header-icon card-header-danger";
                        iconCardStatusCpu.innerHTML = "arrow_downward";
                        }
                }else {
                    if(processos[0][0].mediaCpu - processos[1][0].mediaCpuTotal < 10){
                        cpuMedia.innerHTML = "Dentro da média geral ("+ processos[1][0].mediaCpuTotal.toFixed(2)+"%)";
                        document.getElementById("corCardStatusCpu").className = "card-header card-header-icon card-header-success";
                        iconCardStatusCpu.innerHTML = "check";
                        }else{
                        cpuMedia.innerHTML = "Acima da média geral ("+ processos[1][0].mediaCpuTotal.toFixed(2)+"%)";
                        document.getElementById("corCardStatusCpu").className += "card-header card-header-icon card-header-danger";
                        iconCardStatusCpu.innerHTML = "arrow_upward";
                        }
                    
                }
                gerarGraficoCpu(processos[0][0].mediaCpu, processos[1][0].mediaCpuTotal, nome);
                
            }))

}






