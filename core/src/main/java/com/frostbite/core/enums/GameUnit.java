package com.frostbite.core.enums;

public enum GameUnit {

    SECOND, MINUTE, HOUR;

    public int convert(int t) {
        if (getType() == SECOND) {
            return t * 20;
        }
        if (getType() == MINUTE) {
            return t * 20 * 60;
        }
        if (getType() == HOUR) {
            // TODO: Denk ik... ben moe
            return t * 20 * 60 * 60;
        }
        return t;
    }

    private GameUnit getType() {
        return this;
    }
}
