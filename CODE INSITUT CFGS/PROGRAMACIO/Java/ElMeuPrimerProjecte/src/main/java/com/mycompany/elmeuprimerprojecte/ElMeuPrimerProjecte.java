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
        // Activitat 1
        // System.out.println("Hola, encantat de coneixer-te");

        // Activitat 2

        // System.out.println("Com et noms?");
        // Scanner s = new Scanner(System.in);
        // String nom = s.next();
        // System.out.println("Hola "+nom);

        // Activitat 3     
       
        // System.out.println("Quants d'anys tens");
        // Scanner s = new Scanner(System.in);
        // Integer edat = s.nextInt()+1;
        // System.out.println("L'any que ve tendras "+edat+" Anys");
        
        // Activitat 4

        // System.out.println("Mitjana aritmètica de dos enters");
        // System.out.println("Numero 1");
        // Scanner s = new Scanner(System.in);
        // Integer nota1 = s.nextInt();
        // System.out.println("Numero 2");
        // Scanner s2 = new Scanner(System.in);
        // Integer nota2 = s2.nextInt();
        // Integer mitjaArit = (nota1 + nota2) / 2;
        // System.out.println("La mitja de les teves notes es "+mitjaArit);

        // Activitat 5

        // System.out.println("Longitud de circumferència i àrea d'un cercle");
        // System.out.println("Radi");
        // Scanner s = new Scanner(System.in);
        // Double radi = s.nextDouble();
        // Double longitud = 2 * Math.PI*radi;
        // Double area = Math.PI*(Math.pow(radi, 2));
        // System.out.println("La longitud es "+longitud);
        // System.out.println("L'area es "+area);

        // Activitat 6

        // System.out.println("Quants d'anys tens");
        // Scanner s = new Scanner(System.in);
        // Integer edat = s.nextInt();
        // if (edat >= 18) {
        //     System.out.println("Ets major d'edat");            
        // } else{
        //     System.out.println("Ets menor d'edat");           
        // }

        // Activitat 7

        // System.out.println("Indica un numero");
        // Scanner s = new Scanner(System.in);
        // Integer numero = s.nextInt();
        // if (numero % 2 == 1) {
        //     System.out.println("Senar");            
        // } else{
        //     System.out.println("Parell");           
        // }

        // Activitat 8

        System.out.println("Plou? (respon amb 'true' or 'false')");
        Scanner s = new Scanner(System.in);
        Boolean plou = s.nextBoolean();
        System.out.println("Has acabat les feines? (respon amb 'true' or 'false')");
        Scanner s2 = new Scanner(System.in);
        Boolean feines = s2.nextBoolean();
        System.out.println("Has d'anar a classe? (respon amb 'true' or 'false')");
        Scanner s3 = new Scanner(System.in);
        Boolean classe = s3.nextBoolean();

        if (plou == false && feines == true && classe == false) {
            System.out.println("Pots sortir de casa");
        } else {
            System.out.println("No pots sortir de casa");
        }


        
        
    }
}
