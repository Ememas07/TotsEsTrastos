/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.Player;

/**
 *
 * @author Marc Mas
 */
public class OldPlayer {

    public enum State {
        IDLE,
        WALKING,
        RUNNING,
        JUMPING,
        FALLING,
        ATTACKING,
        HIT,
        DEAD,
        GUARDING,
        PARRYING,
        DOUBLE_JUMP,
    }

    public enum Input {
        WALK,
        RUN,
        JUMP,
        ATTACK,
        DAMAGE,
        DEATH,
        GROUND,
        TIME,
        PARRY,
        GUARD,
    }

    // DOUBLE JUMP
    // GUARD
    // PARRY
    // COMBO SIMPLE
    // COMBO TIMING
    public State state = State.IDLE;

    public State getState() {
        return state;
    }

    public void handle(Input input) {
        state = transition(state, input);
    }

    private State transition(State state, Input input) {
        return switch (state) {
            case IDLE ->
                TransitionFromIdle(input);
            case WALKING ->
                TransitionFromWalking(input);
            case RUNNING ->
                TransitionFromRunning(input);
            case FALLING ->
                TransitionFromFalling(input);
            case ATTACKING ->
                TransitionFromAttacking(input);
            case HIT ->
                TransitionFromHit(input);
            case DEAD ->
                State.DEAD;
            case JUMPING ->
                TransitionFromJumping(input);
            case DOUBLE_JUMP ->
                TransitionFromDoubleJump(input);
            case PARRYING ->
                TransitionFromParry(input);
            case GUARDING ->
                TransitionFromGuard(input);
        };
    }

    public State TransitionFromIdle(Input input) {
        return switch (input) {
            case WALK ->
                State.WALKING;
            case RUN ->
                State.RUNNING;
            case JUMP ->
                State.JUMPING;
            case ATTACK ->
                State.ATTACKING;
            case DAMAGE ->
                State.HIT;
            case TIME ->
                State.IDLE;
            case PARRY ->
                State.PARRYING;
            case GUARD ->
                State.GUARDING;
            default ->
                state;
        };
    }

    public State TransitionFromWalking(Input input) {
        return switch (input) {
            case RUN ->
                State.RUNNING;
            case JUMP ->
                State.JUMPING;
            case ATTACK ->
                State.ATTACKING;
            case DAMAGE ->
                State.HIT;
            case TIME ->
                State.IDLE;
            default ->
                state;
        };
    }

    public State TransitionFromRunning(Input input) {
        return switch (input) {
            case WALK ->
                State.WALKING;
            case DAMAGE ->
                State.HIT;
            case TIME ->
                State.IDLE;
            default ->
                state;
        };
    }

    public State TransitionFromFalling(Input input) {
        return switch (input) {
            case ATTACK ->
                State.ATTACKING;
            case DAMAGE ->
                State.HIT;
            case TIME ->
                State.IDLE;
            case JUMP ->
                State.DOUBLE_JUMP;
            default ->
                state;
        };
    }

    public State TransitionFromAttacking(Input input) {
        return switch (input) {
            case WALK ->
                State.WALKING;
            case DAMAGE ->
                State.HIT;
            case TIME ->
                State.IDLE;
            case JUMP ->
                State.JUMPING;
            case DEATH ->
                State.DEAD;
            default ->
                state;
        };
    }

    public State TransitionFromHit(Input input) {
        return switch (input) {
            case WALK ->
                State.WALKING;
            case TIME ->
                State.IDLE;
            case JUMP ->
                State.JUMPING;
            default ->
                state;
        };
    }

    public State TransitionFromJumping(Input input) {
        return switch (input) {
            case TIME ->
                State.FALLING;
            case JUMP ->
                State.DOUBLE_JUMP;
            case DAMAGE ->
                State.HIT;
            default ->
                state;
        };
    }

    public State TransitionFromDoubleJump(Input input) {
        return switch (input) {
            case TIME ->
                State.FALLING;
            case DAMAGE ->
                State.HIT;
            default ->
                state;
        };
    }

    public State TransitionFromParry(Input input) {
        return switch (input) {
            case WALK ->
                State.WALKING;
            case TIME ->
                State.IDLE;
            default ->
                state;
        };
    }

    public State TransitionFromGuard(Input input) {
        return switch (input) {
            case WALK ->
                State.WALKING;
            case TIME ->
                State.IDLE;
            default ->
                state;
        };
    }
}