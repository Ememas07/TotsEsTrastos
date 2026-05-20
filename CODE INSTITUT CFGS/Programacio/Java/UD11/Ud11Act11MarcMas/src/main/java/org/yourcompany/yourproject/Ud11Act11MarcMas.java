/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementar un mètode estàtic que porti a terme la unió de dos conjunts
 * d'elements genèrics.
 *
 * L'unió és un nou conjunt amb tots els elements que pertanyen, almenys a un
 * dels dos conjunts.
 *
 * Fer el mateix amb la intersecció, formada pels elements comuns als dos
 * conjunts
 *
 * Els prototipus dels mètodes són:
 *
 * static <E> Set<E> unio(Set<E> conj1, Set<E> conj2)
 *
 * static <E> Set<E> inters(Set<E> conj1, Set<E> conj2)
 *
 * @author Marc Mas
 */
public class Ud11Act11MarcMas {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList(); //cream dues ArrayList 
        ArrayList<Integer> l2 = new ArrayList();
        for (int i = 0; i < 9; i++) { //les omplim amb 10 nombre de 1 a 20
            int n = 1 + (int) (Math.random() * 19);
            l.add(n);
            n = 1 + (int) (Math.random() * 19);
            l2.add(n);
        }
        HashSet h1 = new HashSet(l); //cream dos conjunts, un amb cada llista
        HashSet h2 = new HashSet(l2);
        System.out.println("Llista 1:"+h1.toString()); //imprimim les llistes abans
        System.out.println("Llista 2:"+h2.toString());
        Set h3 = unio(h1, h2); //cream un nou set i li assignam el valor de la unio
        System.out.println("Unio:"+h3.toString());
        Set h4 = inters(h1, h2); //cream un nou set i li assignam el valor de la interseccio
        System.out.println("Interseccio:"+h4.toString());

    }

    public static <E> Set<E> unio(Set<E> conj1, Set<E> conj2) {
        Set<E> unio = new HashSet(conj1); //feim una copia del conjunt 1
        unio.addAll(conj2); //per unir, afegim tots els valors del conjunt 2 al conjunt 1
        return unio; //retornam el conjunt amb els valors afegits
    }

    public static <E> Set<E> inters(Set<E> conj1, Set<E> conj2) {
        Set<E> interseccio = new HashSet();
        //cream dos sets buits
        Set<E> setGran;
        Set<E> setPetit;
        if (conj1.size() > conj2.size()) { //he de agafar el set més gran dels dos per iterar, i l'altre per veure si l'he d'afegir o no
            setGran = conj1;
            setPetit = conj2;
        } else {
            setGran = conj2;        
            setPetit = conj1;
        }
        for (E element : setGran) { //per cada element del set gran, mir si està al petit, i si ho està, el pos al set interseccio
            if (setPetit.contains(element)) {
                interseccio.add(element);
            }
        }
        return interseccio;
    }
}
