/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 * Escriure una funció a la qual se li passen dos nombres enters i mostri tots
 * els nombres compresos entre ells. (ambdos inclosos)
 *
 * @author Marc Mas
 */
public class Ud4Act2MarcMas {

    private static void nombresEntre(int n1, int n2) { //funcio que ens dirà tots els nombres entre N1 i N2
        if (n2 > n1) {
            for (; n1 < n2 + 1; n1++) {  //desde N1 fins que N1 sigui major a n2 (+1) per incloure tots els nombre, desde n1 fins a n2
                System.out.println(n1); //imprimim n1
            }
        } else {
            for (; n2 < n1 + 1; n2++) { //mateix funcionament, pero amb l'altre variable
                System.out.println(n2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Programa per imprimir tots els nombres compresos entre ells");
        Scanner s = new Scanner(System.in); //iniciam scanner
        System.out.println("Nombre 1"); //demanam primer nombre
        Integer n1 = s.nextInt(); //assignam
        System.out.println("Nombre 2"); //demanam segon nombre
        Integer n2 = s.nextInt(); //assignam
        nombresEntre(n1, n2);
    }
}
