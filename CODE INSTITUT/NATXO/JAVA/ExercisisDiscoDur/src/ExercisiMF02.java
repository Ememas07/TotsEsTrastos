import javax.swing.JOptionPane;

public class ExercisiMF02 {

    public static void main(String[] args) {
        String Quantitat = JOptionPane.showInputDialog("Quants d'enters vols? ");
        String Minim = JOptionPane.showInputDialog("Quin és el nombre mínim? ");
        String Maxim = JOptionPane.showInputDialog("Quin és el nombre màxim? ");
        int quantitat2 = Integer.parseInt(Quantitat);
        while (quantitat2 < 5) {
            System.out.println("Test" + quantitat2);
            quantitat2 = quantitat2 + 1;
            Double NombreRandom = java.lang.Math.random() * 100;
            Double minim = Double.parseDouble(Minim);
            Double maxim = Double.parseDouble(Maxim);
            if (NombreRandom > minim && NombreRandom < maxim) {
                System.out.println("test");
                NombreRandom = java.lang.Math.random() * 100;
            }
            System.out.println(NombreRandom);

        }

    }
}
