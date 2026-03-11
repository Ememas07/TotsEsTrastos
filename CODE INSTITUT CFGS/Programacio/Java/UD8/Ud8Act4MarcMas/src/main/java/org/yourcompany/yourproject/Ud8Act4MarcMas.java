/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.yourcompany.Vehicles.Camio;
import org.yourcompany.Vehicles.Cotxe;
import org.yourcompany.Vehicles.Moto;
import org.yourcompany.Vehicles.Vehicle;
import org.yourcompany.Vehicles.Vehicles;

/**
 *
 * @author Marc Mas
 */
public class Ud8Act4MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcio = 1;
        Vehicles v = new Vehicles();
        while (opcio > 0) { //-1 sortira
            try {
                System.out.println("1: Afegir Camio");
                System.out.println("2: Afegir Cotxe");
                System.out.println("3: Afegir Moto");
                System.out.println("4: Descripcions ");
                System.out.println("-1: Sortir");
                opcio = s.nextInt();
                switch (opcio) {
                    case 1 -> { //Afegir camió
                        Moto m = new Moto(2, 3.2f);
                        v.add(m);
                    }
                    case 2 -> { //Afegir Cotxe
                        Cotxe co = new Cotxe(4, 7.3f);
                        v.add(co);
                    }
                    case 3 -> { //Afegir Moto
                        Camio ca = new Camio(3, 15.7f);
                        v.add(ca);
                    }
                    case 4 -> { //Descripcio de tot
                        Vehicle[] vehicles = v.getVehicles();
                    for (Vehicle vehicle : vehicles) {
                        vehicle.descripcio();
                    }
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Per favor introdueix una opcio valida");
                s.next();
                opcio = s.nextInt();
            }
        }

    }
}
