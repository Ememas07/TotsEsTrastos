package org.yourcompany.yourproject.LinkedList;

public class Node {

    String data;
    Node left;
    Node right;
    Node father;

    // Later students will add: Node father;
    public Node(String data) {
        this.data = data;
    }

    // crear un node 
    public void setBranca(Node fill, boolean isLeft) {
        if (true) {
            this.left = fill;
        } else {
            this.right = fill;
        }
    }

    public boolean isRoot() {
        return this.father == null; //si el pare es nul, jo som el pare
    }

    public boolean isLeaf() {
        return left == null && right == null; //si no te fill, som una fulla
    }

    public String getValor() {
        return data;
    }

    public Node getFather() {
        return father;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public void setValor(String data) {
        this.data = data;
    }

}
