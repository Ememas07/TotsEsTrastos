function comprovar() {
    var dd = parseInt(document.getElementById("dia").value);
    var mm = parseInt(document.getElementById("mes").value);
    var aa = parseInt(document.getElementById("any").value);
    var valid = true
    if (dd > 30 || dd < 0) {
        valid = false
        alert("El dia no es correcte")
    }
    if (mm > 12 || mm < 0) {
        valid = false
        alert("El mes no es correcte")
    }
    if (aa < 0) {
        valid = false
        alert("L' any no es correcte")
    }
    if (valid == true) {
        alert("La data es correcta")
    }
}
