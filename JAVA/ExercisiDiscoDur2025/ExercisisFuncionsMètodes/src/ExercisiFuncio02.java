import javax.swing.JOptionPane;

public class ExercisiFuncio02 {
  public static void main(String[] args) {
    String Quantitat = JOptionPane.showInputDialog("Quants d'enters vols? ");
    String minim = JOptionPane.showInputDialog("Quin és el nombre mínim? ");
    String maxim = JOptionPane.showInputDialog("Quin és el nombre màxim? ");
    int vegades = 0;
    int quantitat2 = Int.ParseInt(Quantitat)
    while (vegades < 5) {
      System.out.println("Test" + vegades);
      vegades = vegades + 1;
      /*
       * String NombreRandom = java.lang.Math.random() * 100;
       * if (NombreRandom > Minim && NombreRandom < Maxim) {
       * System.out.println("test");
       * NombreRandom = java.lang.Math.random() * 100;
       * }
       * System.out.println(numero);
       */
    }

  }
}