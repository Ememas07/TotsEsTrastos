function caraOposada() {
    var dau = parseInt(document.getElementById("dau").value)
    var valor = 0
    if (dau > 6 || dau < 1) {
        alert("ERROR: Nombre Incorrecte")
    } else {
        switch (dau) {
            case 1:
                valor = 6
                break
            case 2:
                valor = 5
                break
            case 3:
                valor = 4
                break
            case 4:
                valor = 3
                break
            case 5:
                valor = 2
                break
            case 6:
                valor = 1
                break
        }
        alert("El valor oposat es: " + valor)
    }
}

