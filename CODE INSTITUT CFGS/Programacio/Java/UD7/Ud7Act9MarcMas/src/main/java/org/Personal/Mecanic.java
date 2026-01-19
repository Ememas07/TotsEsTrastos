/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Personal;

/**
 *
 * @author Marc Mas
 */
public class Mecanic {

    String nom;
    int telefon;
    Especialitats especialitat;

    public enum Especialitats {
        FRENS, HIDRAULICA, ELECTRCITAT, MOTOR
    }

    public Mecanic(String nom, int telefon, Especialitats especialitat) {
        this.nom = nom;
        this.telefon = telefon;
        this.especialitat = especialitat;
    }

}
