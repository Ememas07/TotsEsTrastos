import javax.swing.JOptionPane;

public class Exercisi34 {
    public static void main(String[] args) {
        // 34) Dada una frase, separarlo en palabras.
        String frase = JOptionPane.showInputDialog("Inserti frase");
        String[] myArray = frase.split("\\s");
        for (String s : myArray) {
            System.out.println(s);
        }

    }

}
