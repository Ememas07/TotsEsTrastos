/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2ActExtra0MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix la contrassenya");
        String input = s.next();
        String contrassenya = "holabondia";
        if (input.equals(contrassenya)) {
            System.out.println("Contrassenya correcta");
        } else {
            System.out.println("Contrassenya incorrecta");
        }
    }
}
