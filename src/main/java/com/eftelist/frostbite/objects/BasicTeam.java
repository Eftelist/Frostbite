package com.eftelist.frostbite.objects;

import com.eftelist.frostbite.interfaces.Team;
import com.eftelist.frostbite.managers.player.FrostbitePlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.util.ArrayList;

public class BasicTeam implements Team {

    private final String id;
    private ArrayList<FrostbitePlayer> players = new ArrayList<>();

    public BasicTeam(String id) {
        this.id = id;
    }

    @Override
    public String getTeamID() {
        return id;
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

    @Override
    public ArrayList<FrostbitePlayer> getPlayers() {
        return players;
    }

    @Override
    public void sendTitle(String message, String subtitle, int fadein, int stay, int fadeout) {
        for (FrostbitePlayer player : players) {
            if (Bukkit.getOfflinePlayer(player.getUniqueId()).isOnline()) {
                Bukkit.getPlayer(player.getUniqueId()).sendTitle(ChatColor.translateAlternateColorCodes('&', message), subtitle, fadein, stay, fadeout);
            }
        }
    }
}
