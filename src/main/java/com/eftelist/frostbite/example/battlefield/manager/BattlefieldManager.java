package com.eftelist.frostbite.example.battlefield.manager;

import com.eftelist.frostbite.interfaces.GameManager;
import com.eftelist.frostbite.interfaces.Level;
import com.eftelist.frostbite.interfaces.Team;
import com.eftelist.frostbite.managers.player.FrostbitePlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BattlefieldManager implements GameManager {

    private ArrayList<FrostbitePlayer> players = new ArrayList<>();
    private HashMap<String, Level> levels = new HashMap<>();
    private HashMap<Integer, Team> teams = new HashMap<>();
    private Integer teamindex = 0;

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

    @Override
    public HashMap<Integer, Team> getTeams() {
        return teams;
    }

    @Override
    public void addTeam(Team team) {
        teams.put(teamindex, team);
        teamindex += 1;
    }

    @Override
    public Team getTeam(String id) {
        return teams.entrySet().stream().filter(entry -> entry.getValue().getTeamID().equalsIgnoreCase(id)).findFirst().map(Map.Entry::getValue).orElse(null);
    }

    @Override
    public Team getTeamInt(int teamint) {
        for (int i = 0; i < getTeams().keySet().size(); i++) {
            if (i == teamint) {
                return getTeams().get(i);
            }
        }
        return null;
    }

    @Override
    public void sortTeams() {
        //TODO: Recheck this function
        int size = getPlayers().size();
        int div = getTeams().size();
        int playerPerTeam = size / div;
        int teamint = 0;
        int pint = 0;
        for (int i = 0; i < playerPerTeam * div; i++) {
            if (i == playerPerTeam) {
                teamint++;
            }
            Team team = getTeamInt(teamint);
            team.addPlayer(getPlayers().get(pint));
            pint++;
        }
    }
}
