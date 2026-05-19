/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Marc Mas
 */
public class Sorteig<T> {

    Set<T> valors;

    public Sorteig() {
        this.valors = new HashSet();
    }

    public Sorteig(Set<T> valors) {
        this.valors = valors;
    }

    boolean add(T element) {
        return valors.add(element);
    }

    Set<T> premiats(int numPremiats) {
        if (numPremiats > valors.size()) {
            System.out.println("No tens valors suficients per donar tants de guanyadors!");
            return null;
        }
        Set<T> premiats = new HashSet();
        for (int i = 0; i < numPremiats + 1; i++) {
            Iterator it = valors.iterator(); //cream un iterator per cada numero
            int indexGuanyador = (int) (Math.random() * valors.size()); //gener un nombre de 0 a size
            T elementGuanyador = null;
            for (int j = 0; j < indexGuanyador; j++) { //vaig de 0 fins al nombre generat
                elementGuanyador = (T) it.next(); //agaf l'element de llista
            }
            premiats.add(elementGuanyador); //l'afegesc al set de guanyadors
        }

        return premiats;
    }

}
