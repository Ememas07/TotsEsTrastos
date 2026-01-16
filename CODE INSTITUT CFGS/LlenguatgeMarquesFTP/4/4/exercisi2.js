function sumarSegon() {
    var hh = parseInt(document.getElementById("hh").value)
    var mm = parseInt(document.getElementById("mm").value)
    var ss = parseInt(document.getElementById("ss").value)
    ss += 1
    if (ss >= 60) {
        mm += 1
        ss = 0
    }
    if (mm >= 60) {
        hh += 1
        mm = 0
    }
    if (hh > 23) {
        hh = 0
    }
    alert("Un segon després seràn les " + hh + ":" + mm + ":" + ss)
}
