/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Moto {

    String matricula;
    float cilindrada;

    public Moto(String matricula, float cilindrada) {
        this.matricula = matricula;
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Matricula: " + this.matricula + " Cilindrada: " + this.cilindrada + " L";
    }

}
