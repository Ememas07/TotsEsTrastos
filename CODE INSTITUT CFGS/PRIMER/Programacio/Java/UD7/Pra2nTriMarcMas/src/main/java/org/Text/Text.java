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

import org.Anagrama.Anagrama;
import org.Paraula.Paraula;

/**
 *
 * @author Marc Mas
 */
public class Text {

    Scanner arxiu;
    Paraula[] paraules;
    Anagrama[] anagrames;
    Anagrama[] anagramesUnics;

    public Text(String ruta) {
        try {
            this.arxiu = new Scanner(new BufferedReader(new FileReader(ruta))); //cream un FileReader, BufferedReader i Scanner, per llegir l'arxiu de tex
        } catch (FileNotFoundException ex) {
            System.out.println("L'arxiu no s'ha trobat!");
        }
        this.paraules = new Paraula[0]; //cream un array de paraules buit
        this.paraules = separarParaules(); //i l'omplim
        this.anagrames = new Anagrama[0]; //cream els dos arrays de anagrames (unics i tots)
        this.anagramesUnics = new Anagrama[0];
        this.setOcurrencies(); //funcions per inicialitzar les ocurrencies de les paraules i crear els anagrames
        this.crearAnagrames();

    }

    public Paraula[] separarParaules() {
        while (arxiu.hasNext()) { //mentres hi hagui més paraules
            Paraula p = new Paraula(arxiu.next()); //cream una paraula nova amb el contingut de l'arxiu
            p.netejarParaula(); //la netejam
            if (p.getText() != null) { //si queda text a la paraula, la afegim a l'array
                paraules = Arrays.copyOf(paraules, paraules.length + 1);
                paraules[paraules.length - 1] = p;
            }
        }
        return paraules;
    }

    public void mostrarParaules() {
        for (Paraula paraula : paraules) { //feim escriureParaula a totes les paraules
            paraula.escriureParaula();
        }
    }

    public void mostrarParaulesUniques() {
        Paraula[] emprades = new Paraula[0]; //feim un array amb les paraules que hem emprat
        for (Paraula paraula : paraules) { //totes les paraules
            boolean jaEmprada = false;
            for (Paraula emprada : emprades) { //recorrem l'array de paraules emprades
                if (paraula.getText().equals(emprada.getText())) { //si el text es igual, marcam com a emprada
                    jaEmprada = true;
                }
            }
            if (!jaEmprada) { //si no esta emprada, l'afegim a l'array de paraules emprades i la escrivim
                emprades = Arrays.copyOf(emprades, emprades.length + 1);
                emprades[emprades.length - 1] = paraula;
                paraula.escriureParaula();
            }
        }
    }

    public void setOcurrencies() {
        for (Paraula paraula : paraules) { //recorrem totes les paraules
            if (paraula.getOcurrencies() == 0) { //si la paraula esta a 0 ocurrencies (es la primera vegada que surt aixi que no l'hem calculat)
                int ocurrencies = 0;
                for (int i = 0; i < paraules.length - 1; i++) { //recorrem l'array de paraules
                    if (paraula.getText().equals(paraules[i].getText())) { //i miram quantes vegades tenim el mateix text a tot el text
                        ocurrencies++;
                    }
                }
                paraula.setOcurrencies(ocurrencies);
            }
        }
    }

    public void mostraOcurrencies(Paraula p) {
        System.out.println("La paraula " + p.getText() + " apareix: " + p.getOcurrencies() + " vegades");
    }

    public void mostraOcurrencies(String text) {
        mostraOcurrencies(new Paraula(text));
    }

    public void mostrarPalindroms() {
        for (Paraula paraula : paraules) { //miram totes les paraules
            if (paraula.esPalindrom()) { //si es palindroma, l'imprimim
                System.out.println(paraula.getText());
            }
        }
    }

    public void mostrarParaulaMesLlarga() {
        Paraula mesLlarga = new Paraula("");
        for (Paraula paraula : paraules) { //miram totes les paraules
            if (mesLlarga.getLongitut() < paraula.getLongitut()) { //si la paraules es mes llarga que la paraula actual, marcam la paraula mes llarga com a l'actual
                mesLlarga = paraula;
            }
        }
        System.out.println("La paraula més llarga es " + mesLlarga.getText() + " amb una longitut de " + mesLlarga.getLongitut());
    }

    public void netejarParaules() {
        for (Paraula paraula : paraules) {
            paraula.netejarParaula();
        }
    }

    public void crearAnagrames() {
        for (Paraula paraula : paraules) { //cream tots els anagrames posibles
            //he de mirar totes les paraules
            if (paraula.teFrecuencies()) { //comprovar: la paraula no esta buida
                //cream anagrama temporal
                Anagrama temp = new Anagrama(paraula);
                //mir que la combinacio de lletres actual no estigui ja posada a qualsevol anagrama de l'array
                boolean paraulaPresent = false;
                boolean lletresDinsArray = false;
                for (Anagrama a : anagrames) {
                    if (a.getLletres().equals(temp.getLletres())) { //si les lletres ja estan aficades a l'array de anagrames
                        lletresDinsArray = true; // marcam com a que les lletres estan aficades a l'array per només aficar anagrames quan no hi estigui
                        for (int i = 0; i < a.getParaules().length; i++) { //mir que la paraula no estigui ja dins l'array de paraules de l'anagrama
                            if (a.getParaules()[i].equals(temp.getParaula())) {
                                paraulaPresent = true; //si esta present, marcam i no farem res amb ella
                            }
                        }
                        if (!paraulaPresent) { // si no esta present
                            a.addParaules(paraula); //aficam la paraula a l'array de paraules de l'anagrama de dins el nostre array 
                        }
                    }
                    // DE AQUI FINS ABAIX = CREAM ARRAY DE ANAGRAMES SENSE DUPLICAR
                    if (anagramesUnics.length == 0) { // Si l'array d'anagrames unics esta buit, aficam el primer
                        anagramesUnics = Arrays.copyOf(anagramesUnics, anagramesUnics.length + 1);
                        anagramesUnics[anagramesUnics.length - 1] = a;
                    }
                    boolean jaPresent = false;
                    for (Anagrama anagramaUnic : anagramesUnics) {
                        //per cada anagramaUnic existent, comprovam la paraula i miram les lletres
                        // si son iguals, ja hi ha un anagrama present amb aquestes lletres i no farem res
                        if (anagramaUnic.getLletres().equals(a.getLletres())) {
                            jaPresent = true;
                        }
                    }
                    if (!jaPresent && a.getParaules().length > 1) { //si no esta present i la combinacio de lletres està a més d'una paraula, l'afegim a AnagramesUnics
                        anagramesUnics = Arrays.copyOf(anagramesUnics, anagramesUnics.length + 1);
                        anagramesUnics[anagramesUnics.length - 1] = a;
                    }
                    // Fins aqui creació anagrames sense duplicar
                }
                if (!lletresDinsArray) {
                    // les lletres no estan aficades a l'array de anagrames
                    // aixi que es un anagrama nou, i el aficarem al nostre array
                    anagrames = Arrays.copyOf(anagrames, anagrames.length + 1);
                    anagrames[anagrames.length - 1] = new Anagrama(paraula);
                }
            }
        }
    }

    public void teAnagrames(Paraula p) {
        Anagrama temp = new Anagrama(p); //cream anagrama temporal
        for (Anagrama anagrama : anagrames) {
            //miram tots els anagrames
            if (temp.getLletres().equals(anagrama.getLletres())) {
                //si les lletres del temporal son iguales a les lletres d'un anagram del nostre array, retornam totes les paraules
                if (anagrama.getParaules().length == 1) {
                    System.out.println("La paraula no té anagrames");
                } else {
                    System.out.println("La paraula és anagrama de: ");
                    anagrama.mostrarParaulesDiferents(p);
                }
            }
        }
    }

    public void pintarParellesAnagrames() {
        for (Anagrama anagramaUnic : anagramesUnics) {
            anagramaUnic.mostrarParaules();
        }
    }

    public void mostrarParaulesLlargues(int longitut) {
        for (Paraula p : paraules) {
            if (p.getLongitut() > longitut) {
                p.escriureParaula();
            }
        }
    }

    public Paraula getParaula(int i) {
        if (i > paraules.length) {
            System.out.println("Aquesta paraula no existeix!");
            return new Paraula("");
        } else {
            return paraules[i];
        }
    }

}
