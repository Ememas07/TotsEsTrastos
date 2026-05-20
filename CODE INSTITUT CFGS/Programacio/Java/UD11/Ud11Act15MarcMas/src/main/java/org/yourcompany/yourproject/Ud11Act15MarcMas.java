/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Amb la classe Jugador que hi ha a Google Classroom, fes el mapa que té com a
 * clau un String amb el nom del jugador i com a valor un objecte Jugador.
 * Mostra els següents jugadors, i després deixa el mapa només amb els jugadors
 * el nombre dels quals sigui parell:
 *
 * jugadors.put("Casillas", new Jugador(1, "Casillas", "Portero"))
 * jugadors.put("Ramos", new Jugador(15, "Ramos", "Lateral Derecho"))
 * jugadors.put("Pique", new Jugador(13, "Pique", "Central"))
 * jugadors.put("Puyol", new Jugador(5, "Puyol", "Central"))
 * jugadors.put("Capdevila", new Jugador(11, "Capdevila", "Lateral Izquierdo"))
 * jugadors.put("Xabi", new Jugador(14, "Xabi Alonso", "Medio Centro"))
 * jugadors.put("Busquets", new Jugador(16, "Busquets", "Medio Centro"))
 * jugadors.put("Xavi", new Jugador(8, "Xavi Hernandez", "Centro Campista"))
 * jugadors.put("Pedrito", new Jugador(18, "Pedrito", "Interior Izquierdo"))
 * jugadors.put("Iniesta", new Jugador(6, "Iniesta", "Interior Derecho"))
 * jugadors.put("Villa", new Jugador(7, "Villa", "Delantero"));
 *
 * @author Marc Mas
 */
public class Ud11Act15MarcMas {

    public static void main(String[] args) {
        Map<String, Jugador> jugadors = new HashMap<>();
        jugadors.put("Casillas", new Jugador(1, "Casillas", "Portero"));
        jugadors.put("Ramos", new Jugador(15, "Ramos", "Lateral Derecho"));
        jugadors.put("Pique", new Jugador(13, "Pique", "Central"));
        jugadors.put("Puyol", new Jugador(5, "Puyol", "Central"));
        jugadors.put("Capdevila", new Jugador(11, "Capdevila", "Lateral Izquierdo"));
        jugadors.put("Xabi", new Jugador(14, "Xabi Alonso", "Medio Centro"));
        jugadors.put("Busquets", new Jugador(16, "Busquets", "Medio Centro"));
        jugadors.put("Xavi", new Jugador(8, "Xavi Hernandez", "Centro Campista"));
        jugadors.put("Pedrito", new Jugador(18, "Pedrito", "Interior Izquierdo"));
        jugadors.put("Iniesta", new Jugador(6, "Iniesta", "Interior Derecho"));
        jugadors.put("Villa", new Jugador(7, "Villa", "Delantero"));
        System.out.println("Mapa sencer:");
        System.out.println(jugadors.toString());
        Set<Map.Entry<String, Jugador>> set = jugadors.entrySet(); //agafam un set amb totes les entrades
        Iterator<Map.Entry<String, Jugador>> it; //cream un iterador
        for (it = set.iterator(); it.hasNext();) { //iniciam un iterador amb el set, i feim el bucle mentres hi hagui entrades seguents
            Entry<String, Jugador> entrada = it.next(); //agafam l'entrada del mapa
            Jugador j = entrada.getValue(); //agafam el jugador de l'entrada
            if(j.getDorsal() % 2 == 1){ //si el dorsal no es parell, el llevam
                it.remove();
            }
        }
        System.out.println("Mapa amb nomes jugadors amb dorsal parell:");
        System.out.println(jugadors.toString());
    }
}