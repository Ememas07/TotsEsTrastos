import javax.swing.JOptionPane;

public class Exercisi27 {
    public static void main(String[] args) {
        // 27) Crear una aplicación que nos permite insertar números hasta que
        // insertemos un -1. Calcular el numero de números introducidos.
        Integer numero = 0;
        Integer total = 0;
        while (numero != -1) {
            numero = Integer.parseInt(JOptionPane.showInputDialog("inserti numero"));
            total = total + 1;
        }
        System.out.println("Has insertat un total de " + total + " numeros");

    }

}