public class Exercisi22 {
    public static void main(String[] args) {
        // 22) Del siguiente String «La lluvia en Sevilla es una maravilla» cuenta
        // cuantas vocales hay en total (recorre el String con charAt).

        String frase = "La lluvia en Sevilla es una maravilla";
        Integer index = 0;
        Integer numerovocals = 0;

        while (frase.length() > index) {
            switch (frase.charAt(index)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    numerovocals = numerovocals + 1;
                    index = index + 1;
                    break;

                default:
                    index = index + 1;

                    break;
            }

        }
        System.out.println("La frase tiene " + numerovocals + " Vocales");
    }
}
