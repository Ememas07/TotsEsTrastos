import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays19 {
    // 19) Ordenar un array de cadenas con el método Quicksort.

    public static void main(String[] args) {
        // Crear un array de 5 cadenas
        String[] cadenas = new String[5];

        // Rellenar el array con entrada del usuario
        for (int i = 0; i < cadenas.length; i++) {
            cadenas[i] = JOptionPane.showInputDialog("Introduce la cadena " + (i + 1) + ":");
        }

        // Ordenar con QuickSort
        quickSort(cadenas, 0, cadenas.length - 1);

        // Mostrar resultado
        JOptionPane.showMessageDialog(null, "Cadenas ordenadas: " + Arrays.toString(cadenas));
    }

    private static void quickSort(String[] array, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = particion(array, inicio, fin);
            quickSort(array, inicio, indiceParticion - 1);
            quickSort(array, indiceParticion + 1, fin);
        }
    }

    private static int particion(String[] array, int inicio, int fin) {
        String pivote = array[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (array[j].compareTo(pivote) <= 0) {
                i++;
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        String temp = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp;

        return i + 1;
    }
}
