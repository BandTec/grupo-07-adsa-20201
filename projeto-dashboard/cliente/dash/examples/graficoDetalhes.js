
var ctx = document.getElementById('ChartCpu');
var ctz = document.getElementById('ChartMem');
function gerarGraficoCpu(valorCpu, valorTotalCpu){

var myBarChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: 
        [
        "Média (usuario)", "Média Geral"
        ],

        datasets: [{
            label: ['Utilização (usuario)','Utilização (grupo)'],
            data: [ 
            valorCpu.toFixed(2), valorTotalCpu.toFixed(2)
        ],
            backgroundColor: [
                '#d63031',
                '#3c6382'
            ],
            borderColor: [
                '#d63031',
                '#3c6382'
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





function gerarGraficoMem(valorMem, valorMemTotal){

    var myBarChart = new Chart(ctz, {
        type: 'bar',
        data: {
            labels: 
            [
            "Média (usuario)", "Média Geral"
            ],
    
            datasets: [{
                label: ['Utilização (usuario)','Utilização (grupo)'],
                data: [ 
                valorMem.toFixed(2), valorMemTotal.toFixed(2)
            ],
                backgroundColor: [
                    '#d63031',
                    '#3c6382'
                ],
                borderColor: [
                    '#d63031',
                    '#3c6382'
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