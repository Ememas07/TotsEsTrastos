import javax.swing.JOptionPane;

public class Exercisi30 {
    public static void main(String[] args) {
        // 30) Convertir una frase a mayúsculas o minúsculas, que daremos opción a que
        // el usuario lo pida y mostraremos el resultado por pantalla.
        String frase = JOptionPane.showInputDialog("inserti frase");
        String cas = JOptionPane
                .showInputDialog("per majusculas, pitja M (majuscula), per minuscula, pitja m (minuscula) )");

        switch (cas) {
            case "M":
                frase = frase.toUpperCase();
                System.out.println(frase);
                break;

            case "m":
                frase = frase.toLowerCase();
                System.out.println(frase);
                break;
        }

    }

}
