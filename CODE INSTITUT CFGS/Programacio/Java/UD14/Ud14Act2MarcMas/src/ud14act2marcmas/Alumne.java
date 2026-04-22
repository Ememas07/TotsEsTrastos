/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud14act2marcmas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Modifica la classe Alumne per a que la JPA s’encarregui d’assignar un nom
 * distint a cada alumne
 *
 * @author Marc Mas
 */
@Entity
public class Alumne implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int nombreAlumne;
    String nom;
    String direccio;
    float notaMitjana;

    public Alumne() {

    }

    public Alumne(String nom, String direccio, float notaMitjana) {
        this.nom = nom;
        this.direccio = direccio;
        this.notaMitjana = notaMitjana;
    }

    public int getNombreAlumne() {
        return nombreAlumne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public float getNotaMitjana() {
        return notaMitjana;
    }

    public void setNotaMitjana(float notaMitjana) {
        this.notaMitjana = notaMitjana;
    }

}
