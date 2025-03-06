import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays16 {
    /* 16) Ordena un array de números con Sort de Arrays. */
    public static void main(String[] args) {
        // Crear un array de 5 posiciones
        int[] numeros = new int[5];

        // Rellenar el array con valores del usuario
        for (int i = 0; i < numeros.length; i++) {
            String numStr = JOptionPane.showInputDialog("Introduce el número " + (i + 1) + " para el array:");
            numeros[i] = Integer.parseInt(numStr);
        }

        // Ordenar el array con sort
        Arrays.sort(numeros);

        // Mostrar el array ordenado
        JOptionPane.showMessageDialog(null, "Array ordenado: " + Arrays.toString(numeros));
    }
}
