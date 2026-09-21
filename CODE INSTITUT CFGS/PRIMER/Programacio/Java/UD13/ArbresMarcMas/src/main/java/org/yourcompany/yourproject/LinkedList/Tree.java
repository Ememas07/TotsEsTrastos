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

    private Node root;

    // ============================
    // INTERNAL NODE CLASS
    // ============================
    public Tree(String data) {
        this.root = new Node(data);
    }

    public Tree(Node n) {
        this.root = n;
    }

    public Tree() {

    }

    public Node addBranch(boolean isLeft, String data, Node father) {
        if (isLeft) {
            if (father.left != null) {
                System.out.println("No se pot inserir a aquesta posicio!");
            }
        } else {
            if (father.right != null) {
                System.out.println("No se pot inserir a aquesta posicio!");
            }
        }
        Node n = new Node(data);
        if (isLeft) {
            father.setLeft(n);
        } else {
            father.setRight(n);
        }
        return n;

    }

    public static Node removeBranch(boolean isLeft, Node father) {
        if (isLeft) {
            father.setLeft(null);
        } else {
            father.setRight(null);
        }
        return father;
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

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

}
