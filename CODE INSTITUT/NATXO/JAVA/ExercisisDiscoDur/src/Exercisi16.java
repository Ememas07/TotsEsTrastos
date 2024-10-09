import javax.swing.JOptionPane;

public class Exercisi16 {
    // 16) Escribe una aplicación con un String que contenga una contraseña
    // cualquiera. Después se te pedirá que introduzcas la contraseña, con 3
    // intentos. Cuando aciertes ya no pedirá mas la contraseña y mostrara un
    // mensaje diciendo «Enhorabuena». Piensa bien en la condición de salida (3
    // intentos y si acierta sale, aunque le queden intentos).
    public static void main(String[] args) {
        String contrasenya = "marcmas";
        int Intentos = 3;
        while (Intentos > 0) {
            String userinput = JOptionPane.showInputDialog("Introdueix contrassenya");
            if (userinput.equals(contrasenya)) {
                break;
            } else if (Intentos > 0) {
                Intentos = Intentos - 1;
                System.out.println(Intentos);
                System.out.println(contrasenya);
                System.out.println(userinput);
            }

        }

    }

}
