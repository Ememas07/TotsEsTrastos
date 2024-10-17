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

        /*
         * 25) Crea una aplicación llamada CalculadoraPolacaInversaApp, nos pedirá 2
         * operandos (int) y un signo aritmético (String), según este último se
         * realizara la operación correspondiente. Al final mostrara el resultado en un
         * cuadro de dialogo.
         * Los signos aritméticos disponibles son:
         * 
         * +: suma los dos operandos.
         * -: resta los operandos.
         * : multiplica los operandos.
         * /: divide los operandos, este debe dar un resultado con decimales (double)
         * ^: 1º operando como base y 2º como exponente.
         * %: módulo, resto de la división entre operando1 y operando2.
         */

    }

}