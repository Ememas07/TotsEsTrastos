import javax.swing.JOptionPane;

public class ExercisiArrays06 {
    // 6) Pide al usuario por teclado una frase y pasa sus caracteres a un array de
    // caracteres. Puedes hacer con o sin métodos de String.

    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog("Inserta una frase");

        // Iniciam array
        String[] caracteres = new String[frase.length()];

        // omplim array
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            caracteres[i] = String.valueOf(caracter); // convertir caracter a string
        }

        // posam array resultant
        StringBuilder display = new StringBuilder("Array de caracteres: ");
        for (String c : caracteres) {
            display.append(c).append(" ");
        }
        JOptionPane.showMessageDialog(null, display.toString());

    }
}
