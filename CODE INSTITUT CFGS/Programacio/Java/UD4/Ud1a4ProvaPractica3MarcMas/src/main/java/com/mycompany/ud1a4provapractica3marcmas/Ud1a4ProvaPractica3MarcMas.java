/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ud1a4provapractica3marcmas;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud1a4ProvaPractica3MarcMas {

    public static void cls() { // command to clear the screen 
        for (int i = 0; i < 25; i++) {
            System.out.println("");
        }
    }

    public static char gradientCharacter(int n) {
        n %= 8;
        switch (n) {
            case 1,8 -> {
                return '.';
            }
            case 2,7 -> {
                return '-';
            }
            case 3,6 -> {
                return '+';
            }
            default -> {
                return '*';
            }
        }
    }

    public static char gradientCharacter() {
        return gradientCharacter(0);
    }

    public static void row(int length, char character) {
        for (int i = 0; length > i; i++) {
            System.out.print(character);
        }
        System.out.println("");
    }

    public static void row(int length, char character, int gradient) {
        if (gradient == 1) {
            for (int i = 0; length > i; i++) {
                character = gradientCharacter(i);
                System.out.print(character);
            }
            System.out.println("");
        } else {
            row(length, character);
        }
    }

    public static void row(int length, char character, boolean bordersOnly) {
        if (bordersOnly) {
            for (int i = 0; length > i; i++) {
                if (i == 0 || i == length - 1) {
                    System.out.print(character);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        } else {
            row(length, character);
        }
    }

    public static void column(int height, char character) {
        for (int i = 0; height > i; i++) {
            System.out.println(character);
        }
    }

    public static void square(int height, char character, int version) {
        rectangle(height, height, character, version);
    }

    public static void rectangle(int height, int length, char character, int version) {
        for (int i = 0; height > i; i++) {
            if (version == 1 && i != 0 && i != height - 1) { //borders only
                row(length, character, true);
            } else {
                row(length, character);
            }
        }
    }

    public static void triangle(int height, char character, int versio) {
        switch (versio) {
            case 1 -> {
                // *
                // **
                // ***
                for (int i = 0; height >= i; i++) {
                    row(i, character);
                }
            }
            case 2 -> {
                // ***
                // **
                // *
                for (int i = 0; height >= i; i++) {
                    row(height - i, character);
                }
            }
            case 3 -> {
                //   *
                //  **
                // ***
                int chars = 0;
                for (int i = 0; height > i; i++) {
                    for (int j = height - chars; j > 0; j--) {
                        System.out.print(" ");
                    }
                    row(chars + 1, character);
                    chars++;
                }
            }
            case 4 -> {
                // ***
                //  **
                //   *
                int chars = 0;
                for (int i = height; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(" ");
                    }
                    row(chars + 1, character);
                    chars++;
                }
            }
            default -> {
                System.out.println("Not a valid version!");
            }
        }

    }

    public static void pyramid(int height, char character, int gradient) {
        int chars = 1;
        for (int i = height; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            row(chars, character, gradient);
            chars += 2;
        }
    }

    public static int askLength(int version) {
        Scanner s = new Scanner(System.in);
        switch (version) {
            case 1:
                System.out.println("How long should it be?");
                break;
            case 2, 3, 5, 6:
                System.out.println("How tall should it be?");
                break;
            default:
                break;
        }
        return validate(s.nextInt(), 0, 100);
    }

    public static int validate(int input, int min, int max) {
        Scanner s = new Scanner(System.in);
        while (input > max || input < min) {
            System.out.println("Please enter a valid number");
            input = s.nextInt();
        }
        return input;
    }

    public static void main(String[] args) {
        char character = '\0';
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to my ASCII art program!");
        System.out.println("Enter a negative number to exit");
        System.out.println("Please choose any of the following options to print:");
        int choice = 0;
        int length = 0;
        int height = 0;
        int variation = 0;
        while (choice >= 0) {
            System.out.println("Enter 1 for a row");
            System.out.println("Enter 2 for a column");
            System.out.println("Enter 3 for a square");
            System.out.println("Enter 4 for a rectangle");
            System.out.println("Enter 5 for a triangle");
            System.out.println("Enter 6 for a pyramid");
            choice = s.nextInt();
            System.out.println("Please choose what character you'd like to use to print");
            character = s.next().charAt(0);
            switch (choice) {
                case 1 -> { //row
                    length = askLength(1);
                    row(length, character);
                }
                case 2 -> { //column
                    length = askLength(2);
                    column(length, character);
                }
                case 3 -> { //square
                    length = askLength(2);
                    System.out.println("If you want it to be borderless, input 1");
                    variation = s.nextInt();
                    square(length, character, variation);
                }
                case 4 -> { //rectangle
                    height = askLength(1);
                    length = askLength(2);
                    System.out.println("If you want it to be borderless, input 1");
                    variation = s.nextInt();
                    rectangle(length, height, character, variation);
                }
                case 5 -> { //triangle
                    System.out.println("What version would you like?");
                    variation = s.nextInt();
                    length = askLength(2);
                    triangle(length, character, variation);
                }
                case 6 -> { //pyramid
                    length = askLength(2);
                    System.out.println("If you want it to be a gradient, input 1");
                    variation = s.nextInt();
                    pyramid(length, character, variation);
                }
                default -> {
                    if (choice > 0) {
                        System.out.println("Enter a valid choice!");
                    }
                }
            }
        }

    }
}
