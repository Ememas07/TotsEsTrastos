/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.Player;

/**
 *
 * @author Marc Mas
 */
public enum State {
    IDLE {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case RUN ->
                    RUNNING;
                case JUMP ->
                    JUMPING;
                case ATTACK ->
                    ATTACK0;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    IDLE;
                case GUARD ->
                    GUARDING;
                case DODGE ->
                    DODGE;
                default ->
                    this;
            };
        }
    },
    WALKING {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case RUN ->
                    RUNNING;
                case JUMP ->
                    JUMPING;
                case ATTACK ->
                    ATTACK0;
                case DAMAGE ->
                    HIT;
                case GUARD ->
                    GUARDING;
                case DODGE ->
                    DODGE;
                case TIME ->
                    IDLE;
                default ->
                    this;
            };
        }
    },
    RUNNING {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    IDLE;
                default ->
                    this;
            };
        }
    },
    FALLING {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case ATTACK ->
                    ATTACK0;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    IDLE;
                case JUMP ->
                    DOUBLE_JUMP;
                default ->
                    this;
            };
        }
    },
    HIT {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case TIME ->
                    IDLE;
                case JUMP ->
                    JUMPING;
                default ->
                    this;
            };
        }
    },
    JUMPING {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case TIME ->
                    FALLING;
                case JUMP ->
                    DOUBLE_JUMP;
                case DAMAGE ->
                    HIT;
                default ->
                    this;
            };
        }
    },
    DOUBLE_JUMP {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case TIME ->
                    FALLING;
                case DAMAGE ->
                    HIT;
                default ->
                    this;
            };
        }
    },
    PARRYING {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case TIME, DAMAGE ->
                    IDLE;
                case WALK ->
                    WALKING;
                case JUMP ->
                    JUMPING;
                case ATTACK ->
                    COUNTER_ATTACK;
                default ->
                    this;
            };
        }
    },
    COUNTER_ATTACK {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case DAMAGE ->
                    HIT;
                case TIME ->
                    IDLE;
                case ATTACK ->
                    ATTACK0;
                default ->
                    this;
            };
        }
    },
    GUARDING {
        @Override
        public State transition(Input input, State prevState) {
            if (prevState != GUARDING && input == Input.DAMAGE) {
                return PARRYING;
            }
            return switch (input) {
                case TIME, DAMAGE ->
                    IDLE;
                case WALK ->
                    WALKING;
                case JUMP ->
                    JUMPING;
                case ATTACK ->
                    ATTACK0;
                default ->
                    this;
            };
        }
    },
    DODGE {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case TIME, DAMAGE ->
                    IDLE;
                case WALK ->
                    WALKING;
                case JUMP ->
                    JUMPING;
                case ATTACK ->
                    ATTACK0;
                default ->
                    this;
            };
        }
    },
    ATTACK0 {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    TIMED_COMBO;
                case JUMP ->
                    JUMPING;
                case DEATH ->
                    DEAD;
                case ATTACK ->
                    ATTACK01;
                default ->
                    this;
            };
        }
    },
    ATTACK10 {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    IDLE;
                case JUMP ->
                    JUMPING;
                case DEATH ->
                    DEAD;
                case ATTACK ->
                    IDLE;
                default ->
                    this;
            };
        }
    },
    ATTACK01 {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    TIMED_COMBO;
                case JUMP ->
                    JUMPING;
                case DEATH ->
                    DEAD;
                case ATTACK ->
                    ATTACK02;
                default ->
                    this;
            };
        }
    },
    ATTACK11 {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    TIMED_COMBO;
                case JUMP ->
                    JUMPING;
                case DEATH ->
                    DEAD;
                case ATTACK ->
                    ATTACK02;
                default ->
                    this;
            };
        }
    },
    ATTACK02 {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    TIMED_COMBO;
                case JUMP ->
                    JUMPING;
                case DEATH ->
                    DEAD;
                default ->
                    this;
            };
        }
    },
    ATTACK12 {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                case WALK ->
                    WALKING;
                case DAMAGE ->
                    HIT;
                case TIME ->
                    IDLE;
                case JUMP ->
                    JUMPING;
                case DEATH ->
                    DEAD;
                default ->
                    this;
            };
        }
    },
    TIMED_COMBO {
        @Override
        public State transition(Input input, State prevState) {
            if (prevState == ATTACK0) {
                return switch (input) {
                    case ATTACK ->
                        ATTACK10;
                    case TIME ->
                        IDLE;
                    default ->
                        this;
                };
            }
            if (prevState == ATTACK01) {
                return switch (input) {
                    case ATTACK ->
                        ATTACK11;
                    case TIME ->
                        IDLE;
                    default ->
                        this;
                };
            }
            if (prevState == ATTACK11) {
                return switch (input) {
                    case ATTACK ->
                        ATTACK12;
                    case TIME ->
                        IDLE;
                    default ->
                        this;
                };
            }
            if (prevState == ATTACK02) {
                System.out.println("Entr dins loop");
                return switch (input) {
                    case ATTACK ->
                        ATTACK12;
                    case TIME ->
                        ATTACK01;
                    default ->
                        this;
                };
            }
            return switch (input) {
                case TIME ->
                    IDLE;
                default ->
                    this;
            };
        }
    },
    DEAD {
        @Override
        public State transition(Input input, State prevState) {
            return switch (input) {
                default ->
                    this;
            };
        }
    };

    public abstract State transition(Input input, State prevState);
}
