/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Dni {

    String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";

    public Dni(int digits) {
        this.digits = digits;
        this.lletra = lletres.charAt(digits % 23);
    }

    int digits;
    char lletra;

    String imprimir() {
        return "" + this.digits + this.lletra;
    }
}
