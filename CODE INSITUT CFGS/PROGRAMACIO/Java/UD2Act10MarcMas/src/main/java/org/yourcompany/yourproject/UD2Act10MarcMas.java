/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act10MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Quants d'alumnes seran");
        Integer alumnes = s.nextInt();
        Integer costtotal = 0;
        Integer costalumne = 0;
        if (alumnes >= 30) {
            costalumne = 95;
            if (alumnes >= 50) {
                costalumne = 70;
                if (alumnes >= 100) {
                    costalumne = 65;
                }
            }
            costtotal = costalumne * alumnes;
        } else {
            costtotal = 4000;
            costalumne = (4000 / alumnes);
        }
        System.out.println("El cost total es de "+costtotal+" i aixo equival a "+costalumne+" per alumne");
    }
}
