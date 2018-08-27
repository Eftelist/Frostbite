package com.eftelist.frostbite.interfaces;

import com.eftelist.frostbite.enums.GameState;

public interface Game {

    String getID();

    void setup();

    void load();

    void destroy();

    GameState getState();

    GameManager getManager();
}
