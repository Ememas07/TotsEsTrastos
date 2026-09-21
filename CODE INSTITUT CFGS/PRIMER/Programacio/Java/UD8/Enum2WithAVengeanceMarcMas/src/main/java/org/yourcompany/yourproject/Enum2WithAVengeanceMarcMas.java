/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

import org.Player.Input;
import org.Player.Player;

/**
 *
 * @author Marc Mas
 */
public class Enum2WithAVengeanceMarcMas {

    public static void main(String[] args) {
        Player player = new Player();

        Input[] script = {
            Input.WALK,
            Input.RUN,
            Input.TIME,
            Input.JUMP,
            Input.TIME,
            Input.JUMP,
            Input.TIME,
            Input.ATTACK,
            Input.JUMP,
            Input.TIME,
            Input.JUMP,
            Input.DAMAGE,
            Input.TIME,
            Input.TIME,
            Input.TIME
        };

        for (Input script1 : script) {
            System.out.println("Estat Anterior: " + player.getState() + " Input: " + script1);
            player.handle(script1);
            System.out.println("Estat despres: " + player.getState());
        }
        System.out.println("Combos!");

        Input[] combos = {
            Input.ATTACK,
            Input.ATTACK,
            Input.ATTACK,
            Input.TIME,
            Input.TIME,
            Input.TIME,
            Input.ATTACK,
            Input.ATTACK,
            Input.TIME,
            Input.TIME,
            Input.TIME,
            Input.ATTACK,
            Input.TIME,
            Input.ATTACK,
            Input.TIME,
            Input.TIME,
            Input.TIME,
            Input.TIME,
            Input.TIME,
            Input.ATTACK,
            Input.TIME,
            Input.ATTACK,
            Input.TIME,
            Input.ATTACK,
            Input.ATTACK,
            Input.TIME,
            Input.ATTACK,
            Input.ATTACK
        };
        for (Input script1 : combos) {
            System.out.print("Estat Anterior: " + player.getState() + " Input: " + script1);
            player.handle(script1);
            System.out.println("Estat despres: " + player.getPrevState());
        }
    }
}
