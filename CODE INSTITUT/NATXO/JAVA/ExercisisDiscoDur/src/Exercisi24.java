public class Exercisi24 {
    public static void main(String[] args) {
        // 22) Del siguiente String «La lluvia en Sevilla es una maravilla» cuenta
        // cuantas vocales hay en total (recorre el String con charAt).
        // 24) Recorre el String del ejercicio 22 y transforma cada carácter a su código
        // ASCII. Muestralos en linea recta, separados por un espacio entre cada
        // carácter.
        String frase = "La lluvia en Sevilla es una maravilla";
        Integer index = 0;
        String frasecanviada = "";
        while (frase.length() > index) {
            char caracter = frase.charAt(index);
            int ascii = caracter;
            frasecanviada = frasecanviada + " " + ascii;
            index = index + 1;

        }
        System.out.println("Inici" + frasecanviada + " Final");

    }

}