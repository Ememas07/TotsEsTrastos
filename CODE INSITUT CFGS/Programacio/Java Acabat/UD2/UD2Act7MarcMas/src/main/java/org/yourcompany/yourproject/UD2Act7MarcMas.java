/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act7MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix un dia");
        Integer dia = s.nextInt();
        System.out.println("Introdueix un mes");
        String mes = s.next();
        mes = mes.toLowerCase();
        System.out.println("Introdueix un any");
        Integer any = s.nextInt();
        Integer mes2 = 0;
        Integer diesDelMes = 0;
        switch (mes) {
            case "gener", "1":
                mes2 = 1;
                diesDelMes = 31;
                break;
            case "febrer", "2":
                mes2 = 2;
                diesDelMes = 28;
                break;
            case "març", "3":
                mes2 = 3;
                diesDelMes = 31;
                break;
            case "abril", "4":
                mes2 = 4;
                diesDelMes = 30;
                break;
            case "maig", "5":
                mes2 = 5;
                diesDelMes = 31;
                break;
            case "juny", "6":
                mes2 = 6;
                diesDelMes = 30;
                break;
            case "juliol", "7":
                mes2 = 7;
                diesDelMes = 31;
                break;
            case "sgost", "8":
                mes2 = 8;
                diesDelMes = 31;
                break;
            case "septembre", "setembre", "9":
                mes2 = 9;
                diesDelMes = 30;
                break;
            case "octubre", "10":
                mes2 = 10;
                diesDelMes = 31;
                break;
            case "novembre", "11":
                mes2 = 11;
                diesDelMes = 30;
                break;
            case "decembre", "desembre", "12":
                mes2 = 12;
                diesDelMes = 31;
                break;
            default:
                mes2 = 0;

        }
        String errors = "";
        if (dia > diesDelMes) {
            errors += "el dia introduit no es valid ";
        }
        if (mes2 == 0) {
            errors += "el mes introduit no es valid ";
        }
        if (any < 0) {
            errors += "l'any introduit no es valid ";
        }
        if (errors != "") {
            System.out.println(errors);
        } else {
            System.out.println("La teva data es " + dia + " / " + mes2 + " / " + any);
        }

    }
}
