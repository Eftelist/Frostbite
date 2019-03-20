package com.frostbite.core.objects;

import com.frostbite.core.abstracts.Level;
import com.frostbite.core.abstracts.Team;
import com.frostbite.core.interfaces.GameElement;
import com.frostbite.core.players.GamePlayer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class GameManager {

    private final JavaPlugin core;
    private ArrayList<GamePlayer> players = new ArrayList<>();
    private ArrayList<GameElement> elements = new ArrayList<>();
    private HashMap<Integer, Level> levels = new HashMap<>();
    private HashMap<String, Team> teams = new HashMap<>();

    public GameManager(JavaPlugin core) {
        this.core = core;
    }

    public ArrayList<GameElement> getElements() {
        return elements;
    }

    public void addElement(GameElement element) {
        elements.add(element);
        element.onInit();
    }

    public void tickElements(int tick) {
        elements.forEach(element -> element.onUpdate(tick));
    }

    public void disposeElements() {
        elements.forEach(GameElement::onDispose);
    }

    public ArrayList<GamePlayer> getPlayers() {
        return players;
    }

    public void addPlayer(GamePlayer player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public void removePlayer(GamePlayer player) {
        players.remove(player);
    }

    public HashMap<Integer, Level> getLevels() {
        return levels;
    }

    public Level getLevel(Integer id) {
        return levels.get(id);
    }

    public void addLevel(Integer id, Level level) {
        levels.put(id, level);
    }

    public HashMap<String, Team> getTeams() {
        return teams;
    }

    public void addTeam(String id, Team team) {
        teams.put(id, team);
    }

    public Team getTeam(String id) {
        return teams.get(id);
    }

    public JavaPlugin getCore() {
        return core;
    }
}
