/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act4MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueixi un numero");
        Integer n1 = s.nextInt();
        System.out.println("Introdueixi un altre numero");
        Integer n2 = s.nextInt();
        System.out.println("Introdueixi un altre numero");
        Integer n3 = s.nextInt();
        if (n1 > n2) { // N1 major que N2
            if (n1 > n3) {  // N1 major que N2 i N3
                if (n3 > n2) { // N1 major que N2, N1 major que N3, N3 major que N2
                    System.out.println(+n1 + " > " + n3 + " > " + n2);
                } else {
                    System.out.println(+n1 + " > " + n2 + " > " + n3);
                }
            } else { // N1 major que N2, N3 major que N1
                System.out.println(+n3 + " > " + n1 + " > " + n2);
            }
        } else { // N2 major que N1
            if (n2 > n3) { // N2 major que N1 i major que N3
                if (n3 > n1) { // N2 major que N1, N3 major que N1
                    System.out.println(+n2 + " > " + n3 + " > " + n1);
                } else {
                    System.out.println(+n2 + " > " + n1 + " > " + n3);
                }
            } else { // N3 es major que N2 i N1
                System.out.println(+n3 + " > " + n2 + " > " + n1);
            }
        }
    }
}
