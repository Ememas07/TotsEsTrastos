/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Waiter {

    private Coffee[] servedCoffees;

    public Waiter() {
        this.servedCoffees = new Coffee[0]; //quan cream el cambrer, no hi ha cafès demanats
    }

    public void orderCoffee(Scanner s, Machine m) {
        m.getCoffeeList(); //Show available options
        System.out.println("What coffee do you want?");
        try {
            int option = (s.nextInt() - 1); //agafam el -1 perque el menù els mostra començant per 1 ja que l'array comença a 0
            while (option > m.getDifferentCoffeeAmount() - 1 || option < 0) { //si hem posat un numero massa alt, mostram error
                System.out.println("Insert a valid coffee number!");
                option = s.nextInt() - 1;
            }
            System.out.println("Here's your " + m.getCoffeeName(option) + "!"); //mostram que hem comanat el cafè a l'usuari
            Coffee[] newList = Arrays.copyOf(servedCoffees, servedCoffees.length + 1); //copiam l'array amb longitut +1
            newList[newList.length - 1] = m.getCoffee(option); //assignam el cafè a la darrera posició de l'array nou
            servedCoffees = newList; //sobreescrivim l'array
            System.out.println("Current bill: " + this.getBill()); //imprimim preu actual
        } catch (InputMismatchException e) {
            System.out.println("Please input a valid option");
        }
    }

    public void showOptions(Machine m) {
        m.getCoffeeList(); //print de tots els cafès
    }

    public Coffee[] getServedCoffees() {
        return servedCoffees; //retornam l'array dels cafès
    }

    public int getServedCoffeesAmount() {
        return servedCoffees.length; //retornam l'array dels cafès
    }

    public void powerMachine(Machine m) {
        m.powerMachine();
    }

    public void getOrderSummary() {
        for (Coffee servedCoffee : servedCoffees) {
            System.out.println(servedCoffee.getName() + " - " + servedCoffee.getPrice()); //recorrem array i imprimim tots els cafès m
        }
    }

    public String[] getUniqueServedCoffeeNames() {
        String[] uniqueCoffeeNames = new String[0];
        for (Coffee servedCoffee : servedCoffees) {
            if (!this.isInArray(uniqueCoffeeNames, servedCoffee.getName())) {
                uniqueCoffeeNames = Arrays.copyOf(uniqueCoffeeNames, uniqueCoffeeNames.length + 1);
                uniqueCoffeeNames[uniqueCoffeeNames.length - 1] = servedCoffee.getName();
            }
        }
        return uniqueCoffeeNames;
    }

    public boolean isInArray(String[] array, String text) {
        for (int i = 0; i < array.length; i++) {
            if (text.equals(array[i])) {
                return false;
            }
        }
        return true;
    }

    public float getBill() {
        float price = 0f;
        for (Coffee servedCoffee : servedCoffees) { //per cada cafè a la llista de cafès, sumam el preu
            price += servedCoffee.getPrice();
        }
        return price;
    }

    public void writeBill(Scanner s) {
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("factura.txt")); //cream l'arxiu 
            for (Coffee servedCoffee : servedCoffees) {
                file.write(servedCoffee.getName() + " - " + servedCoffee.getPrice()); //recorrem array i l'omplim amb tots els cafès
                file.newLine();
            }
            System.out.println("Who's name should we put on the bill?"); //agafam el nom per la factura
            String name = s.next() + s.nextLine(); //agafam el nom per consola
            file.write("Total Bill: " + this.getBill()); //posam preu total
            file.newLine();
            System.out.println("Paid by: " + name); //posam qui ha pagat
            file.write("Paid by: " + name);
            file.close(); //tancam arxiu
        } catch (IOException e) {
            System.out.println("Issues with I/O!");
        }
    }
}
