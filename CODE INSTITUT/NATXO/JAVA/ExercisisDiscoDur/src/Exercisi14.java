import javax.swing.JOptionPane;

public class Exercisi14 {
	public static void main(String[] args) {
	System.out.println("Calculador d'equacions de segon grau");

	
	
	double A = Double.parseDouble(JOptionPane.showInputDialog("Numero A"));
	double B = Double.parseDouble(JOptionPane.showInputDialog("Numero B"));
	double C = Double.parseDouble(JOptionPane.showInputDialog("Numero C"));
	if(-4*A*C <0 || 2*A == 0) {
		System.out.println("No té solució");
	}else {
	
	
	double resultatparcial = (-B*Math.sqrt((Math.pow(B, 2)-(4*A*C))));
	double resultat1 = (-B*Math.sqrt(Math.pow(B, 2)-4*A*C))/ 2*A;
	double resultat2 = (-B*-Math.sqrt(Math.pow(B, 2)-4*A*C))/ 2*A;
	System.out.println(resultatparcial);
	System.out.println("El resultat positiu és "+resultat1);
	System.out.println("El resultat negatiu és "+resultat2);
	}
	
	
	
	
	
	//Parts de l'equació: -b, -4ac, sqrt, 2a, 
	
	
	

	
	

	
	
		
		
		
	
	
	
	
	
	
	}
	
}


































