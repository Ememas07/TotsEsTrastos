/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud7MiniPracticaCafeteriaComplicadaMarcMas {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Welcome to my coffee shop!");
            byte option = 0;
            System.out.println("How many Waiters are there?");
            int nWaiters = s.nextInt();
            System.out.println("How many Machines are there?");
            int nMachines = s.nextInt();
            CoffeeShop cs = new CoffeeShop(nWaiters, nMachines, s);
            Waiter w; //cream pero no feim res ja que les re-asignarem despres
            Machine m;
            while (option < 3) { //3 or higher will exit
                System.out.println("1: See available coffee options");
                System.out.println("2: Order coffee");
                System.out.println("3: Leave coffee shop");
                option = s.nextByte();
                switch (option) {
                    case 1 -> { //Show options
                        w = cs.getSpecificWaiter(s);
                        m = cs.getSpecificMachine(s);
                        w.powerMachine(m); //encenem la cafetera
                        w.showOptions(m);
                        w.powerMachine(m); //apagam la cafetera
                    }
                    case 2 -> { //Order
                        w = cs.getSpecificWaiter(s);
                        m = cs.getSpecificMachine(s);
                        w.powerMachine(m); //encenem la cafetera
                        w.orderCoffee(s, m);
                        w.powerMachine(m); //apagam la cafetera
                    }
                }
            }
            System.out.println("Hey! you have to pay!");
            cs.endDay(s);
        } catch (InputMismatchException e) {
            System.out.println("Please input a valid option");
        }
    }
}
