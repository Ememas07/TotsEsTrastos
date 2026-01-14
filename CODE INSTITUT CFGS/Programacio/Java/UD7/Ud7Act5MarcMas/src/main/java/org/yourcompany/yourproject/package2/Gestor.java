/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject.package2;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Gestor {

    public String nom;
    private int telefon;
    int importMaxim;

    public Gestor(String nom, int telefon, int importMaxim) {
        this.nom = nom;
        this.telefon = telefon;
        this.importMaxim = importMaxim;
    }

    public Gestor(String nom, int telefon) {
        this(nom, telefon, 10000);
    }

    public static Gestor crearGestor() {
        Scanner s = new Scanner(System.in); //cream un gestor amb totes les dades introduides per consola
        System.out.println("Introdueix el nom del gestor");
        String nom = s.nextLine();
        System.out.println("introdueix el nombre de telefon del gestor");
        int telefon = s.nextInt();
        System.out.println("Introdueix l'import maxim del gestor");
        int importMaxim = s.nextInt();
        return new Gestor(nom, telefon, importMaxim);
    }

    public int getImportMaxim() {
        return importMaxim;
    }

    public void setImportMaxim(int importMaxim) {
        this.importMaxim = importMaxim;
    }

    public int getTelefon() {
        return telefon;
    }

}
