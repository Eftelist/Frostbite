package com.eftelist.frostbite.handlers.v1_12_2;

import com.eftelist.frostbite.handlers.FrostbiteHandler;
import com.eftelist.frostbite.interfaces.Game;
import com.eftelist.frostbite.server.FrostbiteServer;

import java.util.HashMap;

public class Handler_1_12_2 implements FrostbiteHandler {

    private FrostbiteServer server;
    private boolean loaded;
    private HashMap<String, Game> games = new HashMap<>();

    @Override
    public String getVersion() {
        return "1_12_2";
    }

    @Override
    public boolean load() {
        this.server = new FrostbiteServer();
        this.loaded = true;
        return true;
    }

    @Override
    public void destroy() {
        this.server.destroy();
        this.loaded = false;
    }

    @Override
    public FrostbiteServer getServer() {
        return server;
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }

    @Override
    public void addGame(Game game) {
        games.put(game.getID(), game);
    }

    @Override
    public HashMap<String, Game> getGames() {
        return games;
    }
}
