
function comprobarSeleccio() {
    botons = document.getElementsByName('opcio')
    botons.forEach(element => {
        if (element.checked == true) {
            alert("L'element " + element.id + " esta actiu")
        }
    });
}