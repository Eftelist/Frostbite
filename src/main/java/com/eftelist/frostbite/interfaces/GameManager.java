package com.eftelist.frostbite.interfaces;

import com.eftelist.frostbite.managers.player.FrostbitePlayer;

import java.util.ArrayList;
import java.util.HashMap;

public interface GameManager {

    //Playerfunctions

    ArrayList<FrostbitePlayer> getPlayers();

    void addPlayer(FrostbitePlayer player);

    void removePlayer(FrostbitePlayer player);

    //World
    //TODO: Worldcreation?

    String getWorldName();

    // Levels

    HashMap<String, Level> getLevels();

    Level getLevel(String id);

    void addLevel(String id, Level level);

    // Teams

    HashMap<Integer, Team> getTeams();

    void addTeam(Team team);

    Team getTeam(String id);

    Team getTeamInt(int teamint);

    void sortTeams();
}
