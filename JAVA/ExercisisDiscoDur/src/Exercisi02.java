
public class Exercisi02 {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;
		int major = Math.max(n1, n2);
		int menor = Math.min(n1, n2);

		System.out.println("Els nombres són " + n1 + " , " + n2);
		if (major != menor) {
			System.out.println("El major és " + major);
			System.out.println("El menor és " + menor);
		} else {
			System.out.println("Tots dos són iguals");

		}

	}
}