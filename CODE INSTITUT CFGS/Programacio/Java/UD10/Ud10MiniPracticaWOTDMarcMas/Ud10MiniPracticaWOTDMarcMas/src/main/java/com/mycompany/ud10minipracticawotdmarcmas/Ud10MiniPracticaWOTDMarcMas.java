/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ud10minipracticawotdmarcmas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Ud10MiniPracticaWOTDMarcMas {

    // green background, black letter 
    final static String GREEN = "\u001B[42m\u001B[30m";
    // yellow background, black letter 
    final static String YELLOW = "\u001B[43m\u001B[30m";
    // gray background, black letter 
    final static String GRAY = "\u001B[100m\u001B[30m";
    // white background, black letter (remaining attempts) 
    final static String WHITE = "\u001B[47m\u001B[30m";
    // reset to console default colors 
    final static String RESET = "\u001B[0m";

    public static void cls() {
        for (int i = 0; i < 100; i++) {
            System.out.println(""); //pintam 100 bots de linea per llevar tots
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Benvingut al joc de la paraula del dia!");
        // System.out.println("Introdueixi el seu nom d'usuari");
        // String nomUsuari = s.next();
        String nomUsuari = "marc"; // HARDCODED TEMPORALMENT, FALTA IMPLEMENTAR 
        int opcio = 0; //per el menu
        int sortir = 0; //per sortir o no del menu o tornar entrar en cas de emprar modo diari
        do {

            if (sortir == 2) { //si hem posat 2, volem tornar a entrar a mode diari
                sortir = modeBucle(nomUsuari); //tornam executar i tornam assignar a sortir
            } else { //si no es 2, hem anat al menu
                System.out.println("Introdueixi el mode de joc que vol jugar");
                System.out.println("0: Diari");
                System.out.println("1: Bucle");
                opcio = s.nextInt(); //0 es diari, 1 es bucle
                cls();
                if (opcio == 0) {
                    sortir = modeDiari(nomUsuari);
                } else if (opcio == 1) {
                    sortir = modeBucle(nomUsuari);
                }
            }
        } while ((opcio > 1 || opcio < 0) || sortir != 1); //tornarem començar si la opcio es major a 1, menor a 0, o hem seleccionat que NO volem sortir del joc (0 o 2)
    }

    public static int modeDiari(String nom) {
        LocalDateTime now = LocalDateTime.now(); //agafam data d'avui i la posam en format de l'arxiu de les paraules
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String diaAvui = year + "-" + month + "-" + day;
        boolean jugatAvui = false; 
        Scanner s; //inicialitzam scanner
        try {
            s = new Scanner(new BufferedReader(new FileReader("registre.log"))); //cercam al log, si surt el dia d'avui, assignam "true" a diaAvui
            while (s.hasNext()) {
                if (s.next().equals(diaAvui)) {
                    jugatAvui = true;
                }
            }
        } catch (FileNotFoundException ex) {
            // si falla perque no hi ha log, cream l'arxiu
            try {
                BufferedWriter fitxer = new BufferedWriter(new FileWriter("registre.log"));
            } catch (IOException e) {
                System.out.println("Problema de I/O!");
            }
        }
        if (jugatAvui == false) { //si no hem especificat que hem jugat avui, jugam
            try {
                s = new Scanner(new BufferedReader(new FileReader("daily.txt"))); //llegim l'arxiu de daily.txt i cercam 
                String paraula = "";
                while (s.hasNext() && paraula.isBlank()) { //mentres hi hagui paraules noves i no haguem assignat la paraula d'avui
                    String paraules = s.next(); //miram la proxima paraula
                    if (paraules.equals(diaAvui)) { //comprovam si es igual al dia d'avui
                        paraula = s.next(); //si ho es, assignam paraula
                    }
                } 
                s.close(); //tancam scanner
                boolean victoria = jugar(paraula, nom); //jugam
                BufferedWriter fitxer = new BufferedWriter(new FileWriter("registre.log", true)); //escrivim (amb append) al fitxer de log
                fitxer.write(diaAvui); //posam el dia d'avui
                fitxer.newLine(); //linea en blanc
                if (victoria) {
                    fitxer.write("victoria"); //victoria o derrota
                    System.out.println("Has guanyat!");
                } else {
                    fitxer.write("derrota");
                    System.out.println("Has perdut!");
                }
                fitxer.close(); //tancam l'arxiu

            } catch (FileNotFoundException ex) {
                System.out.println("L'arxiu no s'ha trobat!");
            } catch (IOException ex) {
                System.out.println("Problema de I/O!");
            }
        } else {
            System.out.println("Avui ja has jugat!");
            System.out.println("Temps fins al proxim dia:");
            System.out.println("introdueix un caracter per sortir");
            int hour = 23 - now.getHour();
            int minute = 60 - now.getMinute();
            int second = 60 - now.getSecond();
            System.out.println("Queden " + hour + " hores, " + minute + " minuts i " + second + " segons per el proxim dia");
        }
        s = new Scanner(System.in);
        System.out.println("Vol sortir del joc o tornar al menu?");
        System.out.println("0: Sortir al menu principal");
        System.out.println("1: Sortir del joc");
        return s.nextInt();
    }

    public static boolean jugar(String paraula, String nom) {
        Scanner s = new Scanner(System.in); //
        double calculation = paraula.length() * (6.0 / 5.0); //regla de 3 per intents
        int intentosTotals = (int) Math.ceil(calculation); //arrodonim per amunt
        int provades = 0;
        String output = "";
        int lletresEncertades = 0; //inicialitzam variable
        while (intentosTotals > provades) { //mentres quedin intents
            int intentsRestants = intentosTotals - provades; //calculam intents restants
            for (int i = 0; i < intentsRestants; i++) {
                System.out.println("");
                for (int j = 0; j < paraula.length(); j++) {
                    System.out.print(WHITE + "   " + RESET + " "); //imprimim cuadres blancs
                }
                System.out.println("");
            }
            System.out.println("");
            lletresEncertades = 0;
            System.out.println("Introdueixi una paraula");
            String input = s.next();
            System.out.println("");
            while (input.length() != paraula.length()) {
                System.out.println("Introdueixi una paraula de la llargaria correcta!"); //si la longitut no es correcta, mostram errors
                input = s.next(); //agafam una altra paraula
            }
            for (int i = 0; i < paraula.length(); i++) { //per cada caracter de la paraula
                int estatLletra = comprovarLletra(input.charAt(i), i, paraula); //guardam l'estat de lletra per despres pintarlo
                output += pintar(estatLletra, input.charAt(i)); //afegim a l'output
                if (estatLletra == 2) {
                    lletresEncertades++; //si l'estat es 2, hem encertat, necessari per saber si hem guanyat
                }
            }
            provades++; //sumam 1 a les vegades que hem provat
            System.out.println(output); //imprimim output 
            output += "\n\n"; //afegim dos bots de linea
            if (lletresEncertades == paraula.length()) {
                return true; //si hem encertat, retornam que hem guanat
            }
        }
        return false; //si no, despres del bucle, no hem guanyat
    }

    public static int comprovarLletra(char lletra, int posicio, String paraula) {
        if (lletra == paraula.charAt(posicio)) {
            return 2; //si la lletra esta a la posicio que pensam de la paraula, retornam 2
        }
        for (int i = 0; i < paraula.length(); i++) {
            if (lletra == paraula.charAt(i)) { //si no, si esta a la paraula original, retornam 1
                return 1;
            }
        }
        return 0; //si no, 0
    }

    public static String pintar(int estat, char lletra) {
        return switch (estat) {
            case 0 -> GRAY + " " + lletra + " " + RESET + " "; //0 = no esta
            case 1 -> YELLOW + " " + lletra + " " + RESET + " "; //1 = esta, posicio incorrecta
            case 2 -> GREEN + " " + lletra + " " + RESET + " "; //2 = esta, posicio correcta
            default -> "";
        };
    }

    public static int modeBucle(String nom) {
        try {
            Scanner s = new Scanner(new BufferedReader(new FileReader("loop.txt"))); //llegim l'arxiu de bucle 
            String paraula = s.next(); //agafam primera paraula
            BufferedWriter fitxer = new BufferedWriter(new FileWriter("loopTmp.txt")); //guardam a loopTmp
            while (s.hasNext()) { //anam llegint totes les linees de loop.txt i les escrivim a loopTmp
                fitxer.write(s.next());
                fitxer.newLine();
            }
            fitxer.write(paraula); //al final, escrivim la paraula
            fitxer.close();
            BufferedWriter fitxer2 = new BufferedWriter(new FileWriter("loop.txt", false)); //despres, re-escrivim el loop.txt a partir de loopTmp.txt
            Scanner s2 = new Scanner(new BufferedReader(new FileReader("loopTmp.txt")));
            while (s2.hasNext()) {
                fitxer2.write(s2.next());
                fitxer2.newLine();
            }
            fitxer2.close();
            s2.close();
            boolean victoria = jugar(paraula, nom);
            if (victoria) {
                System.out.println("Has guanyat!");
            } else {
                System.out.println("Has perdut!");
            }
            s.close();

        } catch (FileNotFoundException ex) {
            System.out.println("L'arxiu no s'ha trobat!");
        } catch (IOException ex) {
            System.out.println("Problema de I/O!");
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Vol sortir del joc o tornar al menu?");
        System.out.println("0: Sortir al menu principal");
        System.out.println("1: Sortir del joc");
        System.out.println("2: Tornar a jugar");
        return s.nextInt();

    }
}
