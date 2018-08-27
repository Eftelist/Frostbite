package com.eftelist.frostbite.objects;

public class Duration {

    private final GameUnit unit;
    private final int t;

    public Duration(GameUnit unit, int t) {
        this.unit = unit;
        this.t = t;
    }

    public GameUnit getUnit() {
        return unit;
    }

    public int getT() {
        return t;
    }

    public int getTicks() {
        return getUnit().convert(t);
    }
}
