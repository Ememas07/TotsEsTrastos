import javax.swing.JOptionPane;;

public class ExercisiMF05 {
    public static void main(String[] args) {
        // 5) Crea una aplicación que nos convierta un número en base decimal a binario.
        // Esto lo realizara un método al que le pasaremos el numero como parámetro,
        // devolverá un String con el numero convertido a binario. Para convertir un
        // numero decimal a binario, debemos dividir entre 2 el numero y el resultado de
        // esa división se divide entre 2 de nuevo hasta que no se pueda dividir mas, el
        // resto que obtengamos de cada división formara el numero binario, de abajo a
        // arriba. Veamos un ejemplo: si introducimos un 8 nos deberá devolver
        // 1000decimalabinario

        Integer num = Integer.parseInt(JOptionPane.showInputDialog("Introdueix numero"));
        Integer numactual = num;
        Integer resto = 0;
        String resultatactual = "";
        while (numactual > 1) {
            numactual = numactual / 2;
            resto = numactual % 2;
            resultatactual = resultatactual + resto;
        }
        System.out.println(resultatactual);
    }

}
