/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Paraula;

/**
 *
 * @author Marc Mas
 */
public class Paraula {

    final String ALFABET = "abcdefghijklmnopqrstuvwxyz";
    String text;
    int[] frequencia;
    int longitut;

    public Paraula(String text) {
        this.text = text;
        this.longitut = text.length();
        this.frequencia = new int[ALFABET.length()];
    }

    public void netejarParaula() {
        String nouText = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            c = Character.toLowerCase(c); //passam a minuscules
            if (posicioAlfabet(c) > -1) { //si esta al nostre alfabet, retornara un nombre positio, aixi que sumarem frequencia i afegim al text nou
                this.frequencia[posicioAlfabet(c)] += 1;
                nouText += c;
            } //si no, no afegim res (netejant)
        }
        if (nouText.isBlank() || nouText.isEmpty() || nouText == "") {
            text = null;
        } else {
            text = nouText;
        }
    }

    public void escriureParaula() {
        System.out.println(this.text);
    }

    private int posicioAlfabet(char c) {
        for (int i = 0; i < ALFABET.length(); i++) {
            if (c == ALFABET.charAt(i)) {
                return i; //si hi està, retornam una posicio de l'alfabet per afegir a frecuencia
            }
        }
        return -1; //si no, -1
    }

    public void mostrarFrecuencies() {
        for (int i = 0; i < frequencia.length; i++) {
            if (frequencia[i] != 0) { //si la frecuencia no es 0, imprimim la lletra i la frecuencia
                System.out.println("Lletra: " + ALFABET.charAt(i) + " apareix " + frequencia[i] + " vegades ");
            }
        }
    }

    public String getText() {
        return this.text;
    }

}
