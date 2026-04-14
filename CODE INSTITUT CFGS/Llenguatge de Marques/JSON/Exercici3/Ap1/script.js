function presionarBoton() {
    var cadena = '{' + '"libro":"la ultima resupuesta",' +
        '"año":"2010",' +
        '"autores":["Francesc Miralles","Alex Rovira"],' +
        '"editorial":"Debolsillo",' + '}';
    var miLibro = eval('(' + cadena + ')');
    alert('Título: ' + miLibro.libro)
    alert('Año de publicacion: ' + miLibro.año)
    alert('Autor 1: ' + miLibro.autores[0])
    alert('Autor 2: ' + miLibro.autores[1])
}