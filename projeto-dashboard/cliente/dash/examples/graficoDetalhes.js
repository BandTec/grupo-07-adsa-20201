
var ctx = document.getElementById('ChartCpu');
var ctz = document.getElementById('ChartMem');
function gerarGraficoCpu(valorCpu){

    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: 
    
            [
            "Uso de CPU"
            ],
    
            datasets: [{
                label: 'Quantidade de uso',
                data: [ 
                valorCpu
            ],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)'
                    
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });

}

function gerarGraficoMem(valorMem){

    var myChart = new Chart(ctz, {
        type: 'bar',
        data: {
            labels: 
    
            [
            "Uso de memória"
            ],
    
            datasets: [{
                label: 'Quantidade de uso',
                data: [ 
                valorMem
            ],
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)'
                    
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });

}