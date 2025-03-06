import java.util.Arrays;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class ExercisiArrays21 {
    public static void main(String[] args) {
        // Pedir nombres de jugadores
        String jugador1 = JOptionPane.showInputDialog("Nombre del Jugador 1:");
        String jugador2 = JOptionPane.showInputDialog("Nombre del Jugador 2:");

        int puntos1 = 0, puntos2 = 0;
        boolean turnoJugador1 = true;

        while (puntos1 < 3 && puntos2 < 3) {
            String actual = turnoJugador1 ? jugador1 : jugador2;
            String rival = turnoJugador1 ? jugador2 : jugador1;

            // Pedir palabra y pista
            String palabra = JOptionPane.showInputDialog(actual + ", introduce la palabra secreta:");
            String pista = JOptionPane.showInputDialog(actual + ", introduce una pista:");

            // Jugar turno
            boolean adivinado = jugarTurno(rival, palabra, pista);

            // Actualizar puntos
            if (adivinado) {
                if (!turnoJugador1)
                    puntos1++;
                else
                    puntos2++;
            } else {
                if (turnoJugador1)
                    puntos1++;
                else
                    puntos2++;
            }

            // Mostrar puntuación
            JOptionPane.showMessageDialog(null, "Puntuación:\n" + jugador1 + ": " + puntos1 + "\n" +
                    jugador2 + ": " + puntos2);
            turnoJugador1 = !turnoJugador1;
        }

        String ganador = puntos1 > puntos2 ? jugador1 : jugador2;
        JOptionPane.showMessageDialog(null, "¡Ganador: " + ganador + "!");
    }

    private static boolean jugarTurno(String jugador, String palabra, String pista) {
        int intentos = 6;
        char[] progreso = new char[palabra.length()];
        HashSet<Character> letrasUsadas = new HashSet<>();
        Arrays.fill(progreso, '_');

        while (intentos > 0 && !String.valueOf(progreso).equals(palabra)) {
            String estado = "Pista: " + pista + "\nPalabra: " + String.valueOf(progreso) +
                    "\nIntentos: " + intentos + "\nLetras usadas: " + letrasUsadas;
            String letra = JOptionPane.showInputDialog(jugador + ", adivina una letra:\n" + estado);

            char c = letra.charAt(0);
            if (letrasUsadas.contains(c)) {
                JOptionPane.showMessageDialog(null, "¡Letra repetida!");
                continue;
            }

            letrasUsadas.add(c);
            if (palabra.indexOf(c) >= 0) {
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == c)
                        progreso[i] = c;
                }
            } else {
                intentos--;
            }
        }
        return intentos > 0;
    }
}