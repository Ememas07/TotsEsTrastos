/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbres;

/**
 *
 * @author Devil Hongo
 */
// ------------------------------------------------------------
// IMPORT
//
// Tot i que emprarem l'enum Branca, no es necessari fer l'import
// perque son dins el mateix paquet:
// import com.mycompany.arbres.Branca;
// ------------------------------------------------------------
public class Node {

    // ------------------------------------------------------------
    // ATRIBUTS DEL NODE
    // ------------------------------------------------------------
    //TO DO
    // ------------------------------------------------------------
    // CONSTRUCTOR
    //
    // Crea un node amb el valor indicat. Les branques i el pare
    // s'inicialitzen a null, ja que el node encara no està connectat.
    // ------------------------------------------------------------
    public Node(String valor) {
        //TO DO
    }

    // ------------------------------------------------------------
    // GETTERS I SETTERS BÀSICS
    //
    // Aquests mètodes gestionen informació pròpia del node,
    // independentment de la seva posició dins l'arbre.
    // ------------------------------------------------------------
    public String getValor() {
        //TO DO
        return "";
    }

    public void setValor(String nouValor) {
        //TO DO
    }

    public Node getPare() {
        //TO DO
        return new Node("");
    }

    // ------------------------------------------------------------
    // GETTERS I SETTERS ESPECÍFICS DE BRANQUES
    //
    // Aquests mètodes són interfícies convenients que deleguen
    // tota la lògica real als mètodes unificats. Són útils per
    // llegibilitat i mantenen la interfície clàssica d'un arbre binari.
    // ------------------------------------------------------------
    public Node getEsquerra() {
        return getBranca(Branca.ESQUERRA);
    }

    public Node getDreta() {
        return getBranca(Branca.DRETA);
    }

    public void setEsquerra(Node fill) {
        setBranca(fill, Branca.ESQUERRA);
    }

    public void setDreta(Node fill) {
        setBranca(fill, Branca.DRETA);
    }

    // ------------------------------------------------------------
    // MÈTODES UNIFICATS PER ACCEDIR A LES BRANQUES
    //
    // Aquests són els mètodes "centrals". Tota la lògica real
    // d'accedir o modificar una branca passa per aquí.
    //
    // Això ens permet tenir un únic punt de manteniment:
    // si algun dia volem afegir validacions, comprovacions,
    // o canviar la implementació interna, només cal tocar aquí.
    // ------------------------------------------------------------
    public Node getBranca(Branca branca) {
        //TO DO
        return new Node("");
    }

    public void setBranca(Node fill, Branca branca) {
        // Assignació de la branca corresponent
        //TO DO

        // Si hi ha fill, actualitzam el seu pare
        //TO DO
    }

    // ------------------------------------------------------------
    // FUNCIONS LÒGIQUES
    //
    // Mètodes que descriuen propietats del node dins l'arbre.
    // Són mètodes semàntics que milloren la llegibilitat i
    // eviten repetir condicions disperses pel codi.
    // ------------------------------------------------------------
    public boolean esArrel() {
        //TO DO

        return false;
    }

    public boolean esFulla() {
        //TO DO
        return false;
    }
}
