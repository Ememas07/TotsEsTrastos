/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.text;

import java.util.Date;

/**
 *
 * @author Marc Mas
 */
public class Text {

    int longitut;
    String text;
    public String dataCreacio;
    public String dataModificacio;

    public Text(int longitut, String caracters) {
        this.longitut = longitut;
        this.text = caracters;
        this.dataCreacio = dataActual();
        this.dataModificacio = dataActual();
    }

    public Text(int longitut) {
        this(longitut, "");
    }

    public void afegirPrincipi(String cadena) {
        if (cadena.length() + text.length() > longitut) {
            System.out.println("La cadena total seria massa llarga!");
        } else {
            this.text = cadena + this.text;
            this.dataModificacio = dataActual();
        }
    }

    public void afegirPrincipi(char caracter) {
        String c = "" + caracter;
        afegirPrincipi(c);
    }

    public void afegirFinal(String cadena) {
        if (cadena.length() + text.length() > longitut) {
            System.out.println("La cadena total seria massa llarga!");
        } else {
            this.text += cadena;
            this.dataModificacio = dataActual();
        }
    }

    public void afegirFinal(char caracter) {
        String c = "" + caracter;
        afegirFinal(c);
    }

    public void mostrarText() {
        System.out.println("Text actual:");
        System.out.println(this.text);
    }

    int contarVocals() {
        int vocals = 0;
        for (int i = 0; i < text.length(); i++) {
            String c = "" + text.charAt(i); //recorrem tot el text, i agafam cada caracter 1 per 1
            switch (c.toLowerCase()) { // si entram dins el switch, sumam un accent
                case "a", "e", "i", "o", "u" ->
                    vocals++;
            }
        }
        return vocals;
    }

    int contarMajuscules() {
        int majus = 0;
        for (int i = 0; i < text.length(); i++) {
            String c = "" + text.charAt(i); //agafam els caracters com a string per poder emprar .toUpperCase()
            if (!(c.toLowerCase()).equals(c)) { //si passam el caracter a minuscula i es diferent, es una lletra majuscula (evitam que els caracters buits contin)
                majus++;
            }
        }
        return majus;
    }

    int contarMinuscules() {
        int minus = 0;
        for (int i = 0; i < text.length(); i++) {
            String c = "" + text.charAt(i); //agafam els caracters com a string per poder emprar .toLowerCase()
            if (!(c.toUpperCase()).equals(c)) { //si passam el caracter a majuscula i es diferent, es una lletra minuscula (evitam que els caracters buits contin)
                minus++;
            }
        }
        return minus;
    }

    int contarAccents() {
        int accents = 0;
        for (int i = 0; i < text.length(); i++) {
            String c = "" + text.charAt(i); //recorrem tot el text, i agafam cada caracter 1 per 1
            switch (c.toLowerCase()) { // si entram dins el switch, sumam un accent
                case "à", "á", "è", "é", "í", "ì", "ó", "ò", "ú", "ù" ->
                    accents++;
            }
        }
        return accents;
    }

    public void mostrarInformacio() {
        mostrarText();
        System.out.println("Data de creacio: " + this.dataCreacio);
        System.out.println("Data de modificacio: " + this.dataModificacio);
        System.out.println("Nombre de vocals: " + (this.contarVocals() + this.contarAccents()));
        System.out.println("Nombre de accents: " + this.contarAccents());
        System.out.println("Nombre de majuscules: " + this.contarMajuscules());
        System.out.println("Nombre de minuscules: " + this.contarMinuscules());
    }

    String dataActual() {
        Date data = new Date();
        String text = "";
        if (data.getDate() < 9) {
            text += "0";
        }
        text += data.getDate() + "-";

        if (data.getMonth() < 9) {
            text += "0";
        }
        text += (data.getMonth() + 1) + "-"; //ens mostra desde 0 a 11

        text += (data.getYear() + 1900) + " "; //ens mostra l"any desde l"any 1900, jo vull l"any complet

        if (data.getHours() < 9) {
            text += "0";
        }
        text += data.getHours() + ":";
        if (data.getMinutes() < 9) {
            text += "0";
        }
        text += data.getMinutes() + ":";
        if (data.getSeconds() < 9) {
            text += "0";
        }
        text += data.getSeconds();
        return text;
    }

    public String getDataCreacio() {
        return dataCreacio;
    }

    public String getDataModificacio() {
        return dataModificacio;
    }

}
