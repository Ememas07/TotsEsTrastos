function calcularDNI() {
    var dni = parseInt(document.getElementById("dni").value)
    var lletres = "TRWAGMYFPDXBNJZSQVHLCKE"
    var lletraDNI = lletres.charAt(dni % 23)
    alert("El DNI amb la lletra es "+dni+lletraDNI)
}
