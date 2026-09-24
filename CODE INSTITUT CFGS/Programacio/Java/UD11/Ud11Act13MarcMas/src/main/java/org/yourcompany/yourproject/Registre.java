/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Registre {

    float temperatura;
    Date hora;

    public Registre(float temperatura) {
        this.temperatura = temperatura;
        this.hora = new Date();
    }

    public Registre() {
    }

    public static Registre crearRegistre(Scanner s) {
        System.out.println("Quina es la temperatura actual? (empra ºC i comes per separació decimal)");
        float temperatura = s.nextFloat();
        return new Registre(temperatura);
    }

    @Override
    public String toString() {
        return " Temperatura: " + temperatura + " (" + hora.getHours() + ":" + hora.getMinutes() + ")";
    }

    public float getTemp(){
        return temperatura;
    }
}
