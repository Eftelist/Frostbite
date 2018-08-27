package com.eftelist.frostbite.example.battlefield;

import com.eftelist.frostbite.FrostbiteCore;
import com.eftelist.frostbite.enums.GameState;
import com.eftelist.frostbite.example.battlefield.levels.BattlefieldLevel;
import com.eftelist.frostbite.example.battlefield.manager.BattlefieldManager;
import com.eftelist.frostbite.interfaces.Game;
import com.eftelist.frostbite.interfaces.GameManager;
import com.eftelist.frostbite.interfaces.Level;

public class Battlefield implements Game {

    private GameState state;
    private GameManager manager;

    @Override
    public String getID() {
        return "Battlefield";
    }

    @Override
    public void setup() {
        this.state = GameState.SETUP;
        this.manager = new BattlefieldManager();
        Level level1 = new BattlefieldLevel();
        this.manager.addLevel(level1.getID(), level1);
        // load to core
        FrostbiteCore.getCurrentHandler().addGame(this);
    }

    @Override
    public void load() {
        this.state = GameState.LOADING;
    }

    @Override
    public void destroy() {
        this.state = GameState.DISABLED;
    }

    @Override
    public GameState getState() {
        return state;
    }

    @Override
    public GameManager getManager() {
        return this.manager;
    }

    @Override
    public void play() {
        // TODO: Gametickable hier
    }
}
