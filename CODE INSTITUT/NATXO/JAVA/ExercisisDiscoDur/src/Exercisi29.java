import javax.swing.JOptionPane;

public class Exercisi29 {
    public static void main(String[] args) {
        // 29) Pedir al usuario que nos escriba frases de forma infinita hasta que
        // insertemos una cadena vacia. Mostrar la cadena resultante
        String frase = "hola";
        String resultat = "";
        while (frase.length() != 0) {
            frase = JOptionPane.showInputDialog("introdueix frase");
            resultat = resultat + " " + frase;
            System.out.println(frase);
        }
        System.out.println(resultat);
    }

}
