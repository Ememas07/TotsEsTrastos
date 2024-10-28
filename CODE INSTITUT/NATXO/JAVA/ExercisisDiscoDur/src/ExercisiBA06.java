import javax.swing.JOptionPane;

public class ExercisiBA06 {
    public static void main(String[] args) {
        Integer altura = Integer.parseInt(JOptionPane.showInputDialog("numero"));
        for (int numeroespacios = 0,
                numeroasteriscos = (altura * 2) - 1; numeroasteriscos > 0; numeroespacios++, numeroasteriscos -= 2) {

            for (int i = 0; i < numeroespacios; i++) {
                System.out.print(" ");
            }

            for (int j = numeroasteriscos; j != 0; j--) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
