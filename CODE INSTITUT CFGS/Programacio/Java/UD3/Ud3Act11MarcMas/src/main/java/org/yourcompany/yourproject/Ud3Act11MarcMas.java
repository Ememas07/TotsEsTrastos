/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 *
 * Realitza un programa que ens demani un nombre n i que ens digui quants
 * nombres hi ha entre 1 i n que siguin primers. Recorda que un nombre primer ho
 * és si només és divisible per 1 i el mateix nombre ● Per exemple: 5, només és
 * divisible entre 1 i 5; 6 no és primer ja que se pot dividir entre 1, 2, 3 i 6
 */
public class Ud3Act11MarcMas {

    public static void main(String[] args) {
        System.out.println("Calculadora de nombres primers entre 1 i el nombre introduit per consola"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam un scanner
        Integer input = s.nextInt(); //agafam el nombre per consola
        boolean esPrimer = false; //iniciam la variable de esPrimer, que emprarem mes tard
        Integer resultat = 0;
        System.out.print("Els nombres primers desde l'1 fins al " + input + " son:"); //posam un output sense bot de linea
        for (int i = 2; i < input; i++) { //bucle incial, anira desde 2 (1 no es primer) fins a input 
            esPrimer = true; //posam que esPrimer es veritat per ara, i despres, si no es primer ho marcarem
            Integer n = 2; //començam a comprovar desde 2
            while (n < i && esPrimer == true) { //segon bucle, comença a 2 ja que no volem dividir per 1 cada vegada
                if (i % n == 0) { //si es divisible entre qualsevol nombre desde 2 fins a i (que anira pujant), el marcam com a no primer
                    esPrimer = false;
                }
                n++;
            }
            if (esPrimer == true) { //en cas de que no hagui caigut mai al bucle anterior, imprimim el nombre i una coma
                System.out.print(i + ", ");
                resultat++;
            }
        }
        System.out.println(""); //bot de linea
        System.out.println("Hi ha " + resultat + " nombres primers desde l'1 al " + input);
    }
}
