package com.eftelist.frostbite.managers.player;

import org.bukkit.entity.Player;

import java.util.UUID;

public class FrostbitePlayer {

    private final UUID uuid;
    private final String name;

    FrostbitePlayer(Player player) {
        this.uuid = player.getUniqueId();
        this.name = player.getName();
    }

    public UUID getUniqueId() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
