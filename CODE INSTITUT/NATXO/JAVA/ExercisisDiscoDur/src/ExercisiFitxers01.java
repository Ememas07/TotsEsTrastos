import java.io.FileReader;
import java.io.IOException;

public class ExercisiFitxers01 {
    // ) Crea un fichero de texto con el nombre y contenido que tu quieras. Ahora
    // crea una aplicación que lea este fichero de texto carácter a carácter y
    // muestre su contenido por pantalla sin espacios. Por ejemplo, si un fichero
    // tiene el siguiente texto «Esto es una prueba», deberá mostrar
    // «Estoesunaprueba».
    public static void main(String[] args) {
        // final String nomFichero = "C:\\Users\\MMH\\Documents\\CODE\\CODE INSTITUT\\NATXO\\JAVA\\FitxersDeText\\hola.txt";
        final String nomFichero = "C:/Users/MMH/Documents/CODE/CODE INSTITUT/NATXO/JAVA/FitxersDeText/hola.txt";
        try (FileReader fr = new FileReader(nomFichero)) {
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
