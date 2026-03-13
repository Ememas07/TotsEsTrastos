
function validaEnvia() {
    nom = document.getElementById('text');
    surname = document.getElementById('surname');
    age = document.getElementById('age');
    matricula = document.getElementById('matricula');
    province = document.getElementById('province');
    if (nom.value.length == 0) {
        alert("Has d'introduir un nom!")
        return false;
    }
    if (surname.value.length == 0) {
        alert("Has d'introduir un nom!")
        return false;
    }
    if (validarEdat(age.value) == false) {
        return false;
    }
    if (validarMatricula(matricula.value) == false) {
        alert("Has d'introduir una Matricula valida!")
        return false;
    }
    if (province.value == '0') {
        alert("Has d'introduir una provincia!")
        return false;
    }
    return true;
}
function validarEdat(valor) {
    if (isNaN(valor)) {
        alert("No has posat una edat valida!")
        return false;
    }
    if (valor < 0) {
        alert("L'edat introduida ha de ser major a 0!")
        return false;
    }
    if (valor > 90) {
        alert("L'edat introduida ha de ser menor a 90!")
        return false;
    }
    return true;
}
function validarMatricula(text) {
    const re = /\d{4} [A-z]{3}/;
    return re.test(text);
}