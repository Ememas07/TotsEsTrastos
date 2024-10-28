import javax.swing.JOptionPane;

public class ExercisiBA03 {
    public static void main(String[] args) {
        Integer numero = Integer.parseInt(JOptionPane.showInputDialog("numero de estrelles"));
        String escala = "";
        Integer contador = 1;
        while (contador <= numero) {
            escala = ""+contador;
            contador = contador + 1;
            System.out.println(escala);

        }

    }
}
