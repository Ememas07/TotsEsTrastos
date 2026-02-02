/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.yourcompany.yourproject;

/**
 *
 * @author alumne
 */
public class FiniteStateMachineMarcMas {

    static class Player {

        enum State {
            IDLE,
            WALKING,
            RUNNING,
            JUMPING,
            FALLING,
            ATTACKING,
            HIT,
            DEAD,
            DOUBLE_JUMP,
            PARRY,
            GUARD,
        }

        enum Input {
            WALK,
            RUN,
            JUMP,
            ATTACK,
            DAMAGE,
            DEATH,
            GROUND,
            TIME
        }

        // DOUBLE JUMP
        // GUARD
        // PARRY
        // COMBO SIMPLE
        // COMBO TIMING
        private State state = State.IDLE;

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
                case PARRY ->
                    TransitionFromParry(input);
                case GUARD ->
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
                default ->
                    state;
            };
        }

        public State TransitionFromDoubleJump(Input input) {
            return switch (input) {
                case JUMP ->
                    State.DOUBLE_JUMP;
                case TIME ->
                    State.FALLING;
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
                case ATTACK ->
                    State.GUARD;
                case TIME ->
                    State.IDLE;
                default ->
                    state;
            };
        }

        public State TransitionFromJumping(Input input) {
            return switch (input) {
                case TIME ->
                    State.FALLING;
                case DAMAGE ->
                    State.HIT;
                default ->
                    state;
            };
        }
    }

    public static void main(String[] args) {
        Player player = new Player();

        Player.Input[] script = {
            Player.Input.WALK,
            Player.Input.RUN,
            Player.Input.TIME,
            Player.Input.JUMP,
            Player.Input.TIME,
            Player.Input.ATTACK,
            Player.Input.DAMAGE,
        };

        for (Player.Input script1 : script) {
            System.out.println("Estat Anterior: "+player.state+" Input: "+script1);
            player.handle(script1);
            System.out.println("Estat despres: "+player.state);
        }
    }
}
