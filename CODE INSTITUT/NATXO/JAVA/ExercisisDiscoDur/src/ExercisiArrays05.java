import javax.swing.JOptionPane;

public class ExercisiArrays05 {
    // 5) Crea un array de caracteres que contenga de la ‘A’ a la ‘Z’ (solo las
    // mayúsculas). Después, ve pidiendo posiciones del array por teclado y si la
    // posicion es correcta, se añadira a una cadena que se mostrara al final, se
    // dejará de insertar cuando se introduzca un -1. Por ejemplo, si escribo los
    // siguientes numeros 0 //Añadira la ‘A’ 5 //Añadira la ‘F’ 25 //Añadira la ‘Z’
    // 50 //Error, inserte otro numero -1 //fin Cadena resultante:AFZ
    public static void main(String[] args) {
        String[] Cadena = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        String opcio = "";
        Integer opcio2 = 4;
        String cadenafinal = "";
        while (opcio2 > -1) {
            opcio = JOptionPane.showInputDialog("Quin numero vols");
            opcio2 = Integer.parseInt(opcio);
            if (opcio2 > 25) {
                System.out.println("Error, inserti un nombre entre 0 i 25.");
            } else if (opcio2 < 0) {
                break;
            } else {
                String item = Cadena[opcio2];
                cadenafinal = cadenafinal + item;
            }
        }
        System.out.println(cadenafinal);
    }
}