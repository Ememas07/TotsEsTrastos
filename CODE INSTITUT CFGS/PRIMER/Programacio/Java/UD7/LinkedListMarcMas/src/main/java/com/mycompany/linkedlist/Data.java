/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.linkedlist;

import java.util.Currency;
import java.util.Locale;

public class Data {

    private String name;
    private double value;

    // Shared by all Item objects — initialized from system locale
    private static String currencySymbol =
            Currency.getInstance(Locale.getDefault()).getSymbol(Locale.getDefault());

    public Data(String name, double value) {
        this.name = name;
        this.value = value;
    }

    // ===== GETTERS =====

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public static String getCurrencySymbol() {
        return currencySymbol;
    }

    // ===== SETTERS =====

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public static void setCurrencySymbol(String symbol) {
        currencySymbol = symbol;
    }

    // ===== TO STRING =====

    @Override
    public String toString() {
        return name + ": " + String.format(Locale.getDefault(), "%.2f", value) + currencySymbol;
    }
}
