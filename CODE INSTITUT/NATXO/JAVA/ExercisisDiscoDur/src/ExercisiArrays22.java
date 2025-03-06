import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JOptionPane;

public class ExercisiArrays22 {
    public static void main(String[] args) {
        String tamStr = JOptionPane.showInputDialog("Tamaño del array:");
        int tam = Integer.parseInt(tamStr);

        int[] numeros = generarAleatoriosNoRepetidos(tam);
        JOptionPane.showMessageDialog(null, "Array generado: " + Arrays.toString(numeros));
    }

    private static int[] generarAleatoriosNoRepetidos(int tam) {
        Random rand = new Random();
        HashSet<Integer> usados = new HashSet<>();
        int[] resultado = new int[tam];

        for (int i = 0; i < tam; i++) {
            int num;
            do {
                num = rand.nextInt(100); // Rango 0-99
            } while (usados.contains(num));
            usados.add(num);
            resultado[i] = num;
        }
        return resultado;
    }
}