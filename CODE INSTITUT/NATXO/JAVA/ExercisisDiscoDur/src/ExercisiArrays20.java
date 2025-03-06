import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays20 {
    // 20) Ordenar un array de números con el método que quieras y hacer una
    // búsqueda binaria de cualquier numero.

    public static void main(String[] args) {
        // Crear un array de 5 números
        int[] numeros = new int[5];

        // Rellenar el array
        for (int i = 0; i < numeros.length; i++) {
            String numStr = JOptionPane.showInputDialog("Introduce el número " + (i + 1) + ":");
            numeros[i] = Integer.parseInt(numStr);
        }

        // Ordenar con Arrays.sort
        Arrays.sort(numeros);

        // Pedir número a buscar
        String buscarStr = JOptionPane.showInputDialog("Introduce el número a buscar:");
        int buscar = Integer.parseInt(buscarStr);

        // Búsqueda binaria
        int resultado = busquedaBinaria(numeros, buscar);

        // Mostrar resultados
        String mensaje = "Array ordenado: " + Arrays.toString(numeros) + "\n" +
                "Posición de " + buscar + ": " +
                (resultado >= 0 ? resultado : "No encontrado");
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static int busquedaBinaria(int[] array, int valor) {
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (array[medio] == valor)
                return medio;
            if (array[medio] < valor)
                inicio = medio + 1;
            else
                fin = medio - 1;
        }
        return -1;
    }
}
