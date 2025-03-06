import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays17 {
    // 17) Ordenar un array de números con el método de la burbuja.

    public static void main(String[] args) {
        // Crear un array de 5 posiciones
        int[] numeros = new int[5];

        // Rellenar el array con valores del usuario
        for (int i = 0; i < numeros.length; i++) {
            String numStr = JOptionPane.showInputDialog("Introduce el número " + (i + 1) + " para el array:");
            numeros[i] = Integer.parseInt(numStr);
        }

        // Ordenar con el método de la burbuja
        ordenarBurbuja(numeros);

        // Mostrar el array ordenado
        JOptionPane.showMessageDialog(null, "Array ordenado (burbuja): " + Arrays.toString(numeros));
    }

    // Método de ordenación por burbuja
    private static void ordenarBurbuja(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}