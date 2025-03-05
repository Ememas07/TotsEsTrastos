import java.util.Random;

import javax.swing.JOptionPane;

public class ExercisiArrays07 {
    public static void main(String[] args) {
        Random random = new Random();

        // Pedir tamaño del array usando JOptionPane
        String input = JOptionPane.showInputDialog(null, "Introduce el tamaño de los arrays:");
        int tamano = Integer.parseInt(input);

        // Crear primer array y rellenarlo con números aleatorios
        int[] array1 = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            array1[i] = random.nextInt(100); // Números aleatorios entre 0 y 99
        }

        // Crear segundo array que apunta al primero
        int[] array2 = array1;

        // Crear un nuevo array con el mismo tamaño y rellenarlo con nuevos números
        // aleatorios
        int[] array3 = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            array3[i] = random.nextInt(100); // Nuevos números aleatorios
        }

        // Multiplicar los arrays y obtener el resultado
        int[] resultado = multiplicarArrays(array1, array3);

        // Preparar los mensajes para mostrar los arrays
        String mensaje = "Contenido de array1:\n" + arrayToString(array1) +
                "\nContenido de array2 (apunta a array1):\n" + arrayToString(array2) +
                "\nContenido de array3:\n" + arrayToString(array3) +
                "\nContenido del array resultado:\n" + arrayToString(resultado);

        // Mostrar resultado usando JOptionPane
        JOptionPane.showMessageDialog(null, mensaje);

        // Llamar al recolector de basura
        System.gc();
    }

    // Método para multiplicar los elementos de dos arrays
    public static int[] multiplicarArrays(int[] arr1, int[] arr2) {
        int[] resultado = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            resultado[i] = arr1[i] * arr2[i];
        }
        return resultado;
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