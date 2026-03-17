
function validarForm() {
    nom = document.getElementById('name');
    username = document.getElementById('username');
    country = document.getElementById('country')
    age = document.getElementById('age');
    tic = document.getElementById('tic')
    if (nom.value.length == 0) {
        alert("Has d'introduir un nom!")
        return false;
    }
    if (username.value.length == 0) {
        alert("Has d'introduir un nom d'usuari!")
        return false;
    }
    if (validarPais(country.value) == false) {
        return false;
    }
    if (validarEdat() == false) {
        return false;
    }
    if (tic.checked == false) {
        alert("Has d'acceptar els termes i condicions!")
        return false;
    }
    return true;
}
function validarEdat() {
    pitjat = false;
    botons = document.getElementsByName('age')
    botons.forEach(element => {
        if (element.checked == true) {
            pitjat = true;
        }
    });
    if (pitjat) {
        return true;
    } else {
        alert("Has de seleccionar una edat");
        return false;
    }
}
function validarMatricula(text) {
    const re = /\d{4} [A-z]{3}/;
    return re.test(text);
}
function validarPais(pais) {
    switch (pais) {
        case 'ES':
        case 'PT':
        case 'DK':
        case 'UK':
            return true;
        default:
            alert("Has d'introduir un pais!")
            return false;
    }
}