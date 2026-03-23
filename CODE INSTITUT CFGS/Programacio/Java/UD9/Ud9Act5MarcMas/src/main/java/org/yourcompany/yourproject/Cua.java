/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public interface Cua {

    int[] numeros = new int[0];

    void insertarPrincipi(int numero);

    void insertarPrincipi(int[] numeros);

    void insertarFinal(int numero);

    void insertarFinal(int[] insercions);

    void insertarEnmig(int numero, int index);

    void insertarEnmig(int[] numeros, int index);

    void eliminarElement(int index);

    void desapilarTots();

    void mostrarElement(int index);
}
