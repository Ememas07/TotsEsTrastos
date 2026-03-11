/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.Vehicles;

/**
 *
 * @author Marc Mas
 */
public class Moto extends Vehicle {

    int numeroPlaces;
    float consumBenzina;

    public Moto(int numeroPlaces, float consumBenzina) {
        this.numeroPlaces = numeroPlaces;
        this.consumBenzina = consumBenzina;
    }

    @Override
    public void descripcio() {
        System.out.println("Tipus de vehicle: " + this.getClass().getSimpleName());
        System.out.println("Numero de places: " + numeroPlaces);
        System.out.println("Consum de benzina: " + consumBenzina + "l/100km");
    }
}
