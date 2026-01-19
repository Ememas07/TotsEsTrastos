/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.Hora.Hora;

/**
 * Escriu un programa que llegeixi per teclat una hora qualssevol i un nombre n
 * que representa la quantitat de segons.
 *
 * El programa mostrarà l'hora introduïda i les n següents, en intervals de un
 * segon.
 *
 * Per a això hem de dissenyar la classe Hora, que disposa dels atributs hora,
 * minut i segon.
 *
 * Els valors dels atributs es controlaran mitjançant mètodes get i set.
 *
 * @author Marc Mas
 */
public class Ud7Act6MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Introdueixi una hora");
            byte hora = s.nextByte(); //agafam l'hora per consola
            while (hora > 23 || hora < 0) { //si no es una hora entre 0 i 23, la tornam a demanar
                System.out.println("Introdueixi una hora valida!");
                hora = s.nextByte();
            }
            Hora h = new Hora(hora); //crear objecte amb l'hora introduida
            System.out.println("Introdueixi un numero de segons");
            int segons = s.nextInt(); //agafam segons per consola
            for (int i = 0; i < segons; i++) { //executam "sumarSegons" amb l'hora inicial i sumam "i" segons a l'hora inicial
                h.sumarSegons(i);
            }
        } catch (InputMismatchException e) { //si no posam un byte, acabam el programa ja que botarà l'excepció
            System.out.println("Introdueixi una hora valida!");
        }
    }
}
