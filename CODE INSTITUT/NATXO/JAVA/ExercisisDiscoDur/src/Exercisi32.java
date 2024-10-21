import javax.swing.JOptionPane;

public class Exercisi32 {

    public static void main(String[] args) {
        // 32) Pedir dos palabras por teclado, indicar si son iguales.
        String frase1 = JOptionPane.showInputDialog("Inserti frase 1");
        String frase2 = JOptionPane.showInputDialog("Inserti frase 2");
        if (frase1.equals(frase2) == true) {
            System.out.println("Son iguals");
        } else {
            System.out.println("No son iguals");
        }
    }
}
