import javax.swing.JOptionPane;

public class ExercisiMF04 {
    public static void main(String[] args) {
        // 4) Crea una aplicación que nos calcule el factorial de un número pedido por
        // teclado, lo realizara mediante un método al que le pasamos el número como
        // parámetro. Para calcular el factorial, se multiplica los números anteriores
        // hasta llegar a uno. Por ejemplo, si introducimos un 5, realizara esta
        // operación 5*4*3*2*1=120.
        Double numero = Double.parseDouble(JOptionPane.showInputDialog("Introdueix numero"));
        Double acumulat = numero;
        while (numero > 2) {
            numero = numero - 1;
            acumulat = acumulat * numero;

        }
        System.out.println(acumulat);
    }
}
