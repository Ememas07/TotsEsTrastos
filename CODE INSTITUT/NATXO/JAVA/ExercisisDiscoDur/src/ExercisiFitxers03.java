import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ExercisiFitxers03 {
    public static void main(String[] args) {
        // Pedir rutas
        String ruta1 = JOptionPane.showInputDialog("Ruta del primer fichero:");
        String ruta2 = JOptionPane.showInputDialog("Ruta del segundo fichero:");
        String rutaDestino = JOptionPane.showInputDialog("Ruta de destino (sin nombre de fichero):");

        try {
            unirFicheros(ruta1, ruta2, rutaDestino);
            JOptionPane.showMessageDialog(null, "Ficheros unidos con éxito");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para unir dos ficheros en uno
    private static void unirFicheros(String ruta1, String ruta2, String rutaDestino) throws IOException {
        String nombre1 = new File(ruta1).getName().replace(".txt", "");
        String nombre2 = new File(ruta2).getName().replace(".txt", "");
        String rutaSalida = rutaDestino + File.separator + nombre1 + "_" + nombre2 + ".txt";

        File ficheroDestino = new File(rutaSalida);
        if (ficheroDestino.exists()) {
            int respuesta = JOptionPane.showConfirmDialog(null, "El fichero ya existe. ¿Sobrescribir?");
            if (respuesta != JOptionPane.YES_OPTION)
                return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSalida))) {
            copiarContenido(ruta1, writer);
            copiarContenido(ruta2, writer);
        }
    }

    // Submétodo para copiar contenido de un fichero
    private static void copiarContenido(String ruta, BufferedWriter writer) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
            }
        }
    }
}