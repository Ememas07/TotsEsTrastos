/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class CoffeeShop {

    private int nWaiters;
    private int nMachines;
    private Waiter[] Waiters;
    private Machine[] Machines;
    private String[] waiterNames;
    private String[] machineNames;

    public CoffeeShop(int nWaiters, int nMachines, Scanner s) {
        Waiters = new Waiter[nWaiters];
        waiterNames = new String[nWaiters];
        Machines = new Machine[nMachines];
        machineNames = new String[nMachines];
        for (int i = 0; i < nWaiters; i++) {
            Waiters[i] = new Waiter();
            System.out.println("What's the name of the waiter " + (i + 1) + " ?");
            waiterNames[i] = s.next() + s.nextLine();
        }
        for (int i = 0; i < nMachines; i++) {
            Machines[i] = new Machine();
            System.out.println("What's the name of the Machine " + (i + 1) + " ?");
            machineNames[i] = s.next() + s.nextLine();
        }
    }

    public Machine getSpecificMachine(Scanner s) {
        System.out.println("On which machine?");
        this.getMachineNames();
        int machineNumber = s.nextInt() - 1;
        while (machineNumber > nWaiters || machineNumber < 0) {
            System.out.println("Not a valid number!");
            machineNumber = s.nextInt() - 1;
        }
        return Machines[machineNumber];
    }

    public Waiter getSpecificWaiter(Scanner s) {
        System.out.println("Which waiter would you like to get attended by?");
        this.getWaiterNames();
        int waiterNumber = s.nextInt() - 1;
        while (waiterNumber > nWaiters || waiterNumber < 0) {
            System.out.println("Not a valid number!");
            waiterNumber = s.nextInt() - 1;
        }
        return Waiters[waiterNumber];
    }

    public void getWaiterNames() {
        for (int i = 0; i < waiterNames.length; i++) {
            System.out.println((i + 1) + ": " + waiterNames[i]);
        }
    }

    public void getMachineNames() {
        for (int i = 0; i < machineNames.length; i++) {
            System.out.println((i + 1) + ": " + machineNames[i]);
        }
    }

    public void endDay(Scanner s) {
        for (Waiter w : Waiters) {
            if (w.getServedCoffeesAmount() > 0) {
                String[] cafesDiferents = w.getUniqueServedCoffeeNames();
                w.getOrderSummary();
                System.out.println("Total Bill: " + w.getBill());
                w.writeBill(s);
            }
        }
    }
}
