import javax.swing.JOptionPane;

public class ExercisiBA04 {
    public static void main(String[] args) {
        Integer numero = Integer.parseInt(JOptionPane.showInputDialog("numero"));
        String escala = "";
        Integer contador = 1;
        while (contador <= numero) {
            escala = escala + contador;
            contador = contador + 1;
            System.out.println(escala);

        }

    }
}