
function validaEnvia() {
    text = document.getElementById('text');
    age = document.getElementById('age');
    preference = document.getElementById('preference');
    if (validarEntero(age.value) == false) {
        return false;
    }
    if (text.value.length == 0) {
        alert("Has d'introduir un nom!")
        return false;
    }
    if (preference.value == '0') {
        alert("Has d'introduir una preferencia!")
        return false;
    }
    return true;
}
function validarEntero(valor) {
    if (valor < 18) {
        alert("L'edat introduida ha de ser major a 18!")
        return false;
    }
    return true;
}