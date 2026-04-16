/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13act10marcmas;

import java.sql.SQLException;
import java.util.Scanner;

import ud13act10marcmas.pilots.Pilot;
import ud13act10marcmas.pilots.PilotDAO;

/**
 *
 * @author Marc Mas
 */
public class Ud13Act10MarcMas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Pilot p = new Pilot(0, "null", "null", "null");
        int opcio = 0;
        while (opcio > -1) {

            System.out.println("Opcions:");
            System.out.println("0: Create");
            System.out.println("1: Read");
            System.out.println("2: Update");
            System.out.println("3: Delete");
            System.out.println("4: Crear un pilot per emprar despres");
            System.out.println("-1: Sortir");
            opcio = s.nextInt();
            PilotDAO pd = new PilotDAO();

            switch (opcio) {
                case 0 -> {
                    pd.create(p);
                }
                case 1 -> {
                    int id = s.nextInt();
                    try {
                        pd.read(id);
                    } catch (SQLException e) {
                    }
                }
                case 2 -> {
                    pd.update(p);
                }
            }
        }
    }
}
