import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ExercisiFitxers02 {
    public static void main(String[] args) {
        // Pedir ruta y texto
        String ruta = JOptionPane.showInputDialog("Introduce la ruta del fichero:");
        String texto = JOptionPane.showInputDialog("Introduce el texto a escribir:");

        try {
            // Escribir texto en el fichero
            escribirEnFichero(ruta, texto);

            // Mostrar texto alternando mayúsculas y minúsculas
            String textoAlternado = alternarMayusculasMinusculas(texto);
            JOptionPane.showMessageDialog(null, "Texto alternado: " + textoAlternado);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para escribir texto en el fichero
    private static void escribirEnFichero(String ruta, String texto) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(texto);
        }
    }

    // Método para alternar mayúsculas y minúsculas
    private static String alternarMayusculasMinusculas(String texto) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) {
                if (i % 2 == 0) {
                    resultado.append(Character.toLowerCase(c));
                } else {
                    resultado.append(Character.toUpperCase(c));
                }
            } else {
                resultado.append(c); // Mantener caracteres no letras
            }
        }
        return resultado.toString();
    }
}