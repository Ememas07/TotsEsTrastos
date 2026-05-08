/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Ud11Act2MarcMas {

    public static void main(String[] args) {
        Contenidor<String> cString = new Contenidor();
        cString.insertarAlFinal("hola");
        cString.insertarAlPrincipi("dia");
        cString.insertarAlPrincipi("bon");
        String s1 = cString.extreureDelPrincipi();
        String s2 = cString.extreureDelPrincipi();
        String s3 = cString.extreureDelFinal();
        Contenidor<Integer> cInt = new Contenidor();
        cInt.insertarAlFinal(14);
        cInt.insertarAlPrincipi(23);
        cInt.insertarAlPrincipi(36);
        int i1 = cInt.extreureDelPrincipi();
        int i2 = cInt.extreureDelPrincipi();
        int i3 = cInt.extreureDelFinal();
        Contenidor<Double> cDouble = new Contenidor();
        cDouble.insertarAlFinal(3.7);
        cDouble.insertarAlPrincipi(1.7);
        cDouble.insertarAlPrincipi(4.3);
        cDouble.insertarAlPrincipi(4.2);
        cDouble.insertarAlPrincipi(4.9);
        Double d1 = cDouble.extreureDelPrincipi();
        Double d2 = cDouble.extreureDelPrincipi();
        Double d3 = cDouble.extreureDelPrincipi();
        Double d4 = cDouble.extreureDelFinal();
        Double d5 = cDouble.extreureDelFinal();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        System.out.println(d4);
        System.out.println(d5);
    }
}
