/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Vehicle {

    public enum TipusVehicle {
        TERRESTRE, AQUATIC, VOLADOR, ESPACIAL
    };

    public enum FaccioVehicle {
        REBELS, IMPERI, MERCENARIS
    };

    String model;
    TipusVehicle tipus;
    FaccioVehicle faccio;
    int blindatge;
    double velocitatMaxima;

    public Vehicle(String model, TipusVehicle tipus, FaccioVehicle faccio, int blindatge, double velocitatMaxima) {
        this.model = model;
        this.tipus = tipus;
        this.faccio = faccio;
        this.blindatge = blindatge;
        this.velocitatMaxima = velocitatMaxima;
    }

    @Override
    public String toString() {
        return "Model: " + this.model + "Tipus: " + this.tipus + " Faccio:" + this.faccio + " Blindatge: " + this.blindatge + " Velocitat maxima:" + velocitatMaxima;
    }

}
