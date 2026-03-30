/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13act1marcmas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
        Activitat4();
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
            String sql = "DELETE FROM `f1_2023`.`races` WHERE `race_name` = \'" + nom + "\'";
            System.out.println(sql);
            int filesAfectades = st.executeUpdate(sql);
            System.out.println("S'han canviat " + filesAfectades + " Files");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

    public static void Activitat4() {
        try {
            Scanner s = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            String sql = "SELECT * FROM Races";
            Statement st = con.createStatement();
            ResultSet gp = st.executeQuery(sql);
            while (gp.next()) {
                System.out.println("Carreres: " + gp.getInt("race_id") + " - " + gp.getString("race_name"));
            }

            System.out.println("ID del gran premi?");
            int id = s.nextInt();
            String sql2 = "select * from results left join drivers USING (driver_id) left join teams USING (team_id) where points > 1 && race_id = " + id;
            Statement st2 = con.createStatement();
            ResultSet td = st2.executeQuery(sql2);
            while (td.next()) {
                System.out.println(td.getString("first_name") +" "+ td.getString("last_name")+" - "+td.getString("team_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

}
