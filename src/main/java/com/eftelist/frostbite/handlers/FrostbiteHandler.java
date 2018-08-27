package com.eftelist.frostbite.handlers;

import com.eftelist.frostbite.interfaces.Game;
import com.eftelist.frostbite.server.FrostbiteServer;

import java.util.HashMap;

public interface FrostbiteHandler {

    String getVersion();

    boolean load();

    void destroy();

    FrostbiteServer getServer();

    boolean isLoaded();

    void addGame(Game game);

    HashMap<String, Game> getGames();
}
