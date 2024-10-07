import javax.swing.JOptionPane;

public class Exercisi15 {

	// 15) Lee un número por teclado y comprueba que este numero es mayor o igual
	// que cero, si no lo es lo volverá a pedir (do while), después muestra ese
	// número por consola.
	public static void main(String[] args) {
		int A = -1;
		while (A < 1) {
			A = Integer.parseInt(JOptionPane.showInputDialog("Posi un numero major que 0"));
		}
		System.out.println(A);
	}

}
