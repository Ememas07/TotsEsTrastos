import javax.swing.JOptionPane;

public class ExercisiArrays11 {
    // 11) Crea una aplicación que pida un numero por teclado y después
    // comprobaremos si el numero introducido es capicua, es decir, que se lee igual
    // sin importar la dirección. Por ejemplo, si introducimos 30303 es capicua, si
    // introducimos 30430 no es capicua. Piensa como puedes dar la vuelta al número.
    // Una forma de pasar un número a un array es esta
    // Character.getNumericValue(cadena.charAt(posicion)).

    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog("Introduce un número para comprobar si es capicúa: ");

        if (esCapicua(numero)) {
            System.out.println(numero + " es capicúa");
        } else {
            System.out.println(numero + " no es capicúa");
        }

    }

    // Método para comprobar si un número es capicúa
    private static boolean esCapicua(String numero) {
        // Convertir string a array de caracteres
        char[] digitos = numero.toCharArray();
        int[] arrayNumeros = new int[digitos.length];

        // Convertir caracteres a valores numéricos
        for (int i = 0; i < digitos.length; i++) {
            arrayNumeros[i] = Character.getNumericValue(digitos[i]);
        }

        // Verificar si es capicúa
        int izquierda = 0;
        int derecha = arrayNumeros.length - 1;

        while (izquierda < derecha) {
            if (arrayNumeros[izquierda] != arrayNumeros[derecha]) {
                return false;
            }
            izquierda++;
            derecha--;
        }
        return true;
    }
}