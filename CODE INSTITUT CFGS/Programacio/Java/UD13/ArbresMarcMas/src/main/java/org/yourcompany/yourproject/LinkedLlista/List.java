/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject.LinkedLlista;

/**
 *
 * @author Marc Mas
 */
public class List {

    // ============================
    // INTERNAL NODE CLASS
    // ============================
    private static class Node {

        Data data;
        Node nextLeft;
        Node nextRight;
        Node father;

        // Later students will add: Node father;
        Node(Data data) {
            this.data = data;
        }

        public boolean isRoot() {
            return this.father == null; //si el pare es nul, jo som el pare
        }

        public boolean isLeaf() {
            return nextLeft == null && nextRight == null; //si no te fill, som una fulla
        }

    }

    // ============================
    // LIST FIELDS
    // ============================
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    // ============================
    // ADD AT INDEX
    // ============================
    public void addAt(Node node, boolean isLeft, Data data) {

        // if (index < 0 || index > size) {
        //     throw new IndexOutOfBoundsException(
        //             "Index out of range: " + index + " (size: " + size + ")"
        //     );
        // }
        Node newNode = new Node(data);

        //     if (index == 0) {
        //         newNode.father = null;
        //         newNode.nextLeft = head;
        //         head = newNode;
        //         if (size > 0) {
        //             newNode.nextLeft.father = newNode;
        //         }
        //     } else {
        //         if (index == size) {
        //             newNode.father = tail;
        //             newNode.nextLeft = null;
        //             tail = newNode;
        //         }
        //         Node current;
        //         if (index > (size / 2 + 1)) {
        //             current = tail;
        //             for (int i = size; i > index; i--) {
        //                 current = current.father;
        //             }
        //         } else {
        //             current = head;
        //             for (int i = 0; i < index - 1; i++) {
        //                 current = current.nextLeft;
        //             }
        //         }
        //         newNode.nextLeft = current.nextLeft;
        //         current.nextLeft = newNode;
        //         current.nextLeft.father = newNode;
        //         newNode.father = current;
        //     }
        //     size++;
    }

    // ============================
    // ADD FIRST
    // ============================
    // public void addFirst(Data data) {
    //     addAt(0, data);
    // }
    // // ============================
    // // ADD LAST
    // // ============================
    // public void addLast(Data data) {
    //     addAt(size, data);
    // }
    // ============================
    // REMOVE AT INDEX
    // ============================
    // public Data removeAt(int index) {
    //     if (index < 0 || index >= size) {
    //         throw new IndexOutOfBoundsException(
    //                 "Index out of range: " + index + " (size: " + size + ")"
    //         );
    //     }
    //     Data removed;
    //     if (index == 0) {
    //         removed = head.data;
    //         head = head.nextLeft;
    //     } else {
    //         Node current;
    //         if (index > (size / 2 + 1)) {
    //             current = tail;
    //             for (int i = size; i > index; i--) {
    //                 current = current.father;
    //             }
    //         } else {
    //             current = head;
    //             for (int i = 0; i < index - 1; i++) {
    //                 current = current.nextLeft;
    //             }
    //         }
    //         removed = current.nextLeft.data;
    //         current.nextLeft.father = current;
    //         current.nextLeft = current.nextLeft.nextLeft;
    //         /* 
    //         newNode.nextLeft = current.nextLeft;
    //         current.nextLeft = newNode;
    //         current.nextLeft.father = newNode;
    //         newNode.father = current;
    //          */
    //     }
    //     size--;
    //     return removed;
    // }
    // // ============================
    // // REMOVE FIRST
    // // ============================
    // public void removeFirst(Data data) {
    //     removeAt(0);
    // }
    // // ============================
    // // REMOVE LAST
    // // ============================
    // public void removeLast(Data data) {
    //     removeAt(size);
    // }
    // ============================
    // PRINT LIST
    // ============================
    public void print() {

        Node current = head;

        System.out.print("[ ");

        while (current != null) {

            // Print the element
            System.out.print(current.data);

            // Print comma only if there is a nextLeft element
            if (current.nextLeft != null) {
                System.out.print(", ");
            }

            current = current.nextLeft;
        }

        System.out.println(" ]");
    }

}
