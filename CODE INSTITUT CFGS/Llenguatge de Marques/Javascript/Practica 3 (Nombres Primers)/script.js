function nombrePrimer() {
    var n = parseInt(document.getElementById("n1").value);
    if (n <= 1) {
        return false;
    }
    if (n == 2) {
        return true;
    }
    for (let i = 2, s = Math.sqrt(n); i <= s; i++) {
        if (n % i === 0) return false;
    }
    return true;
}

function comprovar() {
    if (nombrePrimer()) {
        alert("El nombre es primer")
    } else {
        alert("El nombre no es primer")
    }
}