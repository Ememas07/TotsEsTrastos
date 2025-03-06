import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.swing.JOptionPane;

public class ExercisiFitxers05 {
    public static void main(String[] args) {
        // Pedir datos
        String cantidadStr = JOptionPane.showInputDialog("Cantidad de números aleatorios:");
        String ruta = JOptionPane.showInputDialog("Ruta del fichero:");
        int cantidad = Integer.parseInt(cantidadStr);

        try {
            // Escribir números aleatorios
            escribirNumerosAleatorios(ruta, cantidad);
            // Leer y mostrar números
            mostrarNumeros(ruta);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para escribir números aleatorios
    private static void escribirNumerosAleatorios(String ruta, int cantidad) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta, true))) {
            Random rand = new Random();
            for (int i = 0; i < cantidad; i++) {
                dos.writeInt(rand.nextInt(101)); // 0 a 100
            }
        }
    }

    // Método para leer y mostrar números
    private static void mostrarNumeros(String ruta) throws IOException {
        StringBuilder resultado = new StringBuilder("Números en el fichero:\n");
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
            while (dis.available() > 0) {
                resultado.append(dis.readInt()).append(" ");
            }
        }
        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}