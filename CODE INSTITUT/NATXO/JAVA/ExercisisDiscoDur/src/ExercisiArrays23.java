import javax.swing.JOptionPane;

public class ExercisiArrays23 {
    public static void main(String[] args) {
        String tamStr = JOptionPane.showInputDialog("Tamaño del array:");
        int tam = Integer.parseInt(tamStr);

        int[] origen = new int[tam];
        int[] destino = new int[tam];

        // Rellenar array origen
        for (int i = 0; i < tam; i++) {
            String numStr = JOptionPane.showInputDialog("Número " + (i + 1) + ":");
            origen[i] = Integer.parseInt(numStr);
        }

        // Filtrar pares mayores que 25
        int count = 0;
        for (int num : origen) {
            if (num % 2 == 0 && num > 25) {
                destino[count++] = num;
            }
        }

        // Mostrar resultados
        String mensaje = "Origen: " + arrayToString(origen, tam) + "\n" +
                "Destino: " + arrayToString(destino, count);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static String arrayToString(int[] array, int count) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            sb.append(array[i]);
            if (i < count - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}