import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays02 {
    // 2) Crea un array de números donde le indicamos por teclado el tamaño del
    // array, rellenaremos el array con números aleatorios entre 0 y 9, al final
    // muestra por pantalla el valor de cada posición y la suma de todos los
    // valores. Haz un método para rellenar el array (que tenga como parámetros los
    // números entre los que tenga que generar), para mostrar el contenido y la suma
    // del array y un método privado para generar número aleatorio (lo puedes usar
    // para otros ejercicios).

    public static void main(String[] args) {
        int[] numeros = RellenarArray(); // feim que la array es convertesqui en l'output de rellenar array
        MostrarArray(numeros); // la mostram

    }

    public static int[] RellenarArray() { // aquest mètode omple la array demanant 10 numeros, i el return numeros és la
                                          // sortida del mètode
        String Mida = JOptionPane.showInputDialog("Quants de numeros vols?");
        int MidaArray = Integer.parseInt(Mida);
        int numeros[] = new int[MidaArray];
        int i = 0;
        while (i < MidaArray) {
            numeros[i] = (int) (Math.random() * 9) + 1;
            i++;
        }
        return numeros;

    }

    public static void MostrarArray(int[] numeros) { // int[] numeros fa referència a una entrada
        System.out.println("Aqui tens la teva array:");
        System.out.println(Arrays.toString(numeros));

    }
}
