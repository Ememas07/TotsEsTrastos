import javax.swing.JOptionPane;

public class Exercisi26 {
    public static void main(String[] args) {
        Integer numero = Integer.parseInt(JOptionPane.showInputDialog("Inserti numero"));
        numero = numero + 1;
        System.out.println(numero);
    }

}