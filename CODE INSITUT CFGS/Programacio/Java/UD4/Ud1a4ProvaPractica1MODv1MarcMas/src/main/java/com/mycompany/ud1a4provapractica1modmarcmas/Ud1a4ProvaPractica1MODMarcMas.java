/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ud1a4provapractica1modmarcmas;

import java.util.Scanner;

/**
 *
 * @author Mewtwo
 */
public class Ud1a4ProvaPractica1MODMarcMas {

    public static float areaTerra(float l, float amp) {
        return (l * amp);
    }

    public static float areaParets(float l, float amp, float alt, int tipusPorta, float areaFinestra) {
        float area = ((l * alt) * 2) + ((amp * alt) * 2);
        // float area = (l * alt) / 2 + (amp * alt) / 2; // ORIGINAL
        if (tipusPorta == 1) { // 1 es adaptada
            area -= (1.2 * 2);
        } else {
            area -= (0.8 * 2);
        }
        area -= areaFinestra;
        return area;
    }

    public static float calcularFinestra(float fAmp, float fAlt) {
        return (fAlt * fAmp);
    }

    public static float areaRajoles(float rAmp, float rLon) {
        return (rAmp * rLon);
    }

    /* public static Integer nombreRajoles(float area, float areaRajoles) {
        Integer n = 0;
        while (areaRajoles * n < area) {
            n++;
        }
        // return (int) n * 1.1; //ORIGINAL
        return (int) (n * 1.1); // MODIFICAT

    } 
     */
    public static Integer nombreRajoles(float area, float areaRajoles) {
        float n = 0;
        n = area / areaRajoles;
        n *= 1.1;
        if ((int) n == n) {
            return (int) n;
        } else {
            return (int) n + 1;
        }

    }

    /* public static Integer tempsInstalacio(float area) {
        // Integer a = area; //ORIGINAL
        Integer a = (int) area; //MODIFICAT
        Integer n = 0;
        while (a >= 0) {
            n++; //1 hora
            a -= 2; //2 metres
        }
        return n;
    } */
    public static Integer tempsInstalacio(float area) {
        float h = area / 60;
        if ((int) h == h) {
            return (int) h;
        } else {
            return (int) h + 1;
        }
    }

    // a l'original totes les variable float estan declarades com a "float var = 0.0"
    // per compilar a netbeans, afegire una F a cada valor
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per calcular pressupost d'un bany");
        System.out.println("Per favor, introdueixi tots els valors en metres");
        float l = 0.0f;
        do {
            System.out.println("Longitut del bany?");
            l = s.nextFloat();
            if (l >= 10 || l <= 2) {
                System.out.println("Introdueixi un nombre valid");
            }
        } while (l >= 10 || l <= 2);

        float amp = 0.0f;
        do {
            System.out.println("Amplada del bany?");
            amp = s.nextFloat();
            if (amp >= 10 || amp <= 2) {
                System.out.println("Introdueixi una amplada valida");
            }
        } while (amp >= 10 || amp <= 2);
        float alt = 0.0f;
        do {
            System.out.println("Altura del bany?");
            alt = s.nextFloat();
            if (alt >= 10 || alt <= 2) {
                System.out.println("Introdueixi una altura valida");
            }
        } while (alt >= 10 || alt <= 2);
        Integer tipusPorta = 0;
        do {
            System.out.println("Quina porta vol? 1 per porta adaptada, 2 per porta normal");
            tipusPorta = s.nextInt();
            if (tipusPorta < 1 || tipusPorta > 2) {
                System.out.println("Introdueixi un tipus valid");
            }
        } while (tipusPorta < 1 || tipusPorta > 2);
        float fAlt = 0.0f;
        System.out.println("Altura de la finestra?");
        fAlt = s.nextFloat();
        while (fAlt >= alt || fAlt <= 0.25) {
            System.out.println("Introdueixi una amplada valida");
            fAlt = s.nextFloat();
        }
        float fAmp = 0.0f;
        System.out.println("Amplada de la finestra?");
        fAmp = s.nextFloat();
        while (fAmp >= amp || fAmp <= 0.25) {
            System.out.println("Introdueixi una amplada valida");
            fAmp = s.nextFloat();
        }
        float rAmpT = 0.0f;
        System.out.println("Amplada de la rajola del terra?");
        rAmpT = s.nextFloat();
        while (rAmpT >= 1 || rAmpT <= 0.05) {
            System.out.println("Introdueixi una amplada de rajola valida");
            rAmpT = s.nextFloat();
        }
        float rLonT = 0.0f;
        System.out.println("Longitut de la rajola del terra?");
        rLonT = s.nextFloat();
        while (rLonT >= 1 || rLonT <= 0.05) {
            System.out.println("Introdueixi una longitud de rajola valida");
            rLonT = s.nextFloat();
        }
        float rAmpP = 0.0f;
        System.out.println("Amplada de la rajola de paret?");
        rAmpP = s.nextFloat();
        while (rAmpP >= 1 || rAmpP <= 0.05) {
            System.out.println("Introdueixi una amplada de rajola valida");
            rAmpT = s.nextFloat();
        }
        float rLonP = 0.0f;
        System.out.println("Longitut rajola de paret?");
        rLonP = s.nextFloat();
        while (rLonP >= 1 || rLonP <= 0.05) {
            System.out.println("Introdueixi una longitud de rajola valida");
            rLonP = s.nextFloat();
        }
        float preuRajolaT = 0.0f;
        System.out.println("Preu per rajola de terra (sense IVA)");
        preuRajolaT = s.nextFloat();
        while (preuRajolaT <= 0) {
            System.out.println("Introdueixi un preu valid");
            preuRajolaT = s.nextFloat();
        }
        float preuRajolaP = 0.0f;
        System.out.println("Preu per rajola de paret (sense IVA)");
        preuRajolaP = s.nextFloat();
        while (preuRajolaP <= 0) {
            System.out.println("Introdueixi un preu valid");
            preuRajolaP = s.nextFloat();
        }
        Integer instalacio = 0;
        System.out.println("Vol l'instalacio? 1 per si, 2 per no");
        instalacio = s.nextInt();
        while (instalacio < 1 || instalacio > 2) {
            System.out.println("Introdueixi un nombre valid");
            instalacio = s.nextInt();
        }

        float superficieTerra = areaTerra(l, amp);
        float superficieParets = areaParets(l, amp, alt, tipusPorta, calcularFinestra(fAmp, fAlt));
        Integer nRajolesTerra = nombreRajoles(superficieTerra, areaRajoles(rAmpT, rLonT));
        Integer nRajolesParets = nombreRajoles(superficieParets, areaRajoles(rAmpP, rLonP));
        float preuTotalRajolaT = nRajolesTerra * preuRajolaT;
        float preuTotalRajolaP = nRajolesParets * preuRajolaP;
        float preuInstalacioT = tempsInstalacio(superficieTerra) * 60;
        float preuInstalacioP = tempsInstalacio(superficieParets) * 60;
        float preuTotalRajoles = preuTotalRajolaP + preuTotalRajolaT;
        float preuTotalInstalacio = preuInstalacioP + preuInstalacioT;
        float preuTotal = 0;
        if (instalacio == 1) {
            preuTotal = preuTotalRajoles + preuTotalInstalacio;
        } else {
            preuTotal = preuTotalRajoles;
        }
        // static float IVA = 1.21; // ORIGINAL
        final float IVA = 1.21f; //MODIFICAT
        System.out.println("La superficie del terra es " + superficieTerra);
        System.out.println("La superficie de les parets es " + superficieParets);
        System.out.println("Hi haura " + nRajolesTerra + " Rajoles al terra");
        System.out.println("Hi haura " + nRajolesParets + " Rajoles a les parets");
        System.out.println("El cost de les rajoles del terra sense IVA es " + preuTotalRajolaT);
        System.out.println("El cost de les rajoles del terra amb IVA es " + (preuTotalRajolaT * IVA));
        System.out.println("El cost de les rajoles de les parets sense IVA es " + preuTotalRajolaP);
        System.out.println("El cost de les rajoles de les parets amb IVA es " + (preuTotalRajolaP * IVA));
        if (instalacio == 1) {
            System.out.println("Preu instalacio sense IVA " + preuTotalInstalacio);
            System.out.println("Preu instalacio amb IVA " + (preuTotalInstalacio * IVA));
        }
        System.out.println("Cost total: " + preuTotal + "(sense IVA)");
        System.out.println("Cost total amb IVA: " + (preuTotal * IVA));

    }

}
