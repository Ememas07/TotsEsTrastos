var perfil_usuario = {
    "nombre": "NombreUsuario",
    "red_social": [
        {
            "descripcion": "twitter",
            "link": "https://twitter.com"
        },
        {
            "descripcion": "facebook",
            "link": "https://www.facebook.com"
        },
        {
            "descripcion": "instagram",
            "link": "https://www.instagram.com"
        }
    ]
}

perfil_usuario.red_social.forEach(element => {
    alert("Mi " + element.descripcion + " es " + element.link)
});
