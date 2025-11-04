/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud4ActRecursivitatMarcMas {

    public static int multiplicacio(int x, int y) {
        // multiplicar es sumar X + X, Y vegades, aixi que restam 1 a "y" i sumam x al resultat de la suma anterior...
        y--;
        if (y > 0) {
            x += multiplicacio(x, y);
        }
        return x; //si y es 0, retornam x directament
    }

    public static int divisio(int x, int y) {
        Integer resultat = 0;
        // dividir es restar X - X, Y vegades fins a 0, aixi que restam 1 a "y" i restam x al resultat de la resta anterior...
        // 12 / 3 = 3 - 3 - 3 - 3 fins a 0, 4 vegades per exemple
        if (x > 0 && x >= y) {
            resultat = 1 + divisio(x - y, y);
        }
        return resultat; //si x es 0 o x es major a o igual a y, retornam 0
    }

    public static int potencia(int x, int y) {
        y--;
        if (y > 0) {
            x *= potencia(x, y);
        }
        return x; //si y no es major a 0, retornam x
    }

    public static int factorial(int x) {
        if (x > 1) {
            x *= factorial(x - 1);
        }
        return x; //si x no es major a 1, retornam x
    }

    public static int fibonacci(int x) {
        if (x > 1) {
            x = fibonacci(x - 1) + fibonacci(x - 2);
        }
        return x; //si x no es major a 1, retornam x
    }

    public static int sumatori(int x) {
        return sumatori(1, x);
    }

    public static int sumatori(int x, int y) {
        if (x < y) {
            x += sumatori(x + 1, y);
        }
        return x; //si x es major que y, retornam x
    }

    public static void main(String[] args) {
        System.out.println("calculadora amb recursivitat");
        System.out.println("nota: els nombres es convertiran a positius si no ho son quan siguin introduits");
        Scanner s = new Scanner(System.in);
        System.out.println("Introdueix el nombre x");
        Integer x = s.nextInt();
        x = Math.abs(x);
        System.out.println("Introdueix el nombre y");
        Integer y = s.nextInt();
        y = Math.abs(y);
        System.out.println("El resultat de la multiplicacio " + x + "*" + y + " es " + multiplicacio(x, y));
        if (y == 0) {
            System.out.println("No se pot dividir per 0!");
        } else if (y > x) {
            System.out.println("El divisor introduit es mes gran que el dividend, aixi que el resultat de la divisio seria menor a 1");
        } else {
            System.out.println("El resultat de la divisio " + x + "/" + y + " es " + divisio(x, y));
        }
        if (Math.pow(x, y) > 2147483647) {
            System.out.println("La potencia es massa gran per un integer, aixi que no el podem calcular");
        } else {
            System.out.println("El resultat de la potencia " + x + "^" + y + " es " + potencia(x, y)
            );
        }
        if (x > 12) {
            System.out.println("El factorial que has introduit es massa gran per un integer, aixi que no es calculable");
        } else {
            System.out.println("El resultat del factorial de " + x + " es " + factorial(x));
        }
        if (x > 34) {
            System.out.println("El nombre que has introduit per a la secuencia de fibonacci es massa gran per un integer, aixi que no es calculable");
        } else {
            System.out.println("El nombre fibonacci amb index " + x + " es " + fibonacci(x));
        }
        System.out.println("El resultat de sumatori de 1 fins a " + x + " es " + sumatori(x));
        System.out.println("El resultat de sumatori de " + x + " fins a " + y + " es " + sumatori(x, y));
    }
}
