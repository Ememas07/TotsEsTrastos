/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Soci;

/**
 *
 * @author Marc Mas
 */
public class Soci implements Comparable<Soci> {

    int id;
    String nom;

    public Soci(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public int compareTo(Soci soci) {
        Soci nomCurt;
        if (soci.nom.length() > this.nom.length()) {
            nomCurt = this;
        } else {
            nomCurt = soci;
        }
        for (int i = 0; i < nomCurt.nom.length(); i++) {
            int lletra1 = (int) soci.nom.toLowerCase().charAt(i);
            int lletra2 = (int) this.nom.toLowerCase().charAt(i);
            if (lletra1 > lletra2 || lletra2 > lletra1) {
                return lletra2 - lletra1;
            }
        }
        return 0;

    }

    @Override
    public String toString() {
        return "Aquest soci se nom " + this.nom + " i té un ID de " + this.id;
    }

}
