
public class Exercisi21 {

    public static void main(String[] args) {
        Integer numero = 1;
        if (numero <= 1) {
            System.out.println("El numero no es primo");
        }

        while (numero < 99) {
            int raiz = (int) Math.sqrt(numero);
            int contador = 0;
            for (int i = raiz; i > 1; i--) {
                if (numero % i == 0) {
                    contador++;
                }
            }

            if (contador < 1) {

                System.out.println("El numero " + numero + " es primo");
            }
            numero = numero + 1;
        }
    }
}
