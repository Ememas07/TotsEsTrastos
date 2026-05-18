/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Cotxe {

    public enum MarcaCotxe {
        PORSCHE, ASTON_MARTIN, RENAULT, BMW, DACIA
    };
    MarcaCotxe marca;
    String model;
    float cilindrada;

    public Cotxe(MarcaCotxe marca, String model, float cilindrada) {
        this.marca = marca;
        this.model = model;
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Marca i Model: " + this.marca + " " + this.model + " Cilindrada: " + this.cilindrada + " L";
    }

}
