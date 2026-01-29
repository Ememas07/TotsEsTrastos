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
            if (posicioAlfabet(c) > 0) { //si esta al nostre alfabet, retornara un nombre positio, aixi que sumarem frequencia i afegim al text nou
                this.frequencia[posicioAlfabet(c)] += 1;
                nouText += c;
            } //si no, no afegim res (netejant)
        }
        text = nouText;
    }

    public void escriureParaula() {
        System.out.println(text);
    }

    private int posicioAlfabet(char c) {
        for (int i = 0; i < ALFABET.length(); i++) {
            if (c == ALFABET.charAt(i)) {
                return i; //si hi està, retornam una posicio de l'alfabet per afegir a frecuencia
            }
        }
        return -1; //si no, -1
    }
}
