import javax.swing.JOptionPane;

public class ExercisiBA02 {
    public static void main(String[] args) {
        Integer numero = Integer.parseInt(JOptionPane.showInputDialog("numero de estrelles"));
        String escala = "";
        Integer contador = 1;
        while (contador <= numero) {
            escala = escala + "*";
            contador = contador + 1;
            System.out.println(escala);

        }

    }

}
