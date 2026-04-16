/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13act10marcmas.pilots;

/**
 *
 * @author Marc Mas
 */
public class Pilot {

    int id;
    String nom;
    String llinatge;
    String nacionalitat;

    public Pilot(int id, String nom, String llinatge, String nacionalitat) {
        this.id = id;
        this.nom = nom;
        this.llinatge = llinatge;
        this.nacionalitat = nacionalitat;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    public String getNacionalitat() {
        return nacionalitat;
    }
    public String getLlinatge() {
        return llinatge;
    }
    
    

}
