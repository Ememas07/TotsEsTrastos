/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.Scanner;

/**
 *
 * @author Marc Mas
 *
 * Partint de l'Activitat 3.10:
 *
 *
 * Orientació:
 *
 * Pinta el triangle amb la punta cap amunt.
 *
 * Pinta el triangle amb la part plana cap a la dreta.
 *
 * Pinta el triangle amb la punta cap amunt i la part plana a la dreta.
 *
 * Triangle simètric o isòsceles:
 *
 * En lloc de triangles amb un costat recte (rectangle) fes que la punta sigui
 * simètrica al mig (isòsceles).
 *
 * Pinta el triangle simètric cap amunt.
 *
 * Variants gràfiques:
 *
 * Fes que cada línia del triangle tingui un caràcter diferent (ex: *, +, -, .)
 * per simular un degradat visual.
 *
 * Permet que l'usuari triï quin caràcter vol utilitzar per dibuixar el triangle
 * (ex: *, #, @, etc.).
 *
 * Dibuixa només el contorn del triangle (sense omplir-lo), com si fos una
 * silueta.
 *
 * Menú:
 *
 * Deixa que l'usuari triï el tipus (rectangle o isòsceles), orientació del
 * triangle (esquerra, dreta, adalt, abaix) i gràfics del triangle (degradat,
 * caràcter, contorn, etc.).
 *
 *
 */
public class Ud3ActEx1MarcMas {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Programa per imprimir un triangle rectangle amb altura per pantalla");
        System.out.println("Preparacio del triangle");
        System.out.println("Tipus de triangle:");
        System.out.println("1 per triangle rectangle, 2 per triangle simetric cap avall, 3 per triangle simetric cap amunt");
        Byte tipusTriangle = s.nextByte();
        System.out.println("Variants Grafiques");
        System.out.println("1 per emprar asteriscs, 2 per emprar un degradat, 3 per emprar un caracter personalitzat, 4 per nomes el contorn");
        Byte grafics = s.nextByte();
        System.out.println("Quina altura vol?");
        Byte altura = s.nextByte(); //agafam altura per consola
        char rellenador = ' ';
        Integer buits = 0; //emprarem aquestes dues variables per saber quants de caracters hem d'imprimir de cada tipus (per els casos de alineació a la dreta)
        Integer caracters = 0;
        switch (grafics) {
            case 1 -> // asteriscs
                rellenador = '*';
            case 2 -> //degradat
                rellenador = ' ';
            case 3 -> {
                //personalitzat
                System.out.println("Quin caracter vols emprar?");
                rellenador = s.next().charAt(0);
            }
            case 4 -> //contorn (TODO)
                rellenador = '*';
            default ->
                System.out.println("Input no valid");
        }
        switch (tipusTriangle) {
            case 1 -> {
                System.out.println("Quina orientacio vols?");
                System.out.println("1 per punt cap abaix, 2 per punta cap amunt, 3 per part plana a la dreta, 4 per punta cap amunt i part plana a la dreta");
                Byte orientacio = s.nextByte();
                //rectangle amb 4 tipus
                switch (orientacio) {
                    case 1 -> {
                        // triangle rectangle estandar
                        for (int i = altura; i > 0; i--) { //bucle 1 per definir la quantiat de pixels verticals
                            switch (grafics) {
                                case 2 ->
                                    rellenador = switch (i) {
                                        case 1 ->
                                            '.';
                                        case 2 ->
                                            ':';
                                        case 3 ->
                                            '-';
                                        case 4 ->
                                            '=';
                                        case 5 ->
                                            '+';
                                        case 6 ->
                                            '*';
                                        case 7 ->
                                            '#';
                                        case 8 ->
                                            '%';
                                        case 9 ->
                                            '@';
                                        default ->
                                            '*';
                                    };
                                case 4 -> {
                                    for (int a = i; a > 0; a--) { //per pintar el contorn
                                        if (a == i || a == 1 || i == altura) { //si A == i (principi de linea) o A == 1 (final de linea) o i == altura (primera linea)
                                            System.out.print(rellenador); //pintam
                                        } else {
                                            System.out.print(" "); //pintam espai
                                        }
                                    }
                                    System.out.println("");
                                }
                                default -> {
                                    for (int a = i; a > 0; a--) { // bucle 2 per la horizontal, imprimeix en linea i agafa el valor del bucle anterior.
                                        // per exemple, si tenim i = 4, en pinta 4, despres printa el bot de linea, se li resta 1 a "i", i torna a començar fins a 0
                                        // tendrem i = 3, en pinta 3, després bot de linea, i aixi succesivament
                                        System.out.print(rellenador);
                                    }
                                    System.out.println("");
                                }
                            }
                        }
                    }
                    case 2 -> {
                        // triangle rectangle punta cap avall
                        for (int i = 0; i < altura; i++) { //bucle 1 per definir la quantiat de pixels verticals
                            switch (grafics) {
                                case 2 ->
                                    rellenador = switch (i) {
                                        case 1 ->
                                            '.';
                                        case 2 ->
                                            ':';
                                        case 3 ->
                                            '-';
                                        case 4 ->
                                            '=';
                                        case 5 ->
                                            '+';
                                        case 6 ->
                                            '*';
                                        case 7 ->
                                            '#';
                                        case 8 ->
                                            '%';
                                        case 9 ->
                                            '@';
                                        default ->
                                            '*';
                                    };
                                case 4 -> {
                                    for (int a = i; a > 0; a--) { //per pintar el contorn
                                        if (a == i || a == 1 || i == altura) { //si A == i (principi de linea) o A == 1 (final de linea) o i == altura (primera linea)
                                            System.out.print(rellenador); //pintam
                                        } else {
                                            System.out.print(" "); //pintam espai
                                        }
                                    }
                                    System.out.println("");
                                }
                                default -> {
                                    for (int a = i; a > 0; a--) { // bucle 2 per la horizontal, imprimeix en linea i agafa el valor del bucle anterior.
                                        // per exemple, si tenim i = 4, en pinta 4, despres printa el bot de linea, se li resta 1 a "i", i torna a començar fins a 0
                                        // tendrem i = 3, en pinta 3, després bot de linea, i aixi succesivament
                                        System.out.print(rellenador);
                                    }
                                    System.out.println("");
                                }
                            }
                        }
                    }
                    case 3 -> {
                        // triangle rectangle fixat a la dreta
                        for (int i = 0; i < altura; i++) { // bucle per iterar quantes vegades verticals necessitem
                            switch (grafics) {
                                case 2 ->
                                    rellenador = switch (i) {
                                        case 1 ->
                                            '.';
                                        case 2 ->
                                            ':';
                                        case 3 ->
                                            '-';
                                        case 4 ->
                                            '=';
                                        case 5 ->
                                            '+';
                                        case 6 ->
                                            '*';
                                        case 7 ->
                                            '#';
                                        case 8 ->
                                            '%';
                                        case 9 ->
                                            '@';
                                        default ->
                                            '*';
                                    };
                                case 4 -> {
                                    buits = i; //la variable de buits sera la variable "i" cada vegada
                                    caracters = altura - i; //la variable de caracters sera l'altura - 1 (ja que i va pujant i altura no canvia)
                                    //com funciona: si tenim la primera linea, tenim "10" l'altura ara mateix es 10, i volem fer 9 caracters i un buit
                                    //per lo tant, volem que les variables per la  linea siguin "9 (caracters)" i "1 (buit)"
                                    //9 caracters = l'altura menys i, ja que altura no canvia i "i" ja pujant
                                    //1 buit = la variable i, ja que comença a 0 i va pujant
                                    //un pic tenim les variables, feim un bucle que imprimirà, o un espai (per cada buit) o el caracter que volguem
                                    if (buits == 0) {
                                        System.out.print(" ");
                                        for (; buits < altura + 1; buits++) { //si es la primera linea (buits = 0), pintam asteriscs = altura +1
                                            System.out.print(rellenador);
                                        }
                                    } else {
                                        for (; buits > 0; buits--) {
                                            System.out.print(" ");
                                            if (buits == 1) { //aquest if pinta sa banda esquerra
                                                System.out.print(rellenador);
                                            }
                                        }
                                    }
                                    for (; caracters > 0; caracters--) {
                                        System.out.print(" ");
                                    }
                                    if (buits < (int) altura) {
                                        System.out.print(rellenador); //aquest pinta sa banda dreta sempre i quan no haguem fet la primera linea
                                    }
                                    System.out.println("");
                                }
                                default -> {
                                    buits = i; //la variable de buits sera la variable "i" cada vegada
                                    caracters = altura - i; //la variable de caracters sera l'altura - 1 (ja que i va pujant i altura no canvia)
                                    //com funciona: si tenim la primera linea, tenim "10" l'altura ara mateix es 10, i volem fer 9 caracters i un buit
                                    //per lo tant, volem que les variables per la  linea siguin "9 (caracters)" i "1 (buit)"
                                    //9 caracters = l'altura menys i, ja que altura no canvia i "i" ja pujant
                                    //1 buit = la variable i, ja que comença a 0 i va pujant
                                    //un pic tenim les variables, feim un bucle que imprimirà, o un espai (per cada buit) o el caracter que volguem
                                    for (; buits > 0; buits--) {
                                        System.out.print(" ");
                                    }
                                    for (; caracters > 0; caracters--) {
                                        System.out.print(rellenador);
                                    }
                                    System.out.println("");
                                }
                            }

                        }
                    }
                    case 4 -> {
                        // triangle rectangle fixat a la dreta i punta cap avall
                        for (int i = altura; i > 0; i--) { // bucle per iterar quantes vegades verticals necessitem
                            switch (grafics) {
                                case 2 ->
                                    rellenador = switch (i) {
                                        case 1 ->
                                            '.';
                                        case 2 ->
                                            ':';
                                        case 3 ->
                                            '-';
                                        case 4 ->
                                            '=';
                                        case 5 ->
                                            '+';
                                        case 6 ->
                                            '*';
                                        case 7 ->
                                            '#';
                                        case 8 ->
                                            '%';
                                        case 9 ->
                                            '@';
                                        default ->
                                            '*';
                                    };
                                case 4 -> {
                                    buits = i - 1; //la variable de buits sera la variable "i" cada vegada
                                    caracters = altura - i + 1; //la variable de caracters sera l'altura - 1 (ja que i va pujant i altura no canvia)
                                    //com funciona: si tenim la primera linea, tenim "10" l'altura ara mateix es 10, i volem fer 9 caracters i un buit
                                    //per lo tant, volem que les variables per la  linea siguin "9 (caracters)" i "1 (buit)"
                                    //9 caracters = l'altura menys i, ja que altura no canvia i "i" ja pujant
                                    //1 buit = la variable i, ja que comença a 0 i va pujant
                                    //un pic tenim les variables, feim un bucle que imprimirà, o un espai (per cada buit) o el caracter que volguem
                                    if (buits == 0) {
                                        System.out.print(" ");
                                        for (; buits < altura + 1; buits++) { //si es la primera o darrera linea (buits = 0), pintam asteriscs = altura +1
                                            System.out.print(rellenador);
                                        }
                                    } else {
                                        for (; buits > 0; buits--) {
                                            System.out.print(" ");
                                            if (buits == 1) { //aquest if pinta sa banda esquerra
                                                System.out.print(rellenador);
                                            }
                                        }
                                    }
                                    for (; caracters > 0; caracters--) {
                                        System.out.print(" ");
                                    }
                                    if (buits < (int) altura) {
                                        System.out.print(rellenador); //aquest pinta sa banda dreta sempre i quan no haguem fet la primera linea
                                    }
                                    System.out.println("");
                                }
                                default -> {
                                    buits = i - 1; //la variable de buits sera la variable "i" cada vegada
                                    caracters = altura - i + 1; //la variable de caracters sera l'altura - i +1
                                    //com funciona: si tenim la primera linea, tenim "10" l'altura ara mateix es 10, i volem fer 9 buits i una estrella
                                    //per lo tant, volem que les variables siguin "9" i "1"
                                    //9 = l'altura menys 1, pero més envant volem que vagi baixant, aixi que agafarem "i" (ja que i anira decrementant)
                                    //1 = si tenim, per exemple, 10 d'altura, i restam i (començaria a 0), però volem que sigui 1, aixi que sumarem 1
                                    //un pic tenim les variables, feim un bucle que imprimirà, o un espai (per cada buit) o el caracter que volguem
                                    for (; buits > 0; buits--) {
                                        System.out.print(" ");
                                    }
                                    for (; caracters > 0; caracters--) {
                                        System.out.print(rellenador);
                                    }
                                    System.out.println("");
                                }
                            }
                        }
                    }

                    default ->
                        System.out.println("Input no valid!");
                }
            }
            case 2 -> {
                //triangle simetric cap abaix
                Integer mitat = altura / 2;
                for (int i = altura; i > 0; i -= 2) { //bucle 1 per definir la quantiat de pixels verticals
                    if (grafics == 2) {
                        rellenador = switch (i) {
                            case 1 ->
                                '.';
                            case 2 ->
                                ':';
                            case 3 ->
                                '-';
                            case 4 ->
                                '=';
                            case 5 ->
                                '+';
                            case 6 ->
                                '*';
                            case 7 ->
                                '#';
                            case 8 ->
                                '%';
                            case 9 ->
                                '@';
                            default ->
                                '*';
                        };
                    } else if (grafics == 4) {
                        for (int b = (altura / 2 - mitat); b > 0; b--) {
                            // empram l'altura / 2 per sabre quin es el total de asteriscs que hem de pintar a cada banda a la primera fila
                            // ja que pintare en format, per exemple, 5 i 5 enlloc de nomes 10
                            // calcul la diferencia entre el principi i a quina altura esteim
                            // per exemple, si tenim 10, començara amb 5 i 5, i pintarem 10 caracters (el bucle les pinta de dos en dos)
                            // despres restarem 1, i tendrem 4 i 4, el calcul de "altura / 2 - mitat" sera 5 -4 = 1
                            // pintarem 1 espai, i despres pintarem 4 * 2 (8) asteriscs, i aixi quedara el triangle

                            System.out.print(" ");
                        }
                        System.out.print(rellenador);
                        if (mitat == altura / 2) {
                            for (int a = mitat; a > 0; a--) {
                                System.out.print(rellenador);
                                System.out.print(rellenador);
                            }
                        } else {
                            for (int a = mitat; a > 0; a--) {
                                System.out.print("  ");
                            }
                        }
                        System.out.print(rellenador);
                        System.out.println("");
                        mitat -= 1;
                    } else {
                        for (int b = (altura / 2 - mitat); b > 0; b--) {
                            // empram l'altura / 2 per sabre quin es el total de asteriscs que hem de pintar a cada banda a la primera fila
                            // ja que pintare en format, per exemple, 5 i 5 enlloc de nomes 10
                            // calcul la diferencia entre el principi i a quina altura esteim
                            // per exemple, si tenim 10, començara amb 5 i 5, i pintarem 10 caracters (el bucle les pinta de dos en dos)
                            // despres restarem 1, i tendrem 4 i 4, el calcul de "altura / 2 - mitat" sera 5 -4 = 1
                            // pintarem 1 espai, i despres pintarem 4 * 2 (8) asteriscs, i aixi quedara el triangle

                            System.out.print(" ");
                        }
                        for (int a = mitat; a > 0; a--) {
                            System.out.print(rellenador);
                            System.out.print(rellenador);
                        }
                        System.out.println("");
                        mitat -= 1;

                    }
                }
            }

            case 3 -> {
                //triangle simetric cap amunt
                Integer mitat = altura / 2;
                for (int i = altura; i > 0; i -= 2) { //bucle 1 per definir la quantiat de pixels verticals
                    if (grafics == 2) {
                        rellenador = switch (i) {
                            case 1 ->
                                '.';
                            case 2 ->
                                ':';
                            case 3 ->
                                '-';
                            case 4 ->
                                '=';
                            case 5 ->
                                '+';
                            case 6 ->
                                '*';
                            case 7 ->
                                '#';
                            case 8 ->
                                '%';
                            case 9 ->
                                '@';
                            default ->
                                '*';
                        };
                    }
                    for (int a = mitat; a > 0; a--) {
                        System.out.print(" ");
                    }
                    for (int b = (altura / 2 - mitat); b > 0; b--) {
                        // empram l'altura / 2 per sabre quin es el total de asteriscs que hem de pintar a cada banda a la primera fila
                        // ja que pintare en format, per exemple, 5 i 5 enlloc de simplement emprar 10
                        // calcul la diferencia entre el principi i a quina altura esteim
                        // per exemple, si tenim 10, començara amb 5 i 5, i pintarem 10 caracters (el bucle les pinta de dos en dos)
                        // despres restarem 1, i tendrem 4 i 4, el calcul de "altura / 2 - mitat" sera 5 -4 = 1
                        // pintarem 1 espai, i despres pintarem 4 * 2 (8) asteriscs, i aixi quedara el triangle

                        // la logica per el triangle cap amunt es igual, pero giram els asteriscs i els espais de bucle, es a dir,
                        // ara el bucle "a" imprimeix espais i el bucle "b" imprimeix asteriscs
                        System.out.print(rellenador);
                        System.out.print(rellenador);
                    }
                    System.out.println("");
                    mitat -= 1;
                }
            }
            default ->
                System.out.println("Input no valid!");
        }

    }
}
