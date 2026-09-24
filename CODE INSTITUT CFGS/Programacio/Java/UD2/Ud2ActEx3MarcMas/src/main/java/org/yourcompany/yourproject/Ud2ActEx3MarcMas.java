/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud2ActEx3MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix El costat 1");
        Float c1 = s.nextFloat(); //agafam els 3 costats per consola
        System.out.println("Introdueix El costat 2");
        Float c2 = s.nextFloat();
        System.out.println("Introdueix El costat 3");
        Float c3 = s.nextFloat();
        if ((c1 + c2) > c3 || (c1 + c3) > c2 || (c2 + c3) > c1) { //primer comprovam si se pot formar un triangle o no
            System.out.println("Es pot formar un triangle");
        }
        if (c1 == c2 && c2 == c3) { //despres comprovam quin triangle se pot fer, si te tres costats iguals, equilater
            System.out.println("Equilater"); //retornam per consola
        } else if (c1 == c2 || c1 == c3 || c2 == c3) { //si nomes te dos costats iguals, isosceles
            System.out.println("Isosceles");
        } else {
            System.out.println("Escale"); //si no es ni equilater ni isosceles, es escale
        } 
        
    }
}
