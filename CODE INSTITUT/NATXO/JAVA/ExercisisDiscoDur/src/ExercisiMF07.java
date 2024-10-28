import javax.swing.JOptionPane;

public class ExercisiMF07 {
    public static void main(String[] args) {
        // 7) Crea un aplicación que nos convierta una cantidad de euros introducida por
        // teclado a otra moneda, estas pueden ser a dolares, yenes o libras. El método
        // tendrá como parámetros, la cantidad de euros y la moneda a pasar que sera una
        // cadena, este no devolverá ningún valor, mostrara un mensaje indicando el
        // cambio (void).
        // El cambio de divisas son:
        // 0.86 libras es un 1
        // €1.28611 $ es un 1
        // €129.852 yenes es un 1 €
        System.out.println("Conversió de eur");
        Double MonedaInicial = Double.parseDouble(JOptionPane.showInputDialog("Quants de EUR"));
        String[] options = { "USD", "Libra", "Yen" };
        Double Resultat = 0.0;
        var divisa = JOptionPane.showOptionDialog(null, "Quina divisa", "tria una", 0, 3, null, options, options[0]);

        if (divisa == 0) {
            Resultat = MonedaInicial * 1.28611;
            System.out.println(MonedaInicial + " EUR és igual a " + Resultat + " " + divisa);
        }
        if (divisa == 1) {
            Resultat = MonedaInicial * 1.28611;
            System.out.println(MonedaInicial + " EUR és igual a " + Resultat + " " + divisa);
        }
        if (divisa == 2) {
            Resultat = MonedaInicial * 1.28611;
            System.out.println(MonedaInicial + " EUR és igual a " + Resultat + " " + divisa);
        }
    }

}
