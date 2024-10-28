import javax.swing.JOptionPane;
/* 1) Crea una aplicación que nos calcule el área de un circulo, cuadrado o triangulo. Pediremos que figura queremos calcular su área y según lo introducido pedirá los valores necesarios para calcular el área. Crea un método por cada figura para calcular cada área, este devolverá un número real. Muestra el resultado por pantalla

Aquí te mostramos que necesita cada figura:

Circulo: (radio^2)*PI
Triangulo: (base * altura) / 2
Cuadrado: lado * lado*/

public class ExercisiMF01 {
    public static void main(String[] args) {
        System.out.println("Computació de àrea");
        String[] options = { "Cercle", "Triangle", "Quadrat" };
        var figura = JOptionPane.showOptionDialog(null, "Quina figura?", "tria una", 0, 3, null, options, options[0]);
        if (figura == 0) {
            String radi = JOptionPane.showInputDialog("Introdueix Radi");
            Double radi2 = Double.parseDouble(radi);
            Double resultat = (Math.pow(radi2, 2) * Math.PI);
            System.out.println("El resultat és " + resultat);
        }
        if (figura == 1) {
            String Base = JOptionPane.showInputDialog("Introdueix Base");
            String Altura = JOptionPane.showInputDialog("Introdueix Altura");
            Double Base2 = Double.parseDouble(Base);
            Double Altura2 = Double.parseDouble(Altura);
            Double resultat = (Base2 * Altura2) / 2;
            System.out.println("El resultat és " + resultat);
        }
        if (figura == 2) {
            String costat = JOptionPane.showInputDialog("Introdueix Costat");
            Double costat2 = Double.parseDouble(costat);
            Double resultat = (costat2 * costat2);
            System.out.println("El resultat és " + resultat);
        }
    }
}
