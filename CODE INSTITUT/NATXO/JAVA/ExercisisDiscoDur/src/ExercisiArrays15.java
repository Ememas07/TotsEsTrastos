import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays15 {
    // 15) Indica si dos arrays creados por ti son iguales con Equals de Arrays.

    public static void main(String[] args) {
        // Crear dos arrays con valores predefinidos
        int[] array1 = { 1, 2, 3, 4, 5 };
        int[] array2 = { 1, 2, 3, 4, 5 };

        // Comparar los arrays usando equals
        boolean sonIguales = Arrays.equals(array1, array2);

        // Mostrar resultado
        String mensaje = "Array 1: " + Arrays.toString(array1) + "\n" +
                "Array 2: " + Arrays.toString(array2) + "\n" +
                "¿Son iguales? " + (sonIguales ? "Sí" : "No");
        JOptionPane.showMessageDialog(null, mensaje);
    }
}