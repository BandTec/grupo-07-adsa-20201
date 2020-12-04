

const ctx = document.getElementById('myChart');
const cpuAvg = document.getElementById('cpu-avg');
const memAvg = document.getElementById('mem-avg');

fetch("http://localhost:3000/getProcessNamebyCount").then(response => {

    if(response.ok){
        response.json().then(res => {
            const processos = res

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

    if(response.ok){
        response.json().then(res =>{
            const avg = res
            console.log(avg)
            cpuAvg.innerHTML = `${Number(avg[0].media).toFixed(2)}%`
        })
    }

})

fetch("http://localhost:3000/getAvg?comp=ram").then(response => {

    if(response.ok){
        response.json().then(res =>{
            const avg = res
            console.log(avg)
            memAvg.innerHTML = `${Number(avg[0].media).toFixed(2)}%`
        })
    }

})