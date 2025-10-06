/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act8MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix una hora");
        Integer hh = s.nextInt(); //variable hores demanada per consola
        System.out.println("Introdueix un minut");
        Integer mm = s.nextInt(); //variable minuts demanada per consola
        System.out.println("Introdueix un segon");
        Integer ss = s.nextInt() + 1; //variable segons demanada per consola, i sumaré 1 ja que ho demana l'enunciat

        if (ss >= 60) {
            ss = ss % 60;
            //si hi ha més de 60 segons, dividesc per 60 i agafaré el residu,
            // per exemple, si pos un 67, dividire per 60
            // i el residu serà sempre un segon valid (en aquest cas, 7)

            mm = mm + 1; //també afegiré un minut si el valor es més de 60

        }
        if (mm >= 60) {
            mm = mm % 60;
            hh = hh + 1;
            // mateixa llògica que amb els segons, i sumaré una hora
        }
        if (hh >= 24) {
            hh = hh % 24;
            //si hi ha més de 24 hores, dividesc per 24 i agafaré el residu,
            // per exemple, si pos un 32, dividire per 24
            // i el residu serà sempre una hora correcta (en aquest cas, 8)
        }

        System.out.println("Un segon mes tard seran les " + hh + ":" + mm + ":" + ss); //imprimesc l'hora desrprés de verificar que és vàlida
    }
}
