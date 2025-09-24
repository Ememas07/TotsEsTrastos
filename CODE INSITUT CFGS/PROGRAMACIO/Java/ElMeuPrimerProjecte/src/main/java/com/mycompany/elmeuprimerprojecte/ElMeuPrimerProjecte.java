/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elmeuprimerprojecte;
import java.util.Scanner;
/**
 *
 * @author Marc Mas
 */
public class ElMeuPrimerProjecte {

    public static void main(String[] args) {
        System.out.println("Quants d'anys tens?");
        Scanner s = new Scanner(System.in);
        Integer Edat = s.nextInt()+1;
        System.out.println("l'any que ve tendras "+Edat+" Anys");
    }
}
