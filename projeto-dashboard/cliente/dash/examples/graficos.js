

let ctx = document.getElementById('myChart');
let pizza = document.getElementById('myChart2')
let cpuAvg = document.getElementById('cpu-avg');
let memAvg = document.getElementById('mem-avg');
let memBellow = document.getElementById('ram_bellow');
let memAbove = document.getElementById('ram_above');
let cpuBellow = document.getElementById('cpu_bellow');
let cpuAbove = document.getElementById('cpu_above');

// var myPieChart = new Chart(pizza, {
//     type: 'pie',
//     data: {
//         datasets: [{
//             data: [800, 1200],
//             backgroundColor: ['rgba(255, 99, 132, 0.5)', 'rgba(54, 162, 235, 0.5)']
//         }],
//         labels: ['java', 'outros']
//     }
// });


fetch("http://localhost:3000/getProcessNamebyCount?limit=6").then(response => {

    if (response.ok) {
        response.json().then(res => {
            let processos = res

            var myChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels:

                        [
                            processos[0].nomeProcesso, processos[5].nomeProcesso, processos[3].nomeProcesso,
                            processos[4].nomeProcesso, processos[1].nomeProcesso, processos[2].nomeProcesso
                        ],

                    datasets: [{
                        label: 'Processos mais usados',
                        data: [
                            processos[0].count, processos[5].count, processos[3].count,
                            processos[4].count, processos[1].count, processos[2].count
                        ],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
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

        })
    }
})

fetch("http://localhost:3000/getAvg?comp=cpu").then(response => {

    if (response.ok) {
        response.json().then(res => {
            let avg = res
            cpuAvg.innerHTML = `${Number(avg[0].media).toFixed(2)}%`
        })
    }

})

fetch("http://localhost:3000/getAvg?comp=ram").then(response => {

    if (response.ok) {
        response.json().then(res => {
            let avg = res
            memAvg.innerHTML = `${Number(avg[0].media).toFixed(2)}%`
        })
    }

})

fetch("http://localhost:3000/getBellowAvg?comp=ram").then(response => {

    if (response.ok) {
        response.json().then(res => {
            let listDados = res
            let qtdBellow = 0
            let qtdAbove = 0

            for (let i = 0; i < listDados.length; i++) {
                if (listDados[i].media < Number(String(memAvg.innerHTML).substring(0, 4))) {
                    qtdBellow++
                }
                else if (listDados[i].media > Number(String(memAvg.innerHTML).substring(0, 4))) {
                    qtdAbove++
                }
            }
            memBellow.innerHTML = `<b>Máquinas abaixo da média:</b> ${qtdBellow}`
            memAbove.innerHTML = `<b>Máquinas acima da média:</b> ${qtdAbove}`
        })
    }
})
fetch("http://localhost:3000/getBellowAvg?comp=cpu").then(response => {

    if (response.ok) {
        response.json().then(res => {
            let listDados = res
            let qtdBellow = 0
            let qtdAbove = 0

            for (let i = 0; i < listDados.length; i++) {
                if (listDados[i].media < Number(String(cpuAvg.innerHTML).substring(0, 4))) {
                    qtdBellow++
                }
                else if (listDados[i].media > Number(String(cpuAvg.innerHTML).substring(0, 4))) {
                    qtdAbove++
                }
            }
            cpuBellow.innerHTML = `<b>Máquinas abaixo da média:</b> ${qtdBellow}`
            cpuAbove.innerHTML = `<b>Máquinas acima da média:</b> ${qtdAbove}`
        })
    }
})