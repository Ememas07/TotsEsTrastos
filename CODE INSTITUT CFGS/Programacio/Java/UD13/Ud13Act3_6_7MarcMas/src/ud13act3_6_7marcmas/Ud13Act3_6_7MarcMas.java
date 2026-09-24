/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13act3_6_7marcmas;

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
public class Ud13Act3_6_7MarcMas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcio = 0;
        System.out.println("Quina activitat vol executar?");
        opcio = s.nextInt();
        switch (opcio) {
            case 3 ->
                Activitat3();
            case 6 ->
                Activitat6();
            case 7 ->
                Activitat7();
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
            while (gp.next()) { //feim un bucle que vagi per tots els registres i les anam imprimint
                System.out.println("Carreres: " + gp.getInt("race_id") + " - " + gp.getString("race_name"));
            }
            System.out.println("Nom del gran premi?");
            String nom = s.nextLine();
            Statement st = con.createStatement();
            String sql = "DELETE FROM `f1_2023`.`races` WHERE `race_name` = \'" + nom + "\'";
            int filesAfectades = st.executeUpdate(sql);
            System.out.println("S'han canviat " + filesAfectades + " Files");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

    public static void Activitat6() {
        // 13.6 Mostra la classificació de pilots i després mostra la classificació de constructors.
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
            String sql = "SELECT CONCAT(first_name,\" \",last_name) as pilot,SUM(points) as punts FROM `results` left join drivers USING (driver_id)  GROUP BY pilot order by punts desc";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet gp = st.executeQuery(sql);
            System.out.println("Pilots:");
            while (gp.next()) { //feim un bucle que vagi per tots els registres i les anam imprimint
                System.out.println(gp.getString("pilot") + " - " + gp.getInt("punts"));
            }

            System.out.println("Equips:");
            String sql2 = "SELECT team_name as equip ,SUM(points) as punts  FROM `results` left join teams USING (team_id)  GROUP BY equip order by punts desc";
            Statement st2 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet gp2 = st2.executeQuery(sql2);
            while (gp2.next()) { //feim un bucle que vagi per tots els registres i les anam imprimint
                System.out.println(gp2.getString("equip") + " - " + gp2.getInt("punts"));
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
            String sql = "SELECT * FROM drivers";
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet gp = st.executeQuery(sql);
            while (gp.next()) { //feim un bucle que vagi per tots els registres i les anam imprimint
                System.out.println(gp.getInt("driver_id") + ":" + gp.getString("first_name") + " " + gp.getString("last_name"));
            }
            System.out.println("Quin pilot vols borrar? (posa nomes el nom, no el llinatge)");
            String nom = s.next();
            String sql2 = "DELETE FROM drivers WHERE first_name = \'" + nom + "\'";
            // se podria fer SQL injection si posam un nom OR 1=1
            int filesAfectades = st.executeUpdate(sql2);
            System.out.println("S'han canviat " + filesAfectades + " Files");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en la connexió");
        }
    }

}
