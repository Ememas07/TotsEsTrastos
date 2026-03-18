/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Player;

/**
 *
 * @author Marc Mas
 */
public class Player {

    private State state = State.IDLE;
    private State prevState = State.IDLE;

    public State getState() {
        return state;
    }

    public State getPrevState() {
        return prevState;
    }

    public void handle(Input input) {
        State nouEstat = state.transition(input, prevState);
        prevState = state;
        state = nouEstat;
    }
}
