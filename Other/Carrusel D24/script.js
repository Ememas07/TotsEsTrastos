var index = 1;
var frecuencia = 150;
function showImagenes() {
    var cantidad = 108;
    if (index < cantidad) {
        index++;
    } else {
        index = 1;
    }
    var imatge = "media/image" + index + ".png";
    document.getElementsByClassName("image")[0].setAttribute("src", imatge)
}

function activar() {
    clearInterval(thing);
    var frecuencia = parseInt(document.getElementById("freq").value)
    var thing = setInterval(showImagenes, frecuencia)
}