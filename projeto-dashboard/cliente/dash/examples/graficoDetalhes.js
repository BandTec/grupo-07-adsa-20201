
var ctx = document.getElementById('ChartCpu');
var ctz = document.getElementById('ChartMem');
function gerarGraficoCpu(valorCpu, valorTotalCpu, nome){

var myBarChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: 
        [
        nome, "Média geral"
        ],

        datasets: [{
            label: ['Média diária utilização de CPU (%)'],
            data: [ 
            valorCpu.toFixed(2), valorTotalCpu.toFixed(2)
        ],
            backgroundColor: [
                '#596275',
                '#c8d6e5'
            ],
            borderColor: [
                '#596275',
                '#c8d6e5'
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





function gerarGraficoMem(valorMem, valorMemTotal, nome){

    var myBarChart = new Chart(ctz, {
        type: 'bar',
        data: {
            labels: 
            [
            nome, "Média Geral"
            ],
    
            datasets: [{
                label: ['Média diária utilização de memória (%)'],
                data: [ 
                valorMem.toFixed(2), valorMemTotal.toFixed(2)
            ],
                backgroundColor: [
                    '#596275',
                    '#c8d6e5'
                ],
                borderColor: [
                    '#596275',
                    '#c8d6e5'
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