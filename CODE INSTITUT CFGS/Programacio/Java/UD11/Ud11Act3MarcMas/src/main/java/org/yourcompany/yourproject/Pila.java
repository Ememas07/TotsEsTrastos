/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 * @param <T>
 */
public interface Pila<T> {

    public void push(T nou);

    public T pop();

    public boolean esBuida();
}
