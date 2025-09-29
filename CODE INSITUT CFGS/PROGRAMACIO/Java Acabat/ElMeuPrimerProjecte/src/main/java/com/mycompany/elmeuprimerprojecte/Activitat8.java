/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.elmeuprimerprojecte;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Activitat8 {

    public static void main(String[] args) {
        // Activitat 8

        System.out.println("Indica un numero");
        Scanner s = new Scanner(System.in);
        Integer numero = s.nextInt();
        boolean esParell;
        boolean esSenar;
        esParell = numero % 2 == 0;
        esSenar = !esParell;
        System.out.println("Es Parell? "+esParell);
        System.out.println("Es Senar? "+esSenar);
        
        // Manera sense MODULO
        // Integer test1 = numero - ((numero/2) * 2);
        // boolean esParell = test1 == 0;
        // System.out.println(esParell);


        // if (numero % 2 == 1) {
        //     System.out.println("Senar");            
        // } else{
        //     System.out.println("Parell");           
        // }
    }
}
