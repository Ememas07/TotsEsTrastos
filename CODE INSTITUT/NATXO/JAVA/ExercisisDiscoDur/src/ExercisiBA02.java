import javax.swing.JOptionPane;

public class ExercisiBA02 {
    public static void main(String[] args) {
        Integer numero = Integer.parseInt(JOptionPane.showInputDialog("numero de estrelles"));
        for (int numeroasteriscos = numero; numeroasteriscos > 0; numeroasteriscos--) {
            for (int i = numeroasteriscos; i > 0; i--) {
                System.out.print("*");
            }
            System.out.println("");

        }

    }

}