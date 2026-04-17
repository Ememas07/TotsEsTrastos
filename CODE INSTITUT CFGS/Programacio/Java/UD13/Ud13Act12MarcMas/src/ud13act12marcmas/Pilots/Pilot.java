/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ud13act12marcmas.pilots;

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

    @Override
    public String toString() {
        return "Id:" + this.getId() + " Nom: " + this.getNom() + " Llinatge: " + this.getLlinatge() + " Nacionalitat: " + this.getNacionalitat();
    }

    public void imprimir() {
        System.out.println("Id:" + this.getId());
        System.out.println("Nom: " + this.getNom());
        System.out.println("Llinatge: " + this.getLlinatge());
        System.out.println("Nacionalitat: " + this.getNacionalitat());
    }

}
