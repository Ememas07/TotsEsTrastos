/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.Text.Text;

/**
 *
 * @author Marc Mas
 */
public class Pra2nTriMarcMas {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, "UTF-8")); //Per mostra accents
        System.out.println("Benvingut a la meva pràctica del segon trimestre!");
        Text textBrut = new Text("text.txt");
        textBrut.separarParaules();
        textBrut.netejarParaules();
        textBrut.mostrarParaules();
    }
}
