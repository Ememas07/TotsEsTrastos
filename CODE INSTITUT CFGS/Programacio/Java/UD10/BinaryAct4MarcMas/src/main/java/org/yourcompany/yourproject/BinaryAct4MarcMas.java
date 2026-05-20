/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author Marc Mas
 */
public class BinaryAct4MarcMas {

    public static void main(String[] args) throws java.io.UnsupportedEncodingException {

        DataInputStream fitxerEntrada = null;
        try {
            fitxerEntrada = new DataInputStream(new FileInputStream("dades_propi.gfv"));
        } catch (FileNotFoundException ex) {
            System.out.println("No s'ha trobat el fitxer!");
        }

        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        ArrayList<Vehicle> llista = new ArrayList();

        String header = "";
        int versio = 0;
        int numVehicles = 0;
        try {
            byte[] etiquetaBytes = new byte[4];
            fitxerEntrada.readFully(etiquetaBytes);
            header = new String(etiquetaBytes, StandardCharsets.UTF_8);
            versio = fitxerEntrada.readInt();
            numVehicles = fitxerEntrada.readInt();
            for (int i = 0; i < numVehicles; i++) {
                String nomVehicle = llegirString(fitxerEntrada);
                System.out.println(nomVehicle);
                int numTipus = fitxerEntrada.readInt();
                Vehicle.TipusVehicle tipus = Vehicle.TipusVehicle.values()[numTipus];
                int numFaccio = fitxerEntrada.readInt();
                Vehicle.FaccioVehicle faccio = Vehicle.FaccioVehicle.values()[numFaccio];
                int blindatge = fitxerEntrada.readInt();
                Double velocitat = fitxerEntrada.readDouble();
                Vehicle v = new Vehicle(nomVehicle, tipus, faccio, blindatge, velocitat);
                llista.add(v);
            }
        } catch (IOException ex) {
            System.out.println("Error amb l'entrada i sortida al llegir!");
        }

        System.out.println(
                "Capçalera: " + header + " Versio: " + versio);
        System.out.println(
                "=== Contingut FITXER ===");
        for (Vehicle v : llista) {
            System.out.println(v);
        }
    }

    public static String llegirString(DataInputStream fitxer) {
        try {
            int longitut = fitxer.readInt();
            byte[] bytes = new byte[longitut];
            fitxer.readFully(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.getLogger(BinaryAct4MarcMas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return "";
        }
    }
}
