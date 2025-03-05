import java.util.Random;
import javax.swing.JOptionPane;

public class ExercisiArrays08 {
    public static void main(String[] args) {
        Random random = new Random();
        
        // Pedir tamaño del array
        String tamañoInput = JOptionPane.showInputDialog(null, "Introduce el tamaño del array:");
        int tamaño = Integer.parseInt(tamañoInput);
        
        // Validar que el tamaño sea positivo
        while (tamaño <= 0) {
            tamañoInput = JOptionPane.showInputDialog(null, "El tamaño debe ser mayor que 0. Introduce el tamaño del array:");
            tamaño = Integer.parseInt(tamañoInput);
        }

        // Pedir el dígito final (0-9)
        String digitoInput = JOptionPane.showInputDialog(null, "Introduce el dígito final (0-9):");
        int digito = Integer.parseInt(digitoInput);
        
        // Validar que el dígito esté entre 0 y 9
        while (digito < 0 || digito > 9) {
            digitoInput = JOptionPane.showInputDialog(null, "El dígito debe estar entre 0 y 9. Introduce el dígito final:");
            digito = Integer.parseInt(digitoInput);
        }

        // Crear y llenar el array original con números aleatorios
        int[] arrayOriginal = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            arrayOriginal[i] = random.nextInt(300) + 1; // Números entre 1 y 300
        }

        // Contar cuántos números terminan en el dígito especificado
        int contador = 0;
        for (int num : arrayOriginal) {
            if (num % 10 == digito) {
                contador++;
            }
        }

        // Crear array para los números que terminan en el dígito
        int[] arrayResultado = new int[contador];
        
        // Llenar el array resultado
        int indice = 0;
        for (int num : arrayOriginal) {
            if (num % 10 == digito) {
                arrayResultado[indice] = num;
                indice++;
            }
        }

        // Preparar mensaje con resultados
        String mensaje = "Array original:\n" + arrayToString(arrayOriginal) +
                        "\n\nNúmeros que terminan en " + digito + ":\n" + 
                        (contador > 0 ? arrayToString(arrayResultado) : "No se encontraron números");

        // Mostrar resultado
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Método para convertir array a String
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}