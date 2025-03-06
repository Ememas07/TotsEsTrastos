public class ExercisiArrays12 {
    // 12) Dado un array de números de 5 posiciones con los siguiente valores
    // {1,2,3,4,5}, guardar los valores de este array en otro array distinto pero
    // con los valores invertidos, es decir, que el segundo array debera tener los
    // valores {5,4,3,2,1}.

    public static void main(String[] args) {
        int[] original = { 1, 2, 3, 4, 5 };
        int[] invertido = new int[5];

        // Invertir el array
        invertirArray(original, invertido);

        // Mostrar resultados
        System.out.println("Array original:");
        imprimirArray(original);
        System.out.println("Array invertido:");
        imprimirArray(invertido);
    }

    // Método para invertir un array
    private static void invertirArray(int[] fuente, int[] destino) {
        for (int i = 0; i < fuente.length; i++) {
            destino[fuente.length - 1 - i] = fuente[i];
        }
    }

    // Método para imprimir un array
    private static void imprimirArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}