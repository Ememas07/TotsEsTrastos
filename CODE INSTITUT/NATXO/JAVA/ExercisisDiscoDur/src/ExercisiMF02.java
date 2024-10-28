import javax.swing.JOptionPane;
// 2) Crea una aplicación que nos genere una cantidad de números enteros aleatorios que nosotros le pasaremos por teclado. Crea un método donde pasamos como parámetros entre que números queremos que los genere, podemos pedirlas por teclado antes de generar los números. Este método devolverá un número entero aleatorio. Muestra estos números por pantalla

public class ExercisiMF02 {

    public static void main(String[] args) {
        String Quantitat = JOptionPane.showInputDialog("Quants d'enters vols? ");
        String Minim = JOptionPane.showInputDialog("Quin és el nombre mínim? ");
        String Maxim = JOptionPane.showInputDialog("Quin és el nombre màxim? ");
        int quantitat2 = Integer.parseInt(Quantitat);
        int Vegades = 0;
        while (Vegades < quantitat2) {
            Double minim = Double.parseDouble(Minim);
            Double maxim = Double.parseDouble(Maxim);
            Double NombreRandom = Math.random() * minim * 10;
            if (NombreRandom > minim && NombreRandom < maxim) {
                Vegades = Vegades + 1;
                System.out.println(Math.round(NombreRandom));

            }

        }

    }
}
