import javax.swing.JOptionPane;

public class ExercisiMF03 {
    public static void main(String[] args) {
        // 3) Crea una aplicación que nos pida un número por teclado y con un método se
        // lo pasamos por parámetro para que nos indique si es o no un número primo,
        // debe devolver true si es primo sino false. Un número primo es aquel solo
        // puede dividirse entre 1 y si mismo. Por ejemplo: 25 no es primo, ya que 25 es
        // divisible entre 5, sin embargo, 17 si es primo. Un buen truco para calcular
        // la raíz cuadrada del numero e ir comprobando que si es divisible desde ese
        // numero hasta 1.
        int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Introduexi Numero"));
        if (isPrime(numero1)) {
            System.out.println("Es primer");
        } else {
            System.out.println("No es primer");
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if ((num % i) == 0)
                return false;
        }
        return true;
    }
}
