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

    public Soci(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Soci soci) {
        return this.id - soci.id;
    }

    @Override
    public String toString(){
        return "Aquest soci té un ID de "+this.id;
    }

}
