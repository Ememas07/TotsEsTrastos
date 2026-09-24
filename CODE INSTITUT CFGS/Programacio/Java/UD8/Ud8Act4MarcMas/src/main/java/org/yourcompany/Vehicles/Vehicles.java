/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.Vehicles;

import java.util.Arrays;

/**
 *
 * @author Marc Mas
 */
public class Vehicles {

    Vehicle[] vehicles;

    public Vehicles() {
        this.vehicles = new Vehicle[0];
    }

    public void add(Vehicle v) {
        vehicles = Arrays.copyOf(vehicles, vehicles.length + 1); //copiam array
        vehicles[vehicles.length - 1] = v; //afegim vehicle
    }

    public Vehicle[] getVehicles() {
        return Arrays.copyOf(vehicles, vehicles.length);
    }

}
