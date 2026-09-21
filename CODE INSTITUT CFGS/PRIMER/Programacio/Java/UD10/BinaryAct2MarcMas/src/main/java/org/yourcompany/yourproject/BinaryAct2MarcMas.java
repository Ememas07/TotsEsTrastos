/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.yourcompany.yourproject.Enemic.RangEnemic;
import static org.yourcompany.yourproject.Enemic.RangEnemic.CAP;
import static org.yourcompany.yourproject.Enemic.RangEnemic.MINIO;
import static org.yourcompany.yourproject.Enemic.RangEnemic.NORMAL;
import org.yourcompany.yourproject.Enemic.TipusEnemic;
import static org.yourcompany.yourproject.Enemic.TipusEnemic.BANDIT;
import static org.yourcompany.yourproject.Enemic.TipusEnemic.DRAC;
import static org.yourcompany.yourproject.Enemic.TipusEnemic.LLIM;
import org.yourcompany.yourproject.Enemic.VariantEnemic;
import static org.yourcompany.yourproject.Enemic.VariantEnemic.BASE;
import static org.yourcompany.yourproject.Enemic.VariantEnemic.FOC;
import static org.yourcompany.yourproject.Enemic.VariantEnemic.TERRA;
import org.yourcompany.yourproject.Objecte.RaresaObjecte;
import static org.yourcompany.yourproject.Objecte.RaresaObjecte.COMU;
import static org.yourcompany.yourproject.Objecte.RaresaObjecte.INFREQÜENT;
import static org.yourcompany.yourproject.Objecte.RaresaObjecte.RAR;
import org.yourcompany.yourproject.Objecte.TipusObjecte;
import static org.yourcompany.yourproject.Objecte.TipusObjecte.ARMA;
import static org.yourcompany.yourproject.Objecte.TipusObjecte.ARMADURA;
import static org.yourcompany.yourproject.Objecte.TipusObjecte.CLAU;
import static org.yourcompany.yourproject.Objecte.TipusObjecte.CONSUMIBLE;

/**
 *
 * @author Marc Mas
 */
public class BinaryAct2MarcMas {

    public static void main(String[] args) throws java.io.UnsupportedEncodingException {

        DataOutputStream fitxerSortida = null;
        DataInputStream fitxerEntrada = null;
        try {
            fitxerSortida = new DataOutputStream(new FileOutputStream("fitxer.mmas"));
            fitxerEntrada = new DataInputStream(new FileInputStream("fitxer.mmas"));
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha trobat el fitxer!");
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
            for (Enemic e : enemics) {
                byte[] etiqueta = Enemic.class.getName().getBytes(StandardCharsets.UTF_8);
                fitxerSortida.writeInt(etiqueta.length);
                fitxerSortida.write(etiqueta);

                byte[] nomEnemic = e.getNom().getBytes(StandardCharsets.UTF_8); //escriu un string
                fitxerSortida.writeInt(nomEnemic.length);
                fitxerSortida.write(nomEnemic);

                byte[] tipusEnemic = e.getTipus().name().getBytes(StandardCharsets.UTF_8); // escriu un enum
                fitxerSortida.writeInt(tipusEnemic.length);
                fitxerSortida.write(tipusEnemic);

                byte[] variantEnemic = e.getVariant().name().getBytes(StandardCharsets.UTF_8);
                fitxerSortida.writeInt(variantEnemic.length);
                fitxerSortida.write(variantEnemic);

                byte[] rangEnemic = e.getRang().name().getBytes(StandardCharsets.UTF_8);
                fitxerSortida.writeInt(rangEnemic.length);
                fitxerSortida.write(rangEnemic);

                fitxerSortida.writeInt(e.getNivell());
                fitxerSortida.writeInt(e.getHpBase());
                fitxerSortida.writeInt(e.getXpBase());

            }
            for (Objecte o : objectes) {
                byte[] etiqueta = Objecte.class.getName().getBytes(StandardCharsets.UTF_8);
                fitxerSortida.writeInt(etiqueta.length);
                fitxerSortida.write(etiqueta);

                byte[] nomObjecte = o.getNom().getBytes(StandardCharsets.UTF_8); //escriu un string
                fitxerSortida.writeInt(nomObjecte.length);
                fitxerSortida.write(nomObjecte);

                byte[] tipusObjecte = o.getTipus().name().getBytes(StandardCharsets.UTF_8); // escriu un enum
                fitxerSortida.writeInt(tipusObjecte.length);
                fitxerSortida.write(tipusObjecte);

                byte[] raresaObjecte = o.getRaresa().name().getBytes(StandardCharsets.UTF_8);
                fitxerSortida.writeInt(raresaObjecte.length);
                fitxerSortida.write(raresaObjecte);

                byte[] efecteObjecte = o.getEfecte().getBytes(StandardCharsets.UTF_8); //escriu un string
                fitxerSortida.writeInt(efecteObjecte.length);
                fitxerSortida.write(efecteObjecte);

                fitxerSortida.writeDouble(o.getDurabilitat());
                fitxerSortida.writeInt(o.getValorBase());
                fitxerSortida.writeDouble(o.getPesBase());
            }
            fitxerSortida.close();
        } catch (IOException ex) {
            System.out.println("Error amb l'entrada i sortida a l'hora d'escriure!");
        }

        ArrayList<Enemic> llistaEnemics = new ArrayList();
        ArrayList<Objecte> llistaObjectes = new ArrayList();

        try {
            while (true) {
                int longitutEtiqueta = fitxerEntrada.readInt();
                byte[] etiquetaBytes = new byte[longitutEtiqueta];
                fitxerEntrada.readFully(etiquetaBytes);
                String etiqueta = new String(etiquetaBytes, StandardCharsets.UTF_8);
                if (etiqueta.equals(Enemic.class.getName())) {
                    String nom = llegirString(fitxerEntrada);
                    // sé que no estic llegint un string, pero els enum es llegeixen com a tal i després es guardent amb el tipus adequat
                    TipusEnemic tipus = Enemic.TipusEnemic.valueOf(llegirString(fitxerEntrada));
                    VariantEnemic variant = Enemic.VariantEnemic.valueOf(llegirString(fitxerEntrada));
                    RangEnemic rang = Enemic.RangEnemic.valueOf(llegirString(fitxerEntrada));
                    int nivell = fitxerEntrada.readInt();
                    int hpBase = fitxerEntrada.readInt();
                    int xpBase = fitxerEntrada.readInt();
                    Enemic e = new Enemic(nom, tipus, variant, rang, nivell, hpBase, xpBase);
                    llistaEnemics.add(e);
                } else {
                    String nom = llegirString(fitxerEntrada);
                    // sé que no estic llegint un string, pero els enum es llegeixen com a tal i després es guardent amb el tipus adequat
                    TipusObjecte tipus = Objecte.TipusObjecte.valueOf(llegirString(fitxerEntrada));
                    RaresaObjecte variant = Objecte.RaresaObjecte.valueOf(llegirString(fitxerEntrada));
                    String efecte = llegirString(fitxerEntrada);
                    double durabilitat = fitxerEntrada.readDouble();
                    int valorBase = fitxerEntrada.readInt();
                    double pesBase = fitxerEntrada.readDouble();
                    Objecte o = new Objecte(nom, tipus, variant, efecte, durabilitat, valorBase, pesBase);
                    llistaObjectes.add(o);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error amb l'entrada i sortida al llegir!");
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

    public static String llegirString(DataInputStream fitxer) {
        try {
            int longitut = fitxer.readInt();
            byte[] bytes = new byte[longitut];
            fitxer.readFully(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.getLogger(BinaryAct2MarcMas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return "";
        }
    }
}
