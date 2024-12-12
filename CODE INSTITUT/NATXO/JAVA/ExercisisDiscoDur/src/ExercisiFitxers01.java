import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ExercisiFitxers01 {
    // ) Crea un Fitxer de texto con el nombre y contenido que tu quieras. Ahora
    // crea una aplicación que lea este Fitxer de texto carácter a carácter y
    // muestre su contenido por pantalla sin espacios. Por ejemplo, si un Fitxer
    // tiene el siguiente texto «Esto es una prueba», deberá mostrar
    // «Estoesunaprueba».
    public static void main(String[] args) {
        String NomFitxer = JOptionPane.showInputDialog("nom del fitxer?");
        String RutaFitxer = "C:/Users/MMH/Documents/CODE/CODE INSTITUT/NATXO/JAVA/FitxersDeText/";
        String Fitxer = RutaFitxer+NomFitxer;
        try (FileReader fr = new FileReader(Fitxer)) {
            int valor = fr.read();
            while (valor != -1) {
                if (valor != 32) {
                    System.out.print((char) valor);
                }
                valor = fr.read();
            }
        }catch(IOException e){
        System.out.println("Problemas con el E/S");
        }
    }
}
