import java.util.Arrays;

public class ExercisiArrays04 {
    // 4) Crea un array de números de 100 posiciones, que contendrá los números del
    // 1 al 100. Obtén la suma de todos ellos y la media.
    public static void main(String[] args) {
        int[] numeros = RellenarArray(); // feim que la array es convertesqui en l'output de rellenar array
        MostrarArray(numeros); // la mostram

    }

    public static int[] RellenarArray() { // aquest mètode omple la array demanant 10 numeros, i el return numeros és la
        // sortida del mètode
        int MidaArray = 100;
        int numeros[] = new int[MidaArray];
        int i = 0;
        int SumaArray = 0;
        int MediaArray = 0;
        while (i < MidaArray) {
            int num = (int) (Math.random() * (100)) + 1; // aixo assegura que els
            // nombres estàn entre el
            // minim i el maxim
            numeros[i] = num;
            SumaArray = SumaArray + num;
            MediaArray = SumaArray / (i + 1);
            i++; // Incrementam
        }
        System.out.println("La suma és " + SumaArray);
        System.out.println("La mitja és " + MediaArray);
        return numeros;

    }

    public static void MostrarArray(int[] numeros) { // int[] numeros fa referència a una entrada
        System.out.println("Aqui tens la teva array:");
        System.out.println(Arrays.toString(numeros));

    }

}
