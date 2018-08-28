package com.eftelist.frostbite.example.battlefield;

import com.eftelist.frostbite.interfaces.Game;
import com.eftelist.frostbite.interfaces.Lobby;
import com.eftelist.frostbite.managers.player.FrostbitePlayer;

import java.util.ArrayList;

public class BattlefieldLobby implements Lobby {

    private Game game;
    private ArrayList<FrostbitePlayer> players = new ArrayList<>();

    public BattlefieldLobby(Game game) {
        setGame(game);
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public ArrayList<FrostbitePlayer> getPlayers() {
        return players;
    }

    @Override
    public void addPlayer(FrostbitePlayer player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    @Override
    public void removePlayer(FrostbitePlayer player) {
        players.remove(player);
    }
}
