/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class RuntimeTimeTest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int midaArray = 0; //l'emprarem per la mida de l'array
        System.out.println("Quants d'elements voldra que tengui l'array?");
        midaArray = s.nextInt();
        int bubbleArray[] = new int[midaArray]; //cream un array per Bubble Sort
        int selectionArray[] = new int[midaArray]; //cream un array per Selection Sort
        int insertionArray[] = new int[midaArray]; //cream un array per Insertion Sort
        int tipusOmplir = 0; // per averiguar si volem que l'array s'omplir amb nombres aleatoris o manuals
        System.out.println("Com vol que s'ompli l'array?");
        System.out.println("Introdueix 1 si vol introduir els nombres manualment");
        System.out.println("Introdueix un altre nombre si vol nombres autogenerats de 1 a 10");
        tipusOmplir = s.nextInt();
        long timeStart = 0;
        long timeEnd = 0;
        long timeDelta = 0;
        long condicionals = 0;
        timeStart = System.currentTimeMillis();
        System.out.print("Test 1:");
        for (int i = 0; i < bubbleArray.length; i++) { //omplirem l'array, o be amb nombres introduits per usuari o amb aleatoris 
            condicionals++;
            condicionals++;
            if (tipusOmplir == 1) {
                System.out.println("Introdueixi el nombre " + (i + 1));
                bubbleArray[i] = s.nextInt();
            } else {
                bubbleArray[i] = (byte) (Math.random() * 10); //els nombres aleatoris seran de 1 a 10
            }
            selectionArray[i] = bubbleArray[i];
            insertionArray[i] = selectionArray[i];
        }
        timeEnd = System.currentTimeMillis();
        timeDelta = timeEnd - timeStart;
        System.out.println("Ha tardat " + timeDelta);
        System.out.println("Condicions: " + condicionals);
        condicionals = 0;
        timeStart = System.currentTimeMillis();
        System.out.print("Test 2:");
        if (tipusOmplir == 1) {
            condicionals++;
            for (int i = 0; i < bubbleArray.length; i++) { //omplirem l'array, o be amb nombres introduits per usuari o amb aleatoris 
                condicionals++;
                System.out.println("Introdueixi el nombre " + (i + 1));
                bubbleArray[i] = s.nextInt();
                selectionArray[i] = bubbleArray[i];
                insertionArray[i] = selectionArray[i];
            }
        } else {
            for (int i = 0; i < bubbleArray.length; i++) { //omplirem l'array, o be amb nombres introduits per usuari o amb aleatoris 
                condicionals++;
                bubbleArray[i] = (byte) (Math.random() * 10); //els nombres aleatoris seran de 1 a 10
                selectionArray[i] = bubbleArray[i];
                insertionArray[i] = selectionArray[i];
            }
        }
        timeEnd = System.currentTimeMillis();
        timeDelta = timeEnd - timeStart;
        System.out.println("Ha tardat " + timeDelta);
        System.out.println("Condicions: " + condicionals);
    }
}
