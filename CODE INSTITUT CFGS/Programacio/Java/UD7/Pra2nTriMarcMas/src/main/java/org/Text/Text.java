/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import org.Paraula.Paraula;

/**
 *
 * @author Marc Mas
 */
public class Text {

    Scanner arxiu;
    Paraula[] paraules;

    public Text(String ruta) {
        try {
            this.arxiu = new Scanner(new BufferedReader(new FileReader(ruta))); //cream un FileReader, BufferedReader i Scanner, per llegir l'arxiu de tex
        } catch (FileNotFoundException ex) {
            System.out.println("L'arxiu no s'ha trobat!");
        }
        this.paraules = new Paraula[0];
        this.paraules = separarParaules();
    }

    public Paraula[] separarParaules() {
        while (arxiu.hasNext()) {
            paraules = Arrays.copyOf(paraules, paraules.length + 1);
            paraules[paraules.length - 1] = new Paraula(arxiu.next());
        }
        return paraules;
    }

    public void mostrarParaules() {
        for (Paraula paraula : paraules) {
            paraula.escriureParaula();
        }
    }

}
