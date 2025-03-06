import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays18 {
    public static void main(String[] args) {
        // Crear un array de 5 posiciones
        int[] numeros = new int[5];

        // Rellenar el array con valores del usuario
        for (int i = 0; i < numeros.length; i++) {
            String numStr = JOptionPane.showInputDialog("Introduce el número " + (i + 1) + " para el array:");
            numeros[i] = Integer.parseInt(numStr);
        }

        // Ordenar con QuickSort
        quickSort(numeros, 0, numeros.length - 1);

        // Mostrar el array ordenado
        JOptionPane.showMessageDialog(null, "Array ordenado (QuickSort): " + Arrays.toString(numeros));
    }

    // Método principal de QuickSort
    private static void quickSort(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(array, inicio, fin);
            quickSort(array, inicio, indiceParticion - 1);
            quickSort(array, indiceParticion + 1, fin);
        }
    }

    // Método para realizar la partición en QuickSort
    private static int particion(int[] array, int inicio, int fin) {
        int pivote = array[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (array[j] <= pivote) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp;

        return i + 1;
    }
}