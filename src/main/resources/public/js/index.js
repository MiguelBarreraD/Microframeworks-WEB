document.addEventListener('DOMContentLoaded', function () { 

    const form = document.getElementById('movieForm');
    const input = document.getElementById('movieInput');
    const resultTable = document.getElementById('resultTable');

    form.addEventListener('submit', function (event) {
        event.preventDefault();
        const nameMovie = input.value;
        const site = "http://www.omdbapi.com/?apikey=2c3152c3&t=" + nameMovie;

        fetch(site)
            .then(response => response.json())
            .then(data => {
                const keys = Object.keys(data);
                const tableContent = keys.map(key => `<tr><td>${key}</td><td>${data[key]}</td></tr>`).join('');
                resultTable.innerHTML = `<table border=1>${tableContent}</table>`;
            })
            .catch(error => console.error('Error al realizar la consulta:', error));
    });
});