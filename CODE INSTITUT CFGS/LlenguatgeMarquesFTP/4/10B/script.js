window.onload = (event) => {
    text = document.getElementById('text');
    colors = ['vermell', 'groc', 'verd', 'blau'];
    colors.forEach(element => {
        quadrat = document.getElementById(element);
        quadrat.addEventListener('mouseover', function () {
            text.innerHTML = "Damunt el " + element;
        });
        quadrat.addEventListener('mouseout', function () {
            text.innerHTML = "Damunt cap";
        });
    });
};