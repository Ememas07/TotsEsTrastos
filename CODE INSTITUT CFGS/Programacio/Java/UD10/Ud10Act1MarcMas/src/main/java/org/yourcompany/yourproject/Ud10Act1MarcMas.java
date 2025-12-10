/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * Escriure el mètode Integer llegirEnter(), que demani un enter per consola,
 * llegeix del teclat i ho retorna.
 *
 * Si la cadena introduïda per consola no té el format correcte, mostra un
 * missatge d'error i torna a demanar-ho.
 *
 * @author Marc Mas
 */
public class Ud10Act1MarcMas {

    public static int llegirEnter() {
        while (true) {
            Scanner s = new Scanner(System.in);
            int input = 0;
            System.out.println("Introdueixi un numero enter");
            try {
                input = s.nextInt(); //provam de assignar
                return input; //quan haguem sortir, retornar
            } catch (InputMismatchException e) { //si falla, mostram error i tornam cridar
                System.out.println("Introdueix un valor valid!");
                // input = llegirEnter(); //tambe funciona enlloc del while true
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(llegirEnter());
    }
}
