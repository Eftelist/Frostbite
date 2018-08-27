package com.eftelist.frostbite.managers.player;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    private HashMap<UUID, FrostbitePlayer> players = new HashMap<>();

    public void add(Player player) {
        players.put(player.getUniqueId(), new FrostbitePlayer(player));
    }

    public void remove(Player player) {
        players.remove(player.getUniqueId());
    }

    public FrostbitePlayer getPlayer(UUID uuid) {
        return players.get(uuid);
    }

}
