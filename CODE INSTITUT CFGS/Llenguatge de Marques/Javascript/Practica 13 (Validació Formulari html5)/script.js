
function validaEnvia() {
    botons = document.getElementsByName('opcio')
    hola = false;
    botons.forEach(element => {
        if (element.checked == true) {
            hola = true;
        }
    });
    if (hola == false) {
        alert("has de seleccionar una opcio!");
        return false;
    }
}