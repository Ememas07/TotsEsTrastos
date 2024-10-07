import javax.swing.JOptionPane;

public class Exercisi17 {
    // 17) Crea una aplicación que nos pida un día de la semana y que nos diga si es
    // un dia laboral o no. Usa un switch para ello.

    public static void main(String[] args) {
        String DiaLaborable = JOptionPane.showInputDialog("Quin dia vols?");
        switch (DiaLaborable) {
            case "Dissabte":
            case "Diumenge":
                System.out.println("no laborable");
                break;

            case "Dilluns":
            case "Dimarts":
            case "Dimecres":
            case "Dijous":
            case "Divendres":
                System.out.println("dia laborable");
                break;
            default:
                System.out.println("No es un dia, posi la D majuscula");

        }
    }
}
