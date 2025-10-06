/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2ActExtra4MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix El costat 1");
        Double c1 = s.nextDouble();
        System.out.println("Introdueix El costat 2");
        Double c2 = s.nextDouble();
        System.out.println("Introdueix El costat 3");
        Double c3 = s.nextDouble();
        if ((c1 + c2) > c3 || (c1 + c3) > c2 || (c2 + c3) > c1 ) {
            System.out.println("Es pot formar un triangle");
        }
        if (c1 == c2 && c2 == c3) {
            System.out.println("Equilater");
        } else if (c1 == c2 || c1 == c3 || c2 == c3) {
            System.out.println("Isosceles");
        } else{
            System.out.println("Escale");
        }
    }
}
