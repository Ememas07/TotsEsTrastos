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

import org.yourcompany.yourproject.Cotxe.MarcaCotxe;

/**
 *
 * @author Marc Mas
 */
public class BinaryAct3MarcMas {

    public static void main(String[] args) throws java.io.UnsupportedEncodingException {

        DataOutputStream fitxerSortida = null;
        DataInputStream fitxerEntrada = null;
        try {
            fitxerSortida = new DataOutputStream(new FileOutputStream("garage.mmas"));
            fitxerEntrada = new DataInputStream(new FileInputStream("garage.mmas"));
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha trobat el fitxer!");
        }

        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        ArrayList<Cotxe> cotxes = new ArrayList<>();
        cotxes.add(new Cotxe(Cotxe.MarcaCotxe.ASTON_MARTIN, "Vantage GT3 Evo", 4.0f));
        cotxes.add(new Cotxe(Cotxe.MarcaCotxe.RENAULT, "Clio II", 1.4f));
        cotxes.add(new Cotxe(Cotxe.MarcaCotxe.DACIA, "Logan", 3.0f));

        ArrayList<Moto> motos = new ArrayList<>();
        motos.add(new Moto("0622CGP", 1.4f));
        motos.add(new Moto("3935KRR", 0.7f));
        motos.add(new Moto("0104HMS", 0.2f));

        System.out.println("=== COTXES MEMÒRIA ===");
        for (Cotxe c : cotxes) {
            System.out.println(c);
        }

        System.out.println("\n=== MOTOS MEMÒRIA ===");
        for (Moto m : motos) {
            System.out.println(m);
        }

        try {
            byte[] header = "Garatge Somiat".getBytes(StandardCharsets.UTF_8);
            fitxerSortida.writeInt(header.length);
            fitxerSortida.write(header);
            float versio = 1.0f;
            fitxerSortida.writeFloat(versio);
        } catch (IOException ex) {
            System.getLogger(BinaryAct3MarcMas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        try {

            for (Cotxe c : cotxes) {
                byte[] etiqueta = Cotxe.class.getSimpleName().getBytes(StandardCharsets.UTF_8);
                fitxerSortida.writeInt(etiqueta.length);
                fitxerSortida.write(etiqueta);

                fitxerSortida.writeInt(c.marca.ordinal());

                byte[] model = c.model.getBytes(StandardCharsets.UTF_8);
                fitxerSortida.writeInt(model.length);
                fitxerSortida.write(model);

                fitxerSortida.writeFloat(c.cilindrada);

            }
            for (Moto m : motos) {
                byte[] etiqueta = Moto.class.getSimpleName().getBytes(StandardCharsets.UTF_8);
                fitxerSortida.writeInt(etiqueta.length);
                fitxerSortida.write(etiqueta);

                byte[] matriculaMoto = m.matricula.getBytes(StandardCharsets.UTF_8); //escriu un string
                fitxerSortida.writeInt(matriculaMoto.length);
                fitxerSortida.write(matriculaMoto);
                fitxerSortida.writeFloat(m.cilindrada);

            }
            fitxerSortida.close();
        } catch (IOException ex) {
            System.out.println("Error amb l'entrada i sortida a l'hora d'escriure!");
        }
        ArrayList<Cotxe> llistaCotxes = new ArrayList();
        ArrayList<Moto> llistaMotos = new ArrayList();

        String header = "";
        float versio = 0.0f;
        try {
            header = llegirString(fitxerEntrada);
            versio = fitxerEntrada.readFloat();
            while (true) {
                int longitutEtiqueta = fitxerEntrada.readInt();
                byte[] etiquetaBytes = new byte[longitutEtiqueta];
                fitxerEntrada.readFully(etiquetaBytes);
                String etiqueta = new String(etiquetaBytes, StandardCharsets.UTF_8);
                if (etiqueta.equals(Cotxe.class.getSimpleName())) {
                    int numMarca = fitxerEntrada.readInt();
                    MarcaCotxe marca = Cotxe.MarcaCotxe.values()[numMarca];
                    String model = llegirString(fitxerEntrada);
                    Float cilindrada = fitxerEntrada.readFloat();
                    // sé que no estic llegint un string, pero els enum es llegeixen com a tal i després es guardent amb el tipus adequat
                    Cotxe c = new Cotxe(marca, model, cilindrada);
                    llistaCotxes.add(c);
                } else {
                    String matricula = llegirString(fitxerEntrada);
                    Float cilindrada = fitxerEntrada.readFloat();
                    // sé que no estic llegint un string, pero els enum es llegeixen com a tal i després es guardent amb el tipus adequat
                    Moto m = new Moto(matricula, cilindrada);
                    llistaMotos.add(m);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error amb l'entrada i sortida al llegir!");
        }
        System.out.println("Capçalera: " + header + " Versio: " + versio);
        System.out.println("=== COTXES FITXER ===");
        for (Cotxe c : llistaCotxes) {
            System.out.println(c);
        }
        System.out.println("=== MOTOS FITXER ===");
        for (Moto m : llistaMotos) {
            System.out.println(m);
        }
    }

    public static String llegirString(DataInputStream fitxer) {
        try {
            int longitut = fitxer.readInt();
            byte[] bytes = new byte[longitut];
            fitxer.readFully(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.getLogger(BinaryAct3MarcMas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return "";
        }
    }
}
