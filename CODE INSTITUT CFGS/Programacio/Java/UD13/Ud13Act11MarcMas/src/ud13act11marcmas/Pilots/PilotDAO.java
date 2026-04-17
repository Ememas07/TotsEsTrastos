/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13act11marcmas.pilots;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marc Mas
 */
public class PilotDAO {

    private Connection con;

    public PilotDAO() {
    }

    public void connectar() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:33700/f1_2023", "root", "holaquetal");
    }

    public void create(Pilot p) {
        try {
            Statement st = con.createStatement();
            String sql = "INSERT INTO drivers (first_name,last_name,nationality) VALUES (" + "\'" + p.getNom() + "','" + p.getLlinatge() + "','" + p.getNacionalitat() + "')";
            int filesAfectades = st.executeUpdate(sql);
            System.out.println("S'han canviat " + filesAfectades + " Files");
            con.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public Pilot read(int id) throws SQLException {
        try {
            String sql = "SELECT * from drivers where driver_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Pilot p = new Pilot(id, rs.getString("first_name"), rs.getString("last_name"), rs.getString("nationality"));
            con.close();
            return p;
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return new Pilot(0, "NULL", "NULL", "NULL");
    }

    public void update(Pilot p) {
        try {
            String sql = "UPDATE drivers set first_name = ?, last_name = ?, nationality = ? WHERE driver_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getLlinatge());
            ps.setString(3, p.getNacionalitat());
            ps.setInt(4, p.getId());
            int filesAfectades = ps.executeUpdate();
            System.out.println("S'han canviat " + filesAfectades + " Files");
            con.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE from drivers where driver_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    public void mostrarTaula() {
        try {
            String sql = "SELECT * from drivers";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("driver_id") + " | " + "Nom:" + rs.getString("first_name") + " | " + "Llinatge:" + rs.getString("last_name") + " | " + "Pais: " + rs.getString("nationality"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }

}
