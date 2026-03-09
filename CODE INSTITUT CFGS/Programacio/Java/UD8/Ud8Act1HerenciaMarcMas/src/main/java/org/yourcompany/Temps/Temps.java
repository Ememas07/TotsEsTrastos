/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Marc Mas
 */
public class Temps {

    int max;
    int valor;

    public Temps(int max, int valor) {
        if (max > valor) {
            valor = 0;
        }
        this.max = max;
        this.valor = valor;
    }

    public boolean assignarValor(int v) {
        if (v > max) {
            System.out.println("Valor no valid");
            return false;
        } else {
            valor = v;
            return true;
        }
    }

    @Override
    public String toString() {
        if (valor < 10) {
            return "0" + valor;
        } else {
            return "" + valor;
        }
    }

}
