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
            Paraula p = new Paraula(arxiu.next());
            p.netejarParaula();
            if (p.getText() != null) {
                paraules = Arrays.copyOf(paraules, paraules.length + 1);
                paraules[paraules.length - 1] = p;
            }
        }
        return paraules;
    }

    public void mostrarParaules() {
        for (Paraula paraula : paraules) {
            paraula.escriureParaula();
        }
    }

    public void mostrarParaulesUniques() {
        Paraula[] emprades = new Paraula[0];
        for (Paraula paraula : paraules) {
            boolean jaEmprada = false;
            for (Paraula emprada : emprades) {
                if (paraula.getText().equals(emprada.getText())) {
                    jaEmprada = true;
                }
            }
            if (!jaEmprada) {
                emprades = Arrays.copyOf(emprades, emprades.length + 1);
                emprades[emprades.length - 1] = paraula;
                paraula.escriureParaula();
            }
        }
        for (Paraula emprada : emprades) {
        }
    }

    public void netejarParaules() {
        for (Paraula paraula : paraules) {
            paraula.netejarParaula();
        }
    }

    public Paraula getParaula(int i) {
        if (i > paraules.length) {
            System.out.println("Aquesta paraula no existeix!");
            return new Paraula("-1");
        } else {
            return paraules[i];
        }
    }

}
