/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Machine {

    final Coffee ESPRESSO = new Coffee("Espresso", 1.5f);
    final Coffee CAPUCCINO = new Coffee("Capuccino", 2f);
    final Coffee CORTADO = new Coffee("Cortado", 0.75f);
    final Coffee CAFE_AMB_LLET = new Coffee("Cafè amb llet", 1f);
    final Coffee TACAT = new Coffee("Tacat", 3.5f);

    private boolean poweredOn;
    private Coffee[] coffeeList;

    public Machine() {
        this.poweredOn = false; //la maquina comença apagada
        Coffee[] list = new Coffee[5]; //cream un array de cafès amb les constants
        list[0] = ESPRESSO;
        list[1] = CAPUCCINO;
        list[2] = CORTADO;
        list[3] = CAFE_AMB_LLET;
        list[4] = TACAT;
        this.coffeeList = list;
    }

    public void getCoffeeList() {
        for (int i = 0; i < this.coffeeList.length; i++) { //recorrem l'array de cafès i imprimim un numero i el seu nom, a més del preu
            System.out.println((i + 1) + ": " + this.coffeeList[i].getName() + " - " + this.coffeeList[i].getPrice());
        }
    }

    public int getDifferentCoffeeAmount() {
        return this.coffeeList.length; //la quanitat de cafès que tenim
    }

    public String getCoffeeName(int index) { //el nom d'un cafè especific
        return coffeeList[index].getName();
    }

    public float getCoffeePrice(int index) { //preu d'un cafè especific
        return coffeeList[index].getPrice();
    }

    public Coffee getCoffee(int index) { //tot el cafè sencer
        return coffeeList[index];
    }

    public boolean getStatus() { //estat de la màquina (encesa o apagada)
        if (poweredOn) {
            System.out.println("La maquina està encesa");
        } else {
            System.out.println("La maquina està apagada");
        }
        return poweredOn;
    }

    public void powerMachine() {
        poweredOn = !poweredOn; //giram el botó de la maquina
    }

}
