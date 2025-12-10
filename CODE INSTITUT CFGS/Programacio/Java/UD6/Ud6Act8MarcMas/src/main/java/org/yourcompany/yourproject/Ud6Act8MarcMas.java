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

    public static String xifrador(String frase, int decalatge) {
        char[] caracters = frase.toCharArray();
        String fraseNova = ""; //cream una frase buida
        for (int i = 0; i < caracters.length; i++) { //recorrem la frase com a un array
            if (Character.isAlphabetic(caracters[i])) { //si el caracter es part de l'alfabet, el xifram, si no, l'afegim a la frase talment
                fraseNova += xifrador(caracters[i], decalatge);
            } else {
                fraseNova += caracters[i];
            }
        }
        return fraseNova;

    }

    public static char xifrador(char lletra, int decalatge) {
        char lletraNova = (char) (lletra + decalatge); //sumam el decalatge
        if (lletraNova > 26) { //si ens sortim de l'abecedari, restam 26 per tornar a començar-lo
            lletraNova = (char) (lletraNova - 26);
        }
        return lletraNova;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per fer xifratge Cesar");
        System.out.println("Quina frase vol xifrar?");
        String frase = s.nextLine(); //demananam la frase
        System.out.println("Quin decalatge vol?");
        int decalatge = s.nextInt(); //i el decalatge
        System.out.println("Aqui te la seva frase xifrada:");
        String fraseXifrada = xifrador(frase, decalatge); //i xifram
        System.out.println(fraseXifrada);

    }
}
