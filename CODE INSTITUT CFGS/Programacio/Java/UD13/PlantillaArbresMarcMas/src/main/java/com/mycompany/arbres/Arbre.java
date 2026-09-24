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
// CLASSE ARBRE
//
// Representa un arbre binari general. Gestiona únicament l'arrel
// i proporciona operacions d'alt nivell per modificar i imprimir
// l'estructura. La lògica interna dels nodes es troba a la classe
// Node, i les branques es defineixen a l'enum Branca.
// ------------------------------------------------------------
public class Arbre {

    private Node arrel;

    // ------------------------------------------------------------
    // ENUM DE RECORREGUTS
    //
    // Defineix els diferents tipus de recorregut que es poden
    // aplicar a l'arbre o a qualsevol subarbre.
    //
    // PREFIXA   → node, esquerra i dreta
    // INFIXA    → esquerra, node i dreta
    // POSTFIXA  → esquerra, dreta i node
    // ARBRE     → impressió estructural amb indentació
    // ------------------------------------------------------------
    public enum Recorregut {
        PREFIXA,
        INFIXA,
        POSTFIXA,
        ARBRE
    }

    // ------------------------------------------------------------
    // ATRIBUT PRINCIPAL
    //
    // L'arrel és l'únic punt d'entrada a l'arbre. Pot ser null
    // si l'arbre està buit.
    // ------------------------------------------------------------
    // CONSTANTS
    //
    // SEPARADOR defineix l'espai entre elements durant la impressió.
    // ------------------------------------------------------------
    private static final String SEPARADOR = " ";

    // ------------------------------------------------------------
    // CONSTRUCTORS
    //
    // Permeten crear un arbre buit o un arbre amb una arrel inicial.
    // ------------------------------------------------------------
    public Arbre() {
        //TO DO
    }

    public Arbre(String valorArrel) {
        //TO DO
    }

    public Arbre(Node arrel) {
        //TO DO
    }

    public Node getArrel() {
        //TO DO
        return new Node("");
    }

    // ------------------------------------------------------------
    // OPERACIONS DE MODIFICACIÓ DE L'ARBRE
    //
    // Aquestes operacions permeten afegir o eliminar branques.
    // Tota la lògica real passa pels mètodes unificats, que
    // centralitzen la gestió i eviten duplicació de codi.
    // ------------------------------------------------------------
    public Node afegirBranca(Node pare, String valor, Branca branca) {
        //TO DO
        return new Node("");
    }

    public void podarBranca(Node pare, Branca branca) {
        //TO DO
    }

    // ------------------------------------------------------------
    // MÈTODES DE CONVENIÈNCIA
    //
    // Versions simplificades que permeten afegir o podar branques
    // sense haver d'especificar explícitament l'enum Branca.
    // ------------------------------------------------------------
    public Node afegirEsquerra(Node pare, String valor) {
        return afegirBranca(pare, valor, Branca.ESQUERRA);
    }

    public Node afegirDreta(Node pare, String valor) {
        return afegirBranca(pare, valor, Branca.DRETA);
    }

    public void podarEsquerra(Node pare) {
        podarBranca(pare, Branca.ESQUERRA);
    }

    public void podarDreta(Node pare) {
        podarBranca(pare, Branca.DRETA);
    }

    // ------------------------------------------------------------
    // SISTEMA D'IMPRIMIR
    //
    // L'arbre pot imprimir-se complet o a partir de qualsevol node.
    // Els mètodes sense paràmetres deleguen als equivalents que
    // reben un node, mantenint una interfície clara i flexible.
    // ------------------------------------------------------------
    // --- Impressió des de l'arrel ---
    public void imprimir(Recorregut tipus) {
        imprimir(arrel, tipus);
    }

    // --- Impressió des de qualsevol node ---
    public void imprimir(Node node, Recorregut tipus) {
        switch (tipus) {
            case PREFIXA ->
                imprimirPreFixa(node);
            case INFIXA ->
                imprimirInFixa(node);
            case POSTFIXA ->
                imprimirPostFixa(node);
            case ARBRE ->
                imprimirArbre(node);
        }
    }

    // --- Mètodes específics des de l'arrel ---
    public void imprimirPreFixa() {
        imprimirPreFixa(arrel);
    }

    public void imprimirInFixa() {
        imprimirInFixa(arrel);
    }

    public void imprimirPostFixa() {
        imprimirPostFixa(arrel);
    }

    public void imprimirArbre() {
        imprimirArbre(arrel);
    }

    // --- Mètodes específics des de qualsevol node ---
    public void imprimirPreFixa(Node node) {
        imprimirPreFixaRecursiu(node);
        System.out.println();
    }

    public void imprimirInFixa(Node node) {
        imprimirInFixaRecursiu(node);
        System.out.println();
    }

    public void imprimirPostFixa(Node node) {
        imprimirPostFixaRecursiu(node);
        System.out.println();
    }

    public void imprimirArbre(Node node) {
        imprimirArbre(node, 0);
    }

    // ------------------------------------------------------------
    // IMPRESSIÓ ESTRUCTURAL
    //
    // Mostra l'arbre amb indentació segons el nivell del node.
    // És útil per visualitzar l'estructura jeràrquica.
    // ------------------------------------------------------------
    private void imprimirArbre(Node node, int nivell) {
        //TO DO
    }

    // ------------------------------------------------------------
    // RECORREGUTS CLÀSSICS
    //
    // Implementacions recursives dels recorreguts prefixa,
    // infixa i postfixa. No fan salts de línia: això es gestiona
    // als mètodes públics.
    // ------------------------------------------------------------
    private void imprimirPreFixaRecursiu(Node node) {
        //TO DO
    }

    private void imprimirInFixaRecursiu(Node node) {
        //TO DO
    }

    private void imprimirPostFixaRecursiu(Node node) {
        //TO DO
    }
}
