/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.yourcompany.yourproject;

/**
 *
 * @author Marc Mas
 */
public class Hora {

    byte hora;
    byte minut;
    byte segon;

    public Hora(byte hora, byte minut, byte segon) {
        this.hora = hora;
        this.minut = minut;
        this.segon = segon;
    }

    public Hora(byte hora) {
        this(hora, (byte) 0, (byte) 0); //sobrecarrega de hora sense minuts o segons
    }

    public void sumarSegons(int sumar) {
        formatearHora(hora, minut, segon + sumar); //agafam el nombre de segons a sumar i l'hora inicial, i ho formatejam com a hora
    }

    public void formatearHora(byte hh, byte mm, int ss) {
        while (ss >= 60) {
            ss -= 60;
            //si hi ha més de 60 segons, dividesc per 60 i agafaré el residu,
            // per exemple, si pos un 67, dividire per 60
            // i el residu serà sempre un segon valid (en aquest cas, 7)
            mm += 1; //també afegiré un minut si el valor es més de 60
        }
        while (mm >= 60) {
            mm -= 60;
            hh += 1;
            // mateixa llògica que amb els segons, i sumaré una hora
        }
        while (hh >= 24) {
            hh -= 24;
            //si hi ha més de 24 hores, dividesc per 24 i agafaré el residu,
            // per exemple, si pos un 32, dividire per 24
            // i el residu serà sempre una hora correcta (en aquest cas, 8)
        }
        if (hh < 9) { //si no tenim primer digit afegim un 0, i anam imprimint sense bots de linea
            System.out.print("0");
        }
        System.out.print(hh + ":");
        if (mm < 9) {
            System.out.print("0");
        }
        System.out.print(mm + ":");
        if (ss < 9) {
            System.out.print("0");
        }
        System.out.println(ss);
    }

}
