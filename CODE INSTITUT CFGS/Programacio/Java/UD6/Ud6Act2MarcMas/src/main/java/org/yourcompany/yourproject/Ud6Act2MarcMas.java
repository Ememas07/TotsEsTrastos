/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Dissenyar el joc “Encerta la contrassenya”.
 *
 * La mecànica del joc és la següent:
 *
 * El primer jugador introdueix la contrasenya
 *
 * El segon jugador ha d'introduir paraules fins que l'encerta.
 *
 * Per ajudar el segon jugador, el programa mostrarà les lletres coincidents i
 * amb asteriscs les que no ho siguin.
 *
 * Per exemple: si la paraula clau és “LABERINT” i el segon usuari escriu
 * “TAPERES”, el programa ha de mostrar: “*A*ER***”
 *
 * @author Marc Mas
 */
public class Ud6Act2MarcMas {

    public static void cls() {
        for (int i = 0; i < 100; i++) {
            System.out.println(""); //imprimirem 100 bots de linea
        }
    }

    public static boolean comprovarContrassenya(String input, String contrassenya) {
        if (input.length() != contrassenya.length()) {
            System.out.println("La contrassenya te " + contrassenya.length() + " caracters, per favor, introdueixi paraules amb aquesta longitut");
            return false;
        }
        int encerts = 0; //emprarem encerts per saber si ha encertat totes les posicions o no
        for (int i = 0; i < contrassenya.length(); i++) { //recorrem tots els caracters de l'string mes curt
            if (contrassenya.charAt(i) == input.charAt(i)) { //si el caracter es igual, l'imprimim i afegim un encert 
                System.out.print(contrassenya.charAt(i));
                encerts++;
            } else { //si no, imprimim un asterisc
                System.out.print("*");
            }
        }
        System.out.println(""); //bot de linea
        if (encerts == contrassenya.length()) {
            return true; //si tenim el mateix nombre d'encerts que la llargaria de la contrassenya, sortim amb true
        }
        System.out.println("Torna-ho a provar!"); // si no hem sortit, imprimim missatge d'anim i retornam false
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Joc d'encertar la contrassenya");
        Scanner s = new Scanner(System.in);
        System.out.println("Jugador 1: Introdueixi la contrassenya:");
        String contrassenya = s.next(); //recollim contrassenya
        cls(); //buidam la pantalla per no tenir la contrassenya mostrada mentres jugam
        System.out.println("Jugador 2: Introdueixi el seu intent");
        String input = s.next(); //agafam el primer intent
        while (!comprovarContrassenya(input, contrassenya)) { //mentres la contrassenya no es correcta, demanam inputs
            input = s.next();
        }
        System.out.println("Has guanyat!"); //mostram missatge de victoria
    }
}
