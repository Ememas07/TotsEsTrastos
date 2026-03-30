/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13act1marcmas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud13Act1MarcMas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Activitat3();
    }

    public static void Activitat1() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            Statement st = con.createStatement();
            String sql = "UPDATE `f1_2023`.`races` SET `race_date` = race_date + WHERE `country` = 'United States';";
            int filesAfectades = st.executeUpdate(sql);
            System.out.println("S'han canviat " + filesAfectades + " Files");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

    public static void Activitat2() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Nom del gran premi?");
            String nom = s.nextLine();
            System.out.println("Data? Format YYYY-MM-DD");
            String data = s.nextLine();
            System.out.println("Pais?");
            String pais = s.nextLine();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            Statement st = con.createStatement();
            String sql = "INSERT INTO `f1_2023`.`races` (`race_name`,`race_date`,`country`) VALUES (" + "\'" + nom + "','" + data + "','" + pais + "')";
            int filesAfectades = st.executeUpdate(sql);
            System.out.println("S'han canviat " + filesAfectades + " Files");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

    public static void Activitat3() {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Nom del gran premi?");
            String nom = s.nextLine();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            Statement st = con.createStatement();
            String sql = "DELETE FROM `f1_2023`.`races` WHERE `race_name` = '" + nom + "'";
            int filesAfectades = st.executeUpdate(sql);
            System.out.println("S'han canviat " + filesAfectades + " Files");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

}
