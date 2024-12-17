import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays01 {
    // 1) Crea un array de 10 posiciones de números con valores pedidos por teclado.
    // Muestra por consola el indice y el valor al que corresponde. Haz dos métodos,
    // uno para rellenar valores y otro para mostrar.
    public static void main(String[] args) {
        int[] numeros = RellenarArray(); // feim que la array es convertesqui en l'output de rellenar array
        MostrarArray(numeros); // la mostram

    }

    public static int[] RellenarArray() { // aquest mètode omple la array demanant 10 numeros, i el return numeros és la
                                          // sortida del mètode
        int numeros[] = new int[10];
        int i = 0;
        while (i < 10) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Inserti el número " + (i + 1)));
            i++;
        }
        return numeros;

    }

    public static void MostrarArray(int[] numeros) { // int[] numeros fa referència a una entrada
        System.out.println("Aqui tens la teva array:");
        System.out.println(Arrays.toString(numeros));

    }

}
