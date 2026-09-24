window.onload = (event) => {
    select = document.getElementById('select');
    paragraf = document.getElementById('paragraf');
    select.addEventListener('change', function () {
        paragraf.innerHTML = select.value;
    })
};