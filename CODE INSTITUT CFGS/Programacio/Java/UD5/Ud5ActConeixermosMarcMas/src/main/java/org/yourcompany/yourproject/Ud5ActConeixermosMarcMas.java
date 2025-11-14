/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud5ActConeixermosMarcMas {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK_TEXT = "\u001B[30m";
    public static final String ANSI_RED_TEXT = "\u001B[31m";
    public static final String ANSI_GREEN_TEXT = "\u001B[32m";
    public static final String ANSI_YELLOW_TEXT = "\u001B[33m";
    public static final String ANSI_BLUE_TEXT = "\u001B[34m";
    public static final String ANSI_PURPLE_TEXT = "\u001B[35m";
    public static final String ANSI_CYAN_TEXT = "\u001B[36m";
    public static final String ANSI_WHITE_TEXT = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void cls() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        menu();
    }

    public static void print(String text, int colorText, int colorBg) {
        // RED = "1";
        // GREEN = "2";
        // YELLOW = "3";
        // BLUE = "4";
        // PURPLE = "5";
        // CYAN = "6";
        // WHITE = "7";
        switch (colorText) {
            case 1:
                System.out.print(ANSI_RED_TEXT);
                break;
            
            default:
                throw new AssertionError();
        }

    }

    public static void menu() {
        Scanner s = new Scanner(System.in);
        boolean continuar = true;
        int opcio = 1;
        while (opcio != 0) {
            cls();
            System.out.println("Hola! som en Marc");
            System.out.println("Que vols saber?");
            System.out.println("Introdueix 0 per sortir");
            System.out.println("1. Pel·lícules d’imatge real");
            System.out.println("2. Pel·lícules d’animació");
            System.out.println("3. Series d'imatge real");
            System.out.println("4. Series d'animacio");
            System.out.println("5. Llibres");
            System.out.println("6. Comics");
            System.out.println("7. Videojocs \"actuals\"");
            System.out.println("8. Videojocs \"retro\"");
            opcio = s.nextInt();
            switch (opcio) {
                case 0 ->
                    continuar = false;
                case 1 ->
                    pelisReals();
                case 2 ->
                    pelisAnimacio();
                case 3 ->
                    seriesReals();
                case 4 ->
                    seriesAnimacio();
                case 5 ->
                    llibres();
                case 6 ->
                    comics();
                case 7 ->
                    videojocsActuals();
                case 8 ->
                    videojocsRetro();
                default ->
                    menu();
            }
        }
    }

    public static void intro(String tipus, int estil) {
        Scanner s = new Scanner(System.in);
        String temp = "";
        if (estil == 1) {
            System.out.println("Les meves 3 " + tipus + " son:");
        } else {
            System.out.println("Els meus 3 " + tipus + " son:");
        }
        System.out.println("Introdueix qualsevol caracter per seguir");
        temp = s.next();
    }

    public static void top3(String n1, String n2, String n3) {
        System.out.println("1: " + n1);
        System.out.println("2: " + n2);
        System.out.println("3: " + n3);
    }

    public static void pelisReals() {
        intro("Pel·licules d'imatge Real", 1);
        top3("Le Mans 66", "Gran Turismo", "Top Gun: Maverick");
    }

    public static void pelisAnimacio() {
        intro("Pel·licules d'animacio", 1);
        top3("Cars", "Cars 3", "Mortadelo i Filemon contra Jimmy el Cachondo");
    }

    public static void seriesReals() {
        intro("Series d'imatge Real", 1);
        top3("Top Gear", "New Amsterdam", "The Good Doctor");
    }

    public static void seriesAnimacio() {
        intro("Series d'animacio", 1);
        top3("Doraemon", "Bob Esponja", "Gumball");
    }

    public static void llibres() {
        intro("Llibres", 2);
        top3("Conexiones", "Nocturn a 4 mans", "");
    }

    public static void comics() {
        intro("Comics", 2);
        top3("Mortadelo i Filemon", "Asterix i Cleopatra", "*Dragon Ball");
        System.out.println("No he llegit dragon ball, pero m'agradaria");
    }

    public static void videojocsActuals() {
        intro("Videojocs actuals", 2);
        top3("Battlefield 6", "iRacing", "Assetto Corsa EVO");
    }

    public static void videojocsRetro() {
        intro("Videojocs retro", 2);
        top3("Super Mario Bros 3", "Tetris", "Pacman");
    }

}
