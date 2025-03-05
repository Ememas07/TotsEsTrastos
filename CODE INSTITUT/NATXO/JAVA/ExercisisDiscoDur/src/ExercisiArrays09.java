import javax.swing.JOptionPane;

public class ExercisiArrays09 {
    // Array de caracteres según la tabla oficial del DNI español
    private static final char[] LETRAS_DNI = {
            'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
            'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'
    };

    public static void main(String[] args) {
        // Pedir el número del DNI
        String input = JOptionPane.showInputDialog(null, "Introduce el número del DNI (8 dígitos):");
        int dniNumero;

        // Validar la entrada
        try {
            dniNumero = Integer.parseInt(input);

            // Validar que sea un número de 8 dígitos
            while (dniNumero < 0 || dniNumero > 99999999) {
                input = JOptionPane.showInputDialog(null,
                        "El DNI debe ser un número positivo de 8 dígitos.\nIntroduce el número del DNI:");
                dniNumero = Integer.parseInt(input);
            }

            // Calcular la letra y mostrar resultado
            char letra = calcularLetraDNI(dniNumero);
            String dniCompleto = String.format("%08d", dniNumero) + letra;

            JOptionPane.showMessageDialog(null,
                    "El DNI completo es: " + dniCompleto);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Error: Debes introducir un número válido",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para calcular la letra del DNI
    public static char calcularLetraDNI(int numero) {
        // Calcular el resto de dividir entre 23
        int posicion = numero % 23;
        // Devolver la letra correspondiente según la posición
        return LETRAS_DNI[posicion];
    }
}