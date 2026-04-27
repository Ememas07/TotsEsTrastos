/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import org.yourcompany.yourproject.Coa.Coa;
import org.yourcompany.yourproject.LinkedList.Tree;
import org.yourcompany.yourproject.Pila.Pila;

/**
 *
 * @author Marc Mas
 */
public class ArbresMarcMas {

    public static void main(String[] args) {
        // -post        2 3 5 - +
        // -pre_fila    - + 2 3 5
        // -pre_arbre   - + 2 3 5
        // args = new String[6];
        // args = new String[]{"a","2","3","+","5","+"};
        // args = new String[]{"a", "-", "+", "2", "3", "5"};

        if (args[0].equals("-post")) {
            notacioPostfixa(args);
        } else {
            notacioPrefixaCoa(args);
        }

        // notacioPostfixa(args);
        // notacioPrefixaCoa(args);
        // notacioPrefixaArbre(args, 1);
    }

    public static void notacioPostfixa(String[] operacio) {
        Pila p = new Pila();
        for (int i = 1; i < operacio.length; i++) {
            switch (operacio[i]) {
                case "+" -> {
                    int[] numeros = conseguirNumeros(operacio[i], p);
                    p.apilar((int) (numeros[1] + numeros[0]));
                }
                case "-" -> {
                    int[] numeros = conseguirNumeros(operacio[i], p);
                    p.apilar((int) numeros[1] - numeros[0]);
                }
                case "*" -> {
                    int[] numeros = conseguirNumeros(operacio[i], p);
                    p.apilar((int) numeros[1] * numeros[0]);
                }
                case "/" -> {
                    int[] numeros = conseguirNumeros(operacio[i], p);
                    p.apilar((int) numeros[1] / numeros[0]);
                }
                default -> {
                    p.apilar(Integer.parseInt(operacio[i]));
                }
            }
            switch (operacio[i]) {
                case "+", "-", "/", "*" -> {
                    System.out.println(p.mostrarDarrerElement());
                }
            }
        }
    }

    public static void notacioPrefixaCoa(String[] operacio) {
        Coa c = new Coa();
        for (int i = 1; i < operacio.length; i++) {
            c.encoar(operacio[i]);
        }
        System.out.println(solucioNPC(c));
    }

    public static int solucioNPC(Coa c) { //NPC = NotacioPrefixaCoa
        int a = 0;
        int b = 0;
        while (c.length() > 0) {
            String s = (String) c.desencoar();
            try {
                return Integer.parseInt(s);
            } catch (Exception e) {
                a = solucioNPC(c);
                b = solucioNPC(c);
            }
            return switch (s) {
                case "+" ->
                    a + b;
                case "-" ->
                    a - b;
                case "*" ->
                    a * b;
                case "/" ->
                    a / b;
                default ->
                    throw new IllegalStateException("Unexpected value: " + (s));
            };
        }
        return 0;
    }

    public static boolean notacioPrefixaArbre(String[] operacions, int index) {
        Tree t = new Tree();
        String data = operacions[index];
        t.root = t.add(false, data, null);
        return false;
    }

    public static int[] conseguirNumeros(String op, Pila p) {
        int[] numeros = new int[2];
        numeros[0] = p.desapilar();
        numeros[1] = p.desapilar();
        System.out.print(numeros[1] + op + numeros[0] + "=");
        return numeros;
    }
}
