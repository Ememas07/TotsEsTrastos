/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class UD2Act8MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix una hora");
        Integer hh = s.nextInt();
        System.out.println("Introdueix un minut");
        Integer mm = s.nextInt();
        System.out.println("Introdueix un segon");
        Integer ss = s.nextInt()+1;
        System.out.println("Un segon mes tard seran les "+hh+":"+mm+":"+ss);
    }
}
