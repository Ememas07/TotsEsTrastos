/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Ud3Act7MarcMas {

    public static void main(String[] args) {
        System.out.println("Maquina d'escriure la suma dels 10 primers nombres senars");
        Integer suma = 0; //inicalitz variable
        for (int i = 0; i < 10; i++) { //desde 0 a 10 ja que son els 10 primers
            suma += 1 + i * 2; //la suma es igual a la suma, mes 1*el nombre que sigui, es a dir:
            // primer sumam 1+0, despres 1+2, despres 1+4, i aixi tendrem la suma de 1,3,5,7...
        }
        System.out.println("la suma es " + suma); //imprimim la suma final per pantalla
    }
}
