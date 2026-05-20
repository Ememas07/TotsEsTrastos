/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;
import java.util.Set;

/**
 * Implementar la classe Sorteig amb paràmetres genèrics. Haurà de guardar un
 * conjunt de valors distints de tipus genèric, subministrats per consola i serà
 * capaç de generar una combinació premiada d'un tamany determinat.
 *
 * S'hauran d'implementar, com a mínim, els mètodes:
 *
 * boolean add(T element): afegeix un element nou al conjunt de valors possibles
 * a l'aposta. Si l'element s'afegeix retorna true, si ja hi era, retorna false.
 *
 * Set<T> premiats(int numPremiats): retorna una combinació guanyadora de
 * numPremiats elements distints
 *
 * @author Marc Mas
 */
public class Ud11Act12MarcMas {

    public static void main(String[] args) {
        Sorteig<Integer> sorteig = new Sorteig();
        Scanner s = new Scanner(System.in);
        System.out.println("Benvingut al meu sorteig!");
        int num = 1;
        System.out.println("Introdueix un nombre per afegir al sorteig, o un nombre negatiu per atura");
        while (num > 0) {
            num = s.nextInt();
            if (num > 0) {
                sorteig.add(num);
            }
        }
        System.out.println("Quants de nombres guanyadors vol generar?");
        num = s.nextInt();
        Set<Integer> premiats = sorteig.premiats(num+1); //la funció genera un nombre menys del que demanes, així que sumam 1 per generar el nombre correcte
        System.out.println(premiats.toString());
    }
}
