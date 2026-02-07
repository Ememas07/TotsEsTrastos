/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import org.Paraula.Paraula;
import org.Text.Text;

/**
 *
 * @author Marc Mas
 */
public class Pra2nTriMarcMas {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner s = new Scanner(System.in);
        System.setOut(new PrintStream(System.out, true, "UTF-8")); //Per mostra accents
        System.out.println("Benvingut a la meva pràctica del segon trimestre!");
        Text textBrut = new Text("text.txt");
        textBrut.separarParaules();
        textBrut.mostrarParaules();
        textBrut.mostrarParaulesUniques();
        System.out.println("Palindroms:");
        textBrut.mostrarPalindroms();
        textBrut.setOcurrencies();
        textBrut.mostrarParaulaMesLlarga();
        textBrut.crearAnagrames();

        int sortir = 0;
        while (sortir != -1) {
            sortir = s.nextInt();
            if (sortir > -1) {
                Paraula p = textBrut.getParaula(sortir);
                if (!p.getText().equals("")) {
                    p.estadistiques();
                    textBrut.sonAnagrames(p, p);
                }
            }
        }
    }
}
