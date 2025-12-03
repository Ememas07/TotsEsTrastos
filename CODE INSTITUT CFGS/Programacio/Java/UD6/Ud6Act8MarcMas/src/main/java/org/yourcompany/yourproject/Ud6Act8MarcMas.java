/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * El xifrat Cèsar correspon a un mètode de xifra que amb un desplaçament
 * numèric, es canvia el valor de les lletres.
 *
 * Per exemple: amb un decalatge de 3, la A se substituiria per la D, la B
 * esdevindria E, i així successivament
 *
 * Demanar a l'usuari quin decalatge vol i quin text vol xifrar per teclat.
 *
 * @author Marc Mas
 */
public class Ud6Act8MarcMas {

    public static final char[] abecedari = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static String xifrador(String frase, int decalatge) {
        char[] caracters = frase.toCharArray();
        String fraseNova = "";
        for (int i = 0; i < caracters.length; i++) {
            if (Character.isAlphabetic(caracters[i])) {
                fraseNova += xifrador(caracters[i], decalatge);
            } else {
                fraseNova += caracters[i];
            }
        }
        return fraseNova;

    }

    public static char xifrador(char lletra, int decalatge) {
        char lletraNova = (char) (lletra + decalatge);
        return lletraNova;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per fer xifratge Cesar");
        System.out.println("Quina frase vol xifrar?");
        String frase = s.nextLine();
        System.out.println("Quin decalatge vol?");
        int decalatge = s.nextInt();
        System.out.println("Aqui te la seva frase xifrada:");
        String fraseXifrada = xifrador(frase, decalatge);
        System.out.println(fraseXifrada);

    }
}
