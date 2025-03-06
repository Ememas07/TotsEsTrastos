import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays14 {
    // 14) Crear dos arrays, rellenar uno con números y copiarlo al otro usando
    // CopyOf de Arrays.

    public static void main(String[] args) {
        // Crear y rellenar el primer array
        int[] original = new int[5];
        for (int i = 0; i < original.length; i++) {
            String numStr = JOptionPane.showInputDialog("Introduce el número " + (i + 1) + " para el array:");
            original[i] = Integer.parseInt(numStr);
        }

        // Copiar el array usando copyOf
        int[] copia = Arrays.copyOf(original, original.length);

        // Mostrar ambos arrays
        String mensaje = "Array original: " + Arrays.toString(original) + "\n" +
                "Array copiado: " + Arrays.toString(copia);
        JOptionPane.showMessageDialog(null, mensaje);
    }
}