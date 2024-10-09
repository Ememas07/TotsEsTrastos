import javax.swing.JOptionPane;

public class Exercisi19 {
    // 19) Pide por teclado un número entero positivo (debemos controlarlo) y
    // muestra el número de cifras que tiene. Por ejemplo: si introducimos 1250, nos
    // muestre que tiene 4 cifras. Tendremos que controlar si tiene una o mas
    // cifras, al mostrar el mensaje.

    public static void main(String[] args) {
        String numero = JOptionPane.showInputDialog("Introdueix nombre (positiu)");
        Integer Numero = Integer.parseInt(numero);
        Numero = Math.abs(Numero);
        Integer.toString(Numero);
        Integer llargaria = numero.length();
        System.out.println("la llargària de " + numero + " és " + llargaria);

    }
}
