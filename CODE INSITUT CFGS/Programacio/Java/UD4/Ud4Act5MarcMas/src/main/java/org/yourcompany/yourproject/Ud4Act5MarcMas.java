/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * Escriure una funció booleana, de nom esPrimer, a la qual se li passa un
 * nombre enter i la funció retorna si és un nombre primer o no.
 *
 * Un nombre és primer si només es pot dividir entre 1 i ell mateix ○ 7 és
 * primer, només es pot dividir de forma entera entre 1 i 7 ○ 6 no és primer, es
 * pot dividir entre 1, 2, 3 i 6
 *
 * @author Marc Mas
 */
public class Ud4Act5MarcMas {

    private static boolean esPrimer(int n) {
        for (int i = 2; i < n; i++) { //començam dividint entre dos i anirem sumant
            if (n % i == 0) { //dividim N entre I, que començara a 2, si la divisio dona 0 com a residu, o sigui, el nombre SI es divisible, retornam false
                return false;
            }
        }
        return true; //si el bucle anterior no bota mai, no es divisible entre cap nombre aixi que es primer
    }

    public static void main(String[] args) {
        System.out.println("Comprovador de nombres primers"); //informacio a l'usuari
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Quin nombre vol comprovar?"); // demanam el nombre
        Integer n = s.nextInt(); //assignam
        System.out.println("El nombre '"+n+"' es primer? "+esPrimer(n));
    }

}
