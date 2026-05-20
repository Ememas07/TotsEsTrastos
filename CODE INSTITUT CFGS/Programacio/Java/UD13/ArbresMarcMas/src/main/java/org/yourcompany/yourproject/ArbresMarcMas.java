/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import org.yourcompany.yourproject.Coa.Coa;
import org.yourcompany.yourproject.LinkedList.Node;
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

        switch (args[0]) {
            case "-post" ->
                notacioPostfixa(args);
            case "-preA" -> {
                Tree a = construirArbre(args);
                System.out.println(avaluar(a.getRoot()));
            }
            case "-pre" -> {
                notacioPrefixaCoa(args);
            }
            default -> {
                System.out.println("Has de posar una opcio valida (-post: postfixa, -preA: arbre, -pre: prefixa)");
            }
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
            if (isOperacio(operacio[i])) {
                System.out.println(p.mostrarDarrerElement());
            }
        }
    }

    public static int[] conseguirNumeros(String op, Pila p) {
        int[] numeros = new int[2];
        numeros[0] = p.desapilar();
        numeros[1] = p.desapilar();
        System.out.print(numeros[1] + op + numeros[0] + "=");
        return numeros;
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

    public static Tree construirArbre(String tokens[]) {
        int[] index = {1};
        Node arrel = construirNodes(tokens, index);
        return new Tree(arrel);
    }

    public static Node construirNodes(String tokens[], int[] index) {
        String token = tokens[index[0]++];
        Node node = new Node(token);
        if (isOperacio(token)) {
            node.setLeft(construirNodes(tokens, index));
            node.setRight(construirNodes(tokens, index));
        }
        return node;
    }

    public static int avaluar(Node n) {
        String op = n.getValor();
        if (!isOperacio(op)) {
            return Integer.parseInt(op);
        }
        int a = avaluar(n.getLeft());
        int b = avaluar(n.getRight());
        return switch (op) {
            case "+" ->
                a + b;
            case "-" ->
                a - b;
            case "*" ->
                a * b;
            case "/" ->
                a / b;
            default ->
                throw new IllegalStateException("Unexpected value: " + (op));
        };
    }

    public static boolean isOperacio(String s) {
        return switch (s) {
            case "+", "-", "/", "*" ->
                true;
            default ->
                false;
        };
    }
}
