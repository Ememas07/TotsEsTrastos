
// 35) Crea un enum con los días de la semana, pide un día de la semana e indica
// si es laboral o no (en el main).

import javax.swing.JOptionPane;

enum Dies {
    dilluns,
    dimarts,
    dimecres,
    dijous,
    divendres,
    dissabte,
    diumenge
}

public class Exercisi35 {
    public static void main(String[] args) {
        String dia = JOptionPane.showInputDialog("Inserti dia");
        Dies dias = Dies.valueOf(dia.toLowerCase());
        switch (dias) {
            case dilluns:
            case dimarts:
            case dimecres:
            case dijous:
            case divendres:
                System.out.println("Laborable");
                break;
            case dissabte:
            case diumenge:
                System.out.println("No laborable");
                break;
        }
    }
}
