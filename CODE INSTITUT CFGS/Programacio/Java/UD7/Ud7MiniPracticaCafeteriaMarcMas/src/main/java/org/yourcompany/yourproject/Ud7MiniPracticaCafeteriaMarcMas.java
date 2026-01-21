/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud7MiniPracticaCafeteriaMarcMas {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8"));
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to my coffee shop!");
        byte option = 0;
        Machine m = new Machine();
        Waiter w = new Waiter();
        w.powerMachine(m); //encenem la cafetera
        while (option < 3) { //3 or higher will exit
            try {
                System.out.println("1: See available coffee options");
                System.out.println("2: Order coffee");
                System.out.println("3: Leave coffee shop");
                option = s.nextByte();
                switch (option) {
                    case 1 -> { //Show options
                        w.showOptions(m);
                    }
                    case 2 -> { //Order
                        w.orderCoffee(s, m);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please input a valid option");
            }
        }
        System.out.println("Hey! you have to pay!");
        System.out.println("Total Bill: " + w.getBill());
        w.writeBill(s);
        w.powerMachine(m); //apagam la cafetera
    }
}
