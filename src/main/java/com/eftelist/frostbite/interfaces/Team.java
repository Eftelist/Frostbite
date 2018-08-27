package com.eftelist.frostbite.interfaces;

import com.eftelist.frostbite.managers.player.FrostbitePlayer;

import java.util.ArrayList;

public interface Team {

    String getTeamID();

    ArrayList<FrostbitePlayer> getPlayers();

    void addPlayer(FrostbitePlayer player);

    void removePlayer(FrostbitePlayer player);
}
