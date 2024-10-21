import javax.swing.JOptionPane;

public class Exercisi28 {
    public static void main(String[] args) {
        // 28) Eliminar los espacios de una frase pasada por consola por el usuario.
        String frase = JOptionPane.showInputDialog("Introdueix frase");
        String frasefinal = frase.replace(" ", "");
        System.out.println(frasefinal);
    }
}
