function activar() {
    paragrafs = document.querySelectorAll("p")
    url = document.createElement("a")
    url.innerHTML = "test"
    url.setAttribute("href", "https://youtube.com/@MarcMas07")
    url.setAttribute("target", "_blank")
    paragrafNou = document.createElement("p")
    paragrafNou.innerHTML = "Aquest paragraf l'hem afegit amb javascript"
    paragrafNou.style = "color:red"
    paragrafs[1].innerHTML = "";
    paragrafs[2].appendChild(url)
    paragrafs[4].appendChild(paragrafNou)

}