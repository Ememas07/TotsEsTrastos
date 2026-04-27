/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject.LinkedList;

/**
 *
 * @author Marc Mas
 */
public class Tree {

    public Node root;

    // ============================
    // INTERNAL NODE CLASS
    // ============================
    private static class Node {

        String data;
        Node left;
        Node right;
        Node father;

        // Later students will add: Node father;
        Node(String data) {
            this.data = data;
        }

        public boolean isRoot() {
            return this.father == null; //si el pare es nul, jo som el pare
        }

        public boolean isLeaf() {
            return left == null && right == null; //si no te fill, som una fulla
        }
    }

    public static Node add(boolean isLeft, String data, Node father) {
        if (isLeft) {
            if (father.left == null) {
                System.out.println("No se pot inserir a aquesta posicio!");
            }
        } else {
            if (father.right == null) {
                System.out.println("No se pot inserir a aquesta posicio!");
            }
        }
        Node n = new Node(data);
        n.father = father;
        n.left = null;
        n.right = null;
        if (isLeft) {
            father.left = n;
        } else {
            father.right = n;
        }
        return n;
    }

    public static int operate(Node node) {
        try {
            return Integer.parseInt(node.data);
        } catch (Exception e) {
            node.left.data = "" + operate(node.left);
            node.right.data = "" + operate(node.right);
        }
        return switch (node.data) {
            case "+" ->
                Integer.parseInt(node.left.data) + Integer.parseInt(node.right.data);
            case "-" ->
                Integer.parseInt(node.left.data) - Integer.parseInt(node.right.data);
            case "*" ->
                Integer.parseInt(node.left.data) * Integer.parseInt(node.right.data);
            case "/" ->
                Integer.parseInt(node.left.data) / Integer.parseInt(node.right.data);
            default ->
                throw new IllegalStateException("Unexpected value: ");
        };
    }

    /**
     * int a = 0; int b = 0; while (c.length() > 0) { String s = (String)
     * c.desencoar(); try { return Integer.parseInt(s); } catch (Exception e) {
     * a = solucioNPC(c); b = solucioNPC(c); } return switch (s) { case "+" -> a
     * + b; case "-" -> a - b; case "*" -> a * b; case "/" -> a / b; default ->
     * throw new IllegalStateException("Unexpected value: " + (s)); }; } return
     * 0;
     */
}
