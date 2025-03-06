import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ExercisiFitxers04 {
    public static void main(String[] args) {
        // Pedir rutas
        String rutaOrigen = JOptionPane.showInputDialog("Ruta del fichero origen:");
        String rutaDestino = JOptionPane.showInputDialog("Ruta del fichero destino:");

        try {
            copiarFicheroBinario(rutaOrigen, rutaDestino);
            JOptionPane.showMessageDialog(null, "Fichero copiado con éxito");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para copiar fichero binario usando un array
    private static void copiarFicheroBinario(String rutaOrigen, String rutaDestino) throws IOException {
        try (FileInputStream fis = new FileInputStream(rutaOrigen);
                FileOutputStream fos = new FileOutputStream(rutaDestino)) {
            int tamano = fis.available();
            byte[] buffer = new byte[tamano];
            fis.read(buffer);
            fos.write(buffer);
        }
    }
}