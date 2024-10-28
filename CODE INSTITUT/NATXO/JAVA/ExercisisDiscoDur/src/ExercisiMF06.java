import javax.swing.JOptionPane;

public class ExercisiMF06 {
    public static void main(String[] args) {
        // 6) Crea una aplicación que nos cuente el número de cifras de un número entero
        // positivo (hay que controlarlo) pedido por teclado. Crea un método que realice
        // esta acción, pasando el número por parámetro, devolverá el número de cifras.
        String numero = JOptionPane.showInputDialog("numero");
        System.out.println(numero.length());
    }
}
