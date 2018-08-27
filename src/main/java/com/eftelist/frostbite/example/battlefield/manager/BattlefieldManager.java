package com.eftelist.frostbite.example.battlefield.manager;

import com.eftelist.frostbite.interfaces.GameManager;
import com.eftelist.frostbite.interfaces.Level;
import com.eftelist.frostbite.managers.player.FrostbitePlayer;

import java.util.ArrayList;
import java.util.HashMap;

public class BattlefieldManager implements GameManager {

    private ArrayList<FrostbitePlayer> players = new ArrayList<>();
    private HashMap<String, Level> levels = new HashMap<String, Level>();

    @Override
    public void addPlayer(FrostbitePlayer player) {
        if (!getPlayers().contains(player)) {
            getPlayers().add(player);
        }
    }

    @Override
    public void removePlayer(FrostbitePlayer player) {
        getPlayers().remove(player);
    }

    @Override
    public ArrayList<FrostbitePlayer> getPlayers() {
        return players;
    }

    @Override
    public String getWorldName() {
        return "battlefield";
    }

    @Override
    public HashMap<String, Level> getLevels() {
        return levels;
    }

    @Override
    public void addLevel(String id, Level level) {
        levels.put(id, level);
    }

    @Override
    public Level getLevel(String id) {
        return levels.get(id);
    }
}
