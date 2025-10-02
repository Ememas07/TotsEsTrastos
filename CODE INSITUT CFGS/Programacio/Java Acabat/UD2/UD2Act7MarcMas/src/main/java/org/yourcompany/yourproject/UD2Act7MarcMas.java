/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act7MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix un dia");
        Byte dia = s.nextByte(); //deman un dia per consola
        System.out.println("Introdueix un mes");
        String mes = s.next(); //deman un mes per console en format de string (per fer comprovacions mes tard)
        mes = mes.toLowerCase(); //el convertesc a minuscules per el switch
        System.out.println("Introdueix un any");
        Byte any = s.nextByte(); //deman un any per consola
        Byte mes2 = 0; //Inicialitz una variable de mes2 per tenir el mes en integer, que assignaré al switch
        Byte diesDelMes = 0; //Inicitalitzada una altra variable que canviaré al switch
        switch (mes) { //si el mes es el mes escrit o el nombre, assignaré el valor del mes a "mes2" i el nombre de dies que té aquest mes
            case "gener", "1", "01":
                mes2 = 1;
                diesDelMes = 31;
                break;
            case "febrer", "2", "02":
                mes2 = 2;
                diesDelMes = 28;
                break;
            case "març", "3", "03":
                mes2 = 3;
                diesDelMes = 31;
                break;
            case "abril", "4", "04":
                mes2 = 4;
                diesDelMes = 30;
                break;
            case "maig", "5", "05":
                mes2 = 5;
                diesDelMes = 31;
                break;
            case "juny", "6", "06":
                mes2 = 6;
                diesDelMes = 30;
                break;
            case "juliol", "7", "07":
                mes2 = 7;
                diesDelMes = 31;
                break;
            case "sgost", "8", "08":
                mes2 = 8;
                diesDelMes = 31;
                break;
            case "septembre", "setembre", "9", "09":
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
                mes2 = 0; //si no entra a cap dels anteriors, posam el mes a 0 (perque boti l'error) i posa els dies a 31 perque no boti l'error de dia sempre i quan sigui un dia valid
                diesDelMes = 31;
                break;
        }
        String errors = ""; //variable buida per posar-hi errors més tard
        if (dia > diesDelMes) {
            errors += "el dia introduit no es valid "; //afegesc els missatges d'errors a la variable
        }
        if (mes2 == 0) {
            errors += "el mes introduit no es valid ";
        }
        if (any < 0) {
            errors += "l'any introduit no es valid ";
        }
        if (errors != "") { //si la variable errors no conté res, es que no n'hi ha, en canvi, si no està buida, imprimesc els errors 
            System.out.println(errors);
        } else {
            LocalDate dataCompleta = LocalDate.of(any,mes2,dia); //creare una variable de format LocalDate per despres formatejarlo
            String dataFormatada = dataCompleta.format(DateTimeFormatter.ISO_LOCAL_DATE); //el formateig
            System.out.println(dataFormatada); //l'imprimesc



            // String dia2 = dia.toString(); manera arcaica i manual
            // if (dia < 10) {
            //     dia2 = "0" + dia.toString();
            // }
            // String mes3 = mes2.toString();
            // if (mes2 < 10) {
            //     mes3 = "0" + mes2.toString();
            // }
            // String any2 = any.toString();
            // if (any < 1000) {
            //     any2 = "0" + any.toString();
            //     if (any < 100) {
            //         any2 = "00" + any.toString();
            //         if (any < 10) {
            //             any2 = "000" + any.toString();
            //         }
            //     }
            // }
            // System.out.println("La teva data es " + dia2 + " / " + mes3 + " / " + any2);
            
        }

    }
}
