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

    public static final int ALTARIAPANTALLA = 25;

    public static void cls(int lineesEscrites) {
        int buits = ALTARIAPANTALLA - lineesEscrites - 1;
        for (int i = 0; i < buits; i++) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        menu();
    }

    public static void color(int colorSeleccionat, int estilColor) {

        // BLACK = "0";
        // RED = "1";
        // GREEN = "2";
        // YELLOW = "3";
        // BLUE = "4";
        // PURPLE = "5";
        // CYAN = "6";
        // WHITE = "7";
        String colorText[] = new String[8];
        colorText[0] = ANSI_BLACK_TEXT;
        colorText[1] = ANSI_RED_TEXT;
        colorText[2] = ANSI_GREEN_TEXT;
        colorText[3] = ANSI_YELLOW_TEXT;
        colorText[4] = ANSI_BLUE_TEXT;
        colorText[5] = ANSI_PURPLE_TEXT;
        colorText[6] = ANSI_CYAN_TEXT;
        colorText[7] = ANSI_WHITE_TEXT;

        String colorBg[] = new String[8];
        colorBg[0] = ANSI_BLACK_BACKGROUND;
        colorBg[1] = ANSI_RED_BACKGROUND;
        colorBg[2] = ANSI_GREEN_BACKGROUND;
        colorBg[3] = ANSI_YELLOW_BACKGROUND;
        colorBg[4] = ANSI_BLUE_BACKGROUND;
        colorBg[5] = ANSI_PURPLE_BACKGROUND;
        colorBg[6] = ANSI_CYAN_BACKGROUND;
        colorBg[7] = ANSI_WHITE_BACKGROUND;

        if (estilColor == 1) { //1 = color de text
            System.out.print(colorText[colorSeleccionat]);
        } else { //0/2 == color de fondo
            System.out.print(colorBg[colorSeleccionat]);
        }

    }

    public static void resetColor() {
        System.out.print(ANSI_RESET);
    }

    public static void menu() {
        Scanner s = new Scanner(System.in);
        boolean continuar = true;
        int opcio = 1;
        while (continuar) {
            color(7, 1);
            color(1, 2);
            System.out.println("Hola! som en Marc");
            resetColor();
            color(4, 1);
            System.out.println("Que vols saber?");
            System.out.println("0: Sortir");
            color(6, 1);
            System.out.println("1: Pel·lícules d'imatge real");
            System.out.println("2: Pel·lícules d'animació");
            System.out.println("3: Series d'imatge real");
            System.out.println("4: Series d'animacio");
            color(3, 1);
            System.out.println("5: Llibres");
            System.out.println("6: Comics");
            System.out.println("7: Videojocs \"actuals\"");
            System.out.println("8: Videojocs \"retro\"");
            cls(11);
            resetColor();
            opcio = s.nextInt();
            cls(5);
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
            resetColor();
        }
    }

    public static void intro(String tipus, int estil) {
        if (estil == 1) {
            System.out.println("Les meves 3 " + tipus + " son:");
        } else {
            System.out.println("Els meus 3 " + tipus + " son:");
        }
    }

    public static void esperarInput() {
        Scanner s = new Scanner(System.in);
        String temp = "";
        System.out.println("Introdueix qualsevol caracter per seguir");
        temp = s.next();
    }

    public static void top3(String n1, String n2, String n3) {
        System.out.println("1: " + n1);
        System.out.println("2: " + n2);
        System.out.println("3: " + n3);
        esperarInput();
    }

    public static void pelisReals() {
        color(1, 1);
        intro("Pel·licules d'imatge Real", 1);
        top3("Le Mans 66", "Gran Turismo", "Top Gun: Maverick");
    }

    public static void pelisAnimacio() {
        color(2, 2);
        intro("Pel·licules d'animacio", 1);
        top3("Cars", "Cars 3", "Mortadelo i Filemon contra Jimmy el Cachondo");
    }

    public static void seriesReals() {
        color(2, 1);
        intro("Series d'imatge Real", 1);
        top3("Top Gear", "New Amsterdam", "The Good Doctor");
    }

    public static void seriesAnimacio() {
        color(5, 1);
        intro("Series d'animacio", 1);
        top3("Doraemon", "Bob Esponja", "Gumball");
    }

    public static void llibres() {
        color(6, 2);
        intro("Llibres", 2);
        top3("Conexiones", "Nocturn a 4 mans", "El metode gronholm");
    }

    public static void comics() {
        color(5, 2);
        intro("Comics", 2);
        top3("Mortadelo i Filemon", "Asterix i Cleopatra", "*Dragon Ball");
        System.out.println("No he llegit dragon ball, pero m'agradaria");
    }

    public static void videojocsActuals() {
        color(3, 1);
        intro("Videojocs actuals", 2);
        top3("Battlefield 6", "iRacing", "Assetto Corsa EVO");
    }

    public static void videojocsRetro() {
        color(6, 1);
        intro("Videojocs retro", 2);
        top3("Super Mario Bros 3", "Tetris", "Pacman");
    }

}
