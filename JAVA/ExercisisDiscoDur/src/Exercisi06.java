import javax.swing.JOptionPane;

public class Exercisi06 {
	public static void main(String[] args) {
	System.out.println("Nombre divisible per 2");
	String num1 = JOptionPane.showInputDialog("Introdueix un nombre");
	Double numero= Double.parseDouble(num1);
	if(numero % 2 == 0) {
		System.out.println("El nombre que ha introduit (" +num1 +") és divisible per 2");
	}else {
		System.out.println("El nombre que ha introduit (" +num1 +") no és divisible per 2");
	}
		
		
		
	
	
	
	
	
	
	}
	
}


































