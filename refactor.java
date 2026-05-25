public class Ex1_Renombrat {

    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        int x = 0;
        x = a + b;
        System.out.println("El número al·lots és " + a);
        System.out.println("El número al·lotes és " + b);
        System.out.println("El total de alumnes és " + x);
    }
}

public class Ex02_Move {

    public static void main(String[] args) {
    }

    public static int suma(int a, int b) {
        return a + b;
    }
}

public class Ex03_ExtractLocalVariable {
	

    public static void main(String[] args) {
        String x = "Aprenent a refactorizar!";
		System.out.println(x);
    }
}


public class Ex04_ExtractConstant {

    private static final String APRENENT_A_REFACTORIZAR = "Aprenent a refactorizar!";

	public static void main(String[] args) {
        System.out.println(APRENENT_A_REFACTORIZAR);
    }
}

public class Ex05_ConvertLocalVbleToField {

    private int lado;

	public int calcularArea() {
        lado = 5;
        return lado * lado;
    }
}

public class Ex06_ExtractInterface implements Interface {

    @Override
	public boolean esMayor() {
        return true;
    }

    @Override
	public boolean esMenor() {
        return true;
    }

    @Override
	public boolean esIgual() {
        return true;
    }
}

public class Ex07_ExtractMethod {

    public boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo = true;
        primo = extracted(numero, contador, primo);
        return primo;
    }

	private boolean extracted(int numero, int contador, boolean primo) {
		while (primo && contador != numero) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
		return primo;
	}

    public boolean esPar(int numero) {
        return (numero % 2 == 0);
    }
}

public class Ex08_ChangeMethodSignature {

    public static void main(String[] args) {
        System.out.println(miMetodo());
    }

    protected static boolean elmeuMètode() {
        int numero = 75;
        int contador = 2;
        boolean primo = true;
        while (primo && contador != numero) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }
}