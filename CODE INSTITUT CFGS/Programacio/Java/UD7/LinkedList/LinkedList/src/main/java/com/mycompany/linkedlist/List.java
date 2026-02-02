/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linkedlist;

/**
 *
 * @author Devil Hongo
 */
public class List {

    // ============================
    // INTERNAL NODE CLASS
    // ============================
    private static class Node {

        Data data;
        Node next;
        Node prev;

        // Later students will add: Node prev;
        Node(Data data) {
            this.data = data;
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
    public void addAt(int index, Data data) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index out of range: " + index + " (size: " + size + ")"
            );
        }

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.prev = null;
            newNode.next = head;
            head = newNode;
            if (size > 0) {
                newNode.next.prev = newNode;
            }
        } else {
            if (index == size) {
                newNode.prev = tail;
                newNode.next = null;
                tail = newNode;
            }
            Node current;
            if (index > (size / 2 + 1)) {
                current = tail;
                for (int i = size; i > index; i--) {
                    current = current.prev;
                }
            } else {
                current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
            }

            newNode.next = current.next;
            current.next = newNode;
            current.next.prev = newNode;
            newNode.prev = current;
        }

        size++;
    }

    // ============================
    // ADD FIRST
    // ============================
    public void addFirst(Data data) {
        addAt(0, data);
    }

    // ============================
    // ADD LAST
    // ============================
    public void addLast(Data data) {
        addAt(size, data);
    }

    // ============================
    // REMOVE AT INDEX
    // ============================
    public Data removeAt(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index out of range: " + index + " (size: " + size + ")"
            );
        }

        Data removed;

        if (index == 0) {
            removed = head.data;
            head = head.next;
        } else {
            Node current;
            if (index > (size / 2 + 1)) {
                current = tail;
                for (int i = size; i > index; i--) {
                    current = current.prev;
                }
            } else {
                current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
            }

            removed = current.next.data;
            current.next.prev = current;
            current.next = current.next.next;
            /* 
            newNode.next = current.next;
            current.next = newNode;
            current.next.prev = newNode;
            newNode.prev = current;
             */
        }

        size--;
        return removed;
    }

    // ============================
    // REMOVE FIRST
    // ============================
    public void removeFirst(Data data) {
        removeAt(0);
    }

    // ============================
    // REMOVE LAST
    // ============================
    public void removeLast(Data data) {
        removeAt(size);
    }

    // ============================
    // PRINT LIST
    // ============================
    public void print() {

        Node current = head;

        System.out.print("[ ");

        while (current != null) {

            // Print the element
            System.out.print(current.data);

            // Print comma only if there is a next element
            if (current.next != null) {
                System.out.print(", ");
            }

            current = current.next;
        }

        System.out.println(" ]");
    }

}
