
var ctx = document.getElementById('ChartCpu');
var ctz = document.getElementById('ChartMem');

function gerarGraficoCpu(valorCpu){

var myPieChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: 

        [
        "Utilizado",
        "Não utilizado"
        ],

        datasets: [{
            label: 'Quantidade de uso',
            data: [ 
            valorCpu, 100 - valorCpu
        ],
            backgroundColor: [
                'yellow',
                'blue'
                
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

    var myPieChart = new Chart(ctz, {
        type: 'pie',
        data: {
            labels: 
    
            [
            "Utilizado",
            "Não utilizado"
            ],
    
            datasets: [{
                label: 'Quantidade de uso',
                data: [ 
                valorMem, 100 - valorMem
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