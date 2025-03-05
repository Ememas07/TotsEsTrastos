import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays03 {
    // 3) Crea un array de números de un tamaño pasado por teclado, el array
    // contendrá números aleatorios primos entre los números deseados, por último
    // nos indica cual es el mayor de todos. Haz un método para comprobar que el
    // número aleatorio es primo, puedes hacer todos lo métodos que necesites.
    public static void main(String[] args) {
        int[] numeros = RellenarArray(); // feim que la array es convertesqui en l'output de rellenar array
        MostrarArray(numeros); // la mostram

    }

    public static int[] RellenarArray() { // aquest mètode omple la array demanant 10 numeros, i el return numeros és la
                                          // sortida del mètode
        String lowerStr = JOptionPane.showInputDialog("Entra el límit inferior:");
        int lowerBound = Integer.parseInt(lowerStr);
        String upperStr = JOptionPane.showInputDialog("Entra el límit superior:");
        int upperBound = Integer.parseInt(upperStr);
        String Mida = JOptionPane.showInputDialog("Quants de numeros vols?");
        int MidaArray = Integer.parseInt(Mida);
        int numeros[] = new int[MidaArray];
        int i = 0;
        while (i < MidaArray) {
            int num = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound; // aixo assegura que els
                                                                                          // nombres estàn entre el
                                                                                          // minim i el maxim
            if (EsPrimer(num)) {
                numeros[i] = num; // Si és primer, guardam
                i++; // Incrementam
            }
        }
        return numeros;

    }

    private static boolean EsPrimer(int num) {
        if (num <= 1)
            return false; // 1 no és primer
        if (num == 2)
            return true; // 2 és primer
        if (num % 2 == 0)
            return false; // tots es numeros divisibles entre 2 no són primers

        // Comprovació de si és primer o no
        for (int j = 3; j <= Math.sqrt(num); j += 2) {
            if (num % j == 0)
                return false;
        }
        return true;
    }

    public static void MostrarArray(int[] numeros) { // int[] numeros fa referència a una entrada
        System.out.println("Aqui tens la teva array:");
        System.out.println(Arrays.toString(numeros));

    }
}
