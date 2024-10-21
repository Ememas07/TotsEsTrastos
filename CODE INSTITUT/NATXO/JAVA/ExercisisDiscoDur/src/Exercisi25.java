import javax.swing.JOptionPane;

public class Exercisi25 {
    public static void main(String[] args) {
        Integer Resultat = 0;
        Integer operando1 = Integer.parseInt(JOptionPane.showInputDialog("Introdueix Operando 1"));
        Integer operando2 = Integer.parseInt(JOptionPane.showInputDialog("Introdueix Operando 2"));
        String signo = JOptionPane.showInputDialog("Introdueix Signe aritmètic");
        Double Op1 = Double.parseDouble(Integer.toString(operando1));
        Double Op2 = Double.parseDouble(Integer.toString(operando2));
        Double Resultat2 = Double.parseDouble(Integer.toString(Resultat));
        switch (signo) {
            case "+":
                Resultat = operando1 + operando2;
                System.out.println(Resultat);
                break;
            case "-":
                Resultat = operando1 - operando2;
                System.out.println(Resultat);
                break;
            case ":":
                Resultat = operando1 * operando2;
                System.out.println(Resultat);
                break;
            case "/":
                Resultat2 = Op1 / Op2;
                System.out.println(Resultat2);
                break;
            case "^":
                Resultat2 = Math.pow(Op1, Op2);
                System.out.println(Resultat2);
                break;
            case "%":
                Resultat = operando1 % operando2;
                System.out.println(Resultat);
        }

    }

}