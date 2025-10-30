/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud1a4ProvaPractica1MODv2MarcMas {

    public static float area(float x, float y) {
        return x * y; //funcio simple per calcular l'area
    }

    public static float areaTerra(float longitud, float amplada) {
        return area(longitud, amplada);
    }

    public static float areaRajoles(float ampladaRajola, float longitudRajola) {
        return area(ampladaRajola, longitudRajola);
    }

    public static float areaFinestra(float ampladaFinestra, float alturaFinestra) {
        return area(alturaFinestra, alturaFinestra);
    }

    public static float areaPorta(Integer tipusPorta, float alturaBany, float ampladaBany) {
        Scanner s = new Scanner(System.in);
        switch (tipusPorta) {
            case 1 -> { //adaptada
                return (float) (1.2 * 2);
            }
            case 2 -> { //normal
                return (float) (0.8 * 2);
            }
            case 3 -> { //personalitzada
                float pAlt = 0f;
                float pAmp = 0f;
                System.out.println("Altura de la porta?");
                pAlt = s.nextFloat();
                pAlt = validacio(pAlt, 0.8f, alturaBany);
                System.out.println("Amplada de la porta?");
                pAmp = s.nextFloat();
                pAmp = validacio(pAmp, 1f, ampladaBany);
                return pAlt * pAmp;
            }
            default -> {
                return 0f;
            }
        }

    }

    public static float areaParets(float longitudBany, float ampladaBany, float alturaBany, float areaPorta, float areaFinestra) {
        float area = (area(longitudBany, ampladaBany) * 2) + (area(ampladaBany, alturaBany) * 2); //area d1e dues parets + area de les altres dues parets
        area -= areaPorta; //restam l'àrea de la porta
        area -= areaFinestra; //restam l'area de la finestra
        return area;
    }

    public static Integer nombreRajoles(float area, float areaRajoles) {
        // area = la superficie de la qual volem calcular,
        // areaRajoles = superficie de la rajola amb el que ho volem omplir
        float n = 0; //n = nombre de rajoles
        n = area / areaRajoles;
        n *= 1.1; //10% extra
        if ((int) n == n) {
            return (int) n;
        } else {
            return (int) n + 1;
        }
    }

    public static Integer tempsInstalacio(float area, float metresHora) {
        float h = area / metresHora; //h = hores
        if ((int) h == h) {
            return (int) h;
        } else {
            return (int) h + 1;
        }
    }

    public static float preuInstalacio(int hores, float preuHora) {
        return hores * preuHora;
    }

    public static float validacio(float var, float min, float max) {
        Scanner s = new Scanner(System.in);
        while (var > max || var < min) {
            System.out.println("Introdueix un nombre valid (entre " + min + " i " + max + " )");
            var = s.nextFloat();
        }
        return var;
    }

    public static int validacio(int var, int min, int max) {
        return (int) validacio((float) var, min, max);
    }

    public static float validacio(float var, int min, int max) {
        return validacio(var, (float) min, (float) max);
    }

    public static float validacio(float var, int min) {
        return validacio(var, (float) min, 999999999);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per calcular pressupost d'un bany");
        System.out.println("Per favor, introdueixi tots els valors en metres");
        float l = 0f;
        System.out.println("Longitut del bany?");
        l = s.nextFloat();
        l = validacio(l, 2, 10);

        float amp = 0f;
        System.out.println("Amplada del bany?");
        amp = s.nextFloat();
        amp = validacio(amp, 2, 10);

        float alt = 0f;
        System.out.println("Altura del bany?");
        alt = s.nextFloat();
        amp = validacio(amp, 2, 10);

        Integer tipusPorta = 0;
        System.out.println("Quina porta vol? 1 per porta adaptada, 2 per porta normal, 3 per porta personalitzada");
        tipusPorta = s.nextInt();
        tipusPorta = validacio(tipusPorta, 1, 3);
        float areaPorta = areaPorta(tipusPorta, alt, amp);

        float fAlt = 0f;
        System.out.println("Altura de la finestra?");
        fAlt = s.nextFloat();
        fAlt = validacio(fAlt, 1, (int) alt);

        float fAmp = 0f;
        System.out.println("Amplada de la finestra?");
        fAmp = s.nextFloat();
        fAmp = validacio(fAmp, 1, (int) amp);

        float rAmpT = 0f;
        System.out.println("Amplada de la rajola del terra?");
        rAmpT = s.nextFloat();
        rAmpT = validacio(rAmpT, 0.05f, 1f);

        float rLonT = 0f;
        System.out.println("Longitut de la rajola del terra?");
        rLonT = s.nextFloat();
        rLonT = validacio(rLonT, 0.05f, 1f);

        float rAmpP = 0f;
        System.out.println("Amplada de la rajola de paret?");
        rAmpP = s.nextFloat();
        rAmpP = validacio(rAmpP, 0.05f, 1f);

        float rLonP = 0f;
        System.out.println("Longitut rajola de paret?");
        rLonP = s.nextFloat();
        rLonP = validacio(rLonP, 0.05f, 1f);

        float preuRajolaT = 0f;
        System.out.println("Preu per rajola de terra (sense IVA)");
        preuRajolaT = s.nextFloat();
        preuRajolaT = validacio(preuRajolaT, 0);

        float preuRajolaP = 0f;
        System.out.println("Preu per rajola de paret (sense IVA)");
        preuRajolaP = s.nextFloat();
        preuRajolaP = validacio(preuRajolaP, 0);

        Integer instalacio = 0;
        System.out.println("Vol l'instalacio? 1 per si, 2 per no");
        instalacio = s.nextInt();
        instalacio = validacio(instalacio, 1, 2);

        float superficieTerra = areaTerra(l, amp);
        float superficieParets = areaParets(l, amp, alt, areaPorta, areaFinestra(fAmp, fAlt));
        Integer nRajolesTerra = nombreRajoles(superficieTerra, areaRajoles(rAmpT, rLonT));
        Integer nRajolesParets = nombreRajoles(superficieParets, areaRajoles(rAmpP, rLonP));
        float preuTotalRajolaT = nRajolesTerra * preuRajolaT;
        float preuTotalRajolaP = nRajolesParets * preuRajolaP;
        float preuInstalacioT = preuInstalacio(tempsInstalacio(superficieTerra, 60f), 60f);
        float preuInstalacioP = preuInstalacio(tempsInstalacio(superficieParets, 60f), 60f);
        float preuTotalRajoles = preuTotalRajolaP + preuTotalRajolaT;
        float preuTotalInstalacio = preuInstalacioP + preuInstalacioT;
        float preuTotal = 0;
        preuTotal = preuTotalRajoles;
        if (instalacio == 1) {
            preuTotal += preuTotalInstalacio;
        }
        final float IVA = 1.21f;
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
        System.out.println("Cost total: " + preuTotal + " (sense IVA)");
        System.out.println("Cost total amb IVA: " + (preuTotal * IVA));

    }
}
