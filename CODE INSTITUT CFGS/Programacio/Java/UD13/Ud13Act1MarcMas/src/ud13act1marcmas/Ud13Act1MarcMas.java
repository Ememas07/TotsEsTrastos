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
        Scanner s = new Scanner(System.in);
        int opcio = 0;
        System.out.println("Quina activitat vol executar?");
        opcio = s.nextInt();
        switch (opcio) {
            case 1:
                Activitat1();
            case 2:
                Activitat2();
            case 3:
                Activitat3();
            case 4:
                Activitat4();
            case 5:
                Activitat5();
            case 6:
                Activitat6();
            case 7:
                Activitat7();
        }
    }

    public static void Activitat1() {
        // 3.1 Incrementar la data dels grans premis d'estats Units en un dia. Emprar UPDATE.
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
        // 13.2 Realitzar una aplicació que sol·licita totes les dades d'un nou gran premi i els insereixi a la BD
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
        // 13.3 Solicitar el nom d'un gran premi i esborrar-lo de la BD
        try {
            Scanner s = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            String sql0 = "SELECT * FROM Races";
            Statement st0 = con.createStatement();
            ResultSet gp = st0.executeQuery(sql0);
            while (gp.next()) {
                System.out.println("Carreres: " + gp.getInt("race_id") + " - " + gp.getString("race_name"));
            }
            System.out.println("Nom del gran premi?");
            String nom = s.nextLine();
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
        // 13.4 Mostra el nom i l'equip dels pilots que han puntuat a un gran premi, que es sol·licitarà a l'usuari per teclat.
        // Podeu oferir un llistat de grans premis i sol·licitar un nombre, en lloc del nom
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
                System.out.println(td.getString("first_name") + " " + td.getString("last_name") + " - " + td.getString("team_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

    public static void Activitat5() {
        // 13.5 Invertir l'ordre de visualització de l'activitat anterior.
        try {
            Scanner s = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            String sql = "SELECT * FROM Races";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet gp = st.executeQuery(sql);
            gp.afterLast();
            while (gp.previous()) {
                System.out.println("Carreres: " + gp.getInt("race_id") + " - " + gp.getString("race_name"));
            }

            System.out.println("ID del gran premi?");
            int id = s.nextInt();
            String sql2 = "select * from results left join drivers USING (driver_id) left join teams USING (team_id) where points > 1 && race_id = " + id;
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet td = st2.executeQuery(sql2);
            td.afterLast();
            while (td.previous()) {
                System.out.println(td.getString("first_name") + " " + td.getString("last_name") + " - " + td.getString("team_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

    public static void Activitat6() {
        // 13.6 Mostra la classificació de pilots i després mostra la classificació de constructors.
        try {
            Scanner s = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            String sql = "SELECT CONCAT(first_name,\" \",last_name) as pilot,SUM(points) as punts FROM `results` left join drivers USING (driver_id)  GROUP BY pilot order by punts desc";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet gp = st.executeQuery(sql);
            while (gp.next()) {
                System.out.println("Carreres: " + gp.getInt("race_id") + " - " + gp.getString("race_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

    public static void Activitat7() {
        //13.7 Implementar un programa que sol·liciti el nom d'un pilot i que l'esborri.
        // Demostra amb un exemple com es pot realitzar SQL Injection.

        try {
            Scanner s = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            String sql = "SELECT * FROM Races";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet gp = st.executeQuery(sql);
            gp.afterLast();
            while (gp.previous()) {
                System.out.println("Carreres: " + gp.getInt("race_id") + " - " + gp.getString("race_name"));
            }

            System.out.println("ID del gran premi?");
            int id = s.nextInt();
            String sql2 = "select * from results left join drivers USING (driver_id) left join teams USING (team_id) where points > 1 && race_id = " + id;
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet td = st2.executeQuery(sql2);
            td.afterLast();
            while (td.previous()) {
                System.out.println(td.getString("first_name") + " " + td.getString("last_name") + " - " + td.getString("team_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

}
