import javax.swing.JOptionPane;

public class Exercisi18 {
    // 18) Pide por teclado dos número y genera 10 números aleatorios entre esos
    // números. Usa el método Math.random para generar un número entero aleatorio
    // (recuerda el casting de double a int).

    public static void main(String[] args) {
        Double N1 = Double.parseDouble(JOptionPane.showInputDialog("Mínim?"));
        Double N2 = Double.parseDouble(JOptionPane.showInputDialog("Màxim?"));
        Double N3 = N2 - N1;
        Double numero = N1 + Math.random() * N3;
        System.out.println(numero);

    }
}
