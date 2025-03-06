import java.util.Arrays;

import javax.swing.JOptionPane;

public class ExercisiArrays24 {
    /*
     * 24)
     * 
     * Se quiere simular un juego en el que participan N jugadores y otra persona
     * que hace de árbitro. Cada jugador elige 4 números en el rango [1, 10],
     * pudiendo estar repetidos. A continuación, el árbitro, sin conocer los números
     * que ha elegido cada jugador, selecciona 2 números A y B.
     * 
     * El programa debe ser capaz de calcular cuántos números de los seleccionados
     * por cada jugador están comprendidos entre los valores A y B. Ganará el
     * jugador que más números tenga en dicho intervalo.
     * 
     * Se pide implementar un programa modular que simule el juego para 3 jugadores,
     * teniendo en cuenta que:
     * 
     * Tanto los 4 datos de cada jugador, como los valores para A y B se
     * introducirán por teclado. En todos los casos, el programa detectará la
     * entrada de números erróneos, solicitando nuevamente el dato hasta que sea
     * válido.
     * Se deben mostrar por pantalla no solo los aciertos de cada jugador sino los
     * datos que ha introducido cada jugador y los que ha seleccionado el árbitro.
     * Por último, hay que imprimir la media aritmética de los aciertos de todos los
     * jugadores
     */

    public static void main(String[] args) {
        int[][] jugadores = new int[3][4];

        // Entrada de jugadores
        for (int i = 0; i < 3; i++) {
            JOptionPane.showMessageDialog(null, "Jugador " + (i + 1) + ":");
            for (int j = 0; j < 4; j++) {
                int num;
                do {
                    String numStr = JOptionPane.showInputDialog("Número " + (j + 1) + " (1-10):");
                    num = Integer.parseInt(numStr);
                } while (num < 1 || num > 10);
                jugadores[i][j] = num;
            }
        }

        // Entrada del árbitro
        int a, b;
        do {
            a = Integer.parseInt(JOptionPane.showInputDialog("Árbitro, introduce A (1-10):"));
        } while (a < 1 || a > 10);
        do {
            b = Integer.parseInt(JOptionPane.showInputDialog("Árbitro, introduce B (1-10):"));
        } while (b < 1 || b > 10 || b <= a);

        // Calcular aciertos
        int[] aciertos = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (jugadores[i][j] >= a && jugadores[i][j] <= b) {
                    aciertos[i]++;
                }
            }
        }

        // Encontrar ganador
        int maxAciertos = Math.max(aciertos[0], Math.max(aciertos[1], aciertos[2]));
        String ganador = "Jugador " + (aciertos[0] == maxAciertos ? "1" : aciertos[1] == maxAciertos ? "2" : "3");

        // Calcular media
        double media = (aciertos[0] + aciertos[1] + aciertos[2]) / 3.0;

        // Mostrar resultados
        String mensaje = "Jugador 1: " + Arrays.toString(jugadores[0]) + " - Aciertos: " + aciertos[0] + "\n" +
                "Jugador 2: " + Arrays.toString(jugadores[1]) + " - Aciertos: " + aciertos[1] + "\n" +
                "Jugador 3: " + Arrays.toString(jugadores[2]) + " - Aciertos: " + aciertos[2] + "\n" +
                "Árbitro: A=" + a + ", B=" + b + "\n" +
                "Ganador: " + ganador + "\n" +
                "Media de aciertos: " + String.format("%.2f", media);
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
