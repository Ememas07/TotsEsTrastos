/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static org.yourcompany.yourproject.Enemic.RangEnemic.CAP;
import static org.yourcompany.yourproject.Enemic.RangEnemic.MINIO;
import static org.yourcompany.yourproject.Enemic.RangEnemic.NORMAL;
import static org.yourcompany.yourproject.Enemic.TipusEnemic.BANDIT;
import static org.yourcompany.yourproject.Enemic.TipusEnemic.DRAC;
import static org.yourcompany.yourproject.Enemic.TipusEnemic.LLIM;
import static org.yourcompany.yourproject.Enemic.VariantEnemic.BASE;
import static org.yourcompany.yourproject.Enemic.VariantEnemic.FOC;
import static org.yourcompany.yourproject.Enemic.VariantEnemic.TERRA;
import static org.yourcompany.yourproject.Objecte.RaresaObjecte.COMU;
import static org.yourcompany.yourproject.Objecte.RaresaObjecte.INFREQÜENT;
import static org.yourcompany.yourproject.Objecte.RaresaObjecte.RAR;
import static org.yourcompany.yourproject.Objecte.TipusObjecte.ARMA;
import static org.yourcompany.yourproject.Objecte.TipusObjecte.ARMADURA;
import static org.yourcompany.yourproject.Objecte.TipusObjecte.CLAU;
import static org.yourcompany.yourproject.Objecte.TipusObjecte.CONSUMIBLE;

/**
 *
 * @author Marc Mas
 */
public class BinaryAct1MarcMas {

    public static void main(String[] args) throws java.io.UnsupportedEncodingException {

        ObjectOutputStream fitxerSortida = null;
        ObjectInputStream fitxerEntrada = null;
        try {
            fitxerSortida = new ObjectOutputStream(new FileOutputStream("fitxer.mmas"));
            fitxerEntrada = new ObjectInputStream(new FileInputStream("fitxer.mmas"));
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha trobat el fitxer!");
        } catch (IOException ex) {
            System.out.println("Problema d'entrada i sortida!");
        }

        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        ArrayList<Enemic> enemics = new ArrayList<>();
        enemics.add(new Enemic("Llimeta", LLIM, BASE, MINIO, 1, 20, 5));
        enemics.add(new Enemic("Bandit Roig", BANDIT, FOC, NORMAL, 3, 45, 20));
        enemics.add(new Enemic("Drac Antic", DRAC, TERRA, CAP, 15, 500, 300));

        ArrayList<Objecte> objectes = new ArrayList<>();
        objectes.add(new Objecte("Poció Petita", CONSUMIBLE, COMU,
                "Cura 20 HP", 100.0, 10, 0.2));
        objectes.add(new Objecte("Espasa Rovellada", ARMA, COMU,
                "Dany +5", 65.0, 25, 3.5));
        objectes.add(new Objecte("Armadura de Ferro", ARMADURA, INFREQÜENT,
                "Defensa +12", 80.0, 120, 12.0));
        objectes.add(new Objecte("Clau Misteriosa", CLAU, RAR,
                "Obre una porta desconeguda", 100.0, 0, 0.1));

        System.out.println("=== ENEMICS MEMÒRIA ===");
        for (Enemic e : enemics) {
            System.out.println(e);
        }

        System.out.println("\n=== OBJECTES MEMÒRIA ===");
        for (Objecte o : objectes) {
            System.out.println(o);
        }

        try {
            int nombreEnemics = enemics.size();
            fitxerSortida.writeInt(nombreEnemics);
            for (Enemic e : enemics) {
                fitxerSortida.writeObject(e);
            }
            int nombreObjectes = objectes.size();
            fitxerSortida.writeInt(nombreObjectes);
            for (Objecte o : objectes) {
                fitxerSortida.writeObject(o);
            }
            fitxerSortida.close();
        } catch (IOException ex) {
            System.out.println("Error amb l'entrada i sortida a l'hora d'escriure!");
        }

        ArrayList<Enemic> llistaEnemics = new ArrayList();
        ArrayList<Objecte> llistaObjectes = new ArrayList();
        try {
            int nombreEnemics = fitxerEntrada.readInt();
            for (int i = 0; i < nombreEnemics; i++) {
                Object o = fitxerEntrada.readObject();
                llistaEnemics.add((Enemic) o);
            }
            int nombreObjectes = fitxerEntrada.readInt();
            for (int i = 0; i < nombreObjectes; i++) {
                Object o = fitxerEntrada.readObject();
                llistaObjectes.add((Objecte) o);
            }
            fitxerEntrada.close();
        } catch (IOException ex) {
            System.out.println("Error amb l'entrada i sortida al llegir!");
        } catch (ClassNotFoundException ex) {
            System.getLogger(BinaryAct1MarcMas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        System.out.println("=== ENEMICS FITXER ===");
        for (Enemic e : llistaEnemics) {
            System.out.println(e);
        }
        System.out.println("=== OBJECTES FITXER ===");
        for (Objecte o : llistaObjectes) {
            System.out.println(o);
        }
    }
}
