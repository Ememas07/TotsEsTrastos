/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.linkedlist;

/**
 *
 * @author Marc Mas
 */
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class LinkedListMarcMas {

    public static void main(String[] args) throws Exception {

        // Force System.out to use UTF-8
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        List list = new List();

        try {

            System.out.println("Adding items...");
            for (int i = 0; i < 10; i++) {
                list.addLast(new Data(i+"0", 10));
                list.addLast(new Data(i+"1", 20));
                list.addFirst(new Data(i+"2", 5));
                list.addFirst(new Data(i+"3", 53));
                list.print();

                System.out.println("Inserting at index 1...");
                // list.addAt(1, new Data("Helmet", 15));
                list.print();
            }

            System.out.println("Removing index 2...");
            Data removed = list.removeAt(2);
            for (int i = 0; i < 10; i++) {
                Data asdf = list.removeAt(i);
            }
            System.out.println("Removed: " + removed);
            list.print();

        } catch (IndexOutOfBoundsException e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
    }
}
