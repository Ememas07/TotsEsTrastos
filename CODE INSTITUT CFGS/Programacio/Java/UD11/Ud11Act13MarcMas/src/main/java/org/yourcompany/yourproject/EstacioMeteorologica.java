/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Marc Mas
 */
public class EstacioMeteorologica {

    Set<Registre> registres;

    public EstacioMeteorologica() {
        this.registres = new HashSet();
    }

    public void nouRegistre(Scanner s) {
        Registre r = Registre.crearRegistre(s);
        registres.add(r);
    }

    public void llistarRegistres() {
        System.out.println(registres.toString());
    }

    public void estadistiques() {
        Iterator it = registres.iterator();
        float max = -1000f;
        float min = 1000f; //valors exagerat per setejarlo sempre i que no quedi amb el per defecte
        float sum = 0f;
        while (it.hasNext()) {
            Registre r = (Registre) it.next();
            float temp = r.getTemp();
            if (temp > max) {
                max = temp;
            }
            if (temp < min) {
                min = temp;
            }
            sum += temp;
        }
        float avg = sum / registres.size();
        System.out.println("Temperatura màxima d'avui: " + max);
        System.out.println("Temperatura mínima d'avui: " + min);
        System.out.println("Temperatura mitjana d'avui: " + avg);
    }
}
