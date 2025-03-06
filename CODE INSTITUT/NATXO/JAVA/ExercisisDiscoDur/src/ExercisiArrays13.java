import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays13 {
    // 13) Rellenar un array de numeros (int) usando el metodo fill de Arrays.

    public static void main(String[] args) {
        // Crear un array de 5 posiciones
        int[] numeros = new int[5];

        // Pedir al usuario el valor para rellenar
        String valorStr = JOptionPane.showInputDialog("Introduce el número para rellenar el array:");
        int valor = Integer.parseInt(valorStr);

        // Rellenar el array con el método fill
        Arrays.fill(numeros, valor);

        // Mostrar el resultado
        JOptionPane.showMessageDialog(null, "Array rellenado: " + Arrays.toString(numeros));
    }
}
