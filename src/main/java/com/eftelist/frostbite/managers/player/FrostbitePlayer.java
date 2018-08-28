package com.eftelist.frostbite.managers.player;

import com.eftelist.frostbite.FrostbiteCore;
import com.eftelist.frostbite.configuration.ConfigObject;
import com.eftelist.frostbite.interfaces.Lobby;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class FrostbitePlayer implements ConfigObject {

    private final UUID uuid;
    private final String name;
    private Lobby currentLobby;

    FrostbitePlayer(Player player) {
        this.uuid = player.getUniqueId();
        this.name = player.getName();
        this.currentLobby = null;
    }

    public UUID getUniqueId() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Lobby getCurrentLobby() {
        return currentLobby;
    }

    public void setCurrentLobby(Lobby currentLobby) {
        this.currentLobby = currentLobby;
    }

    @Override
    public String toConfig() {
        return String.valueOf(uuid.toString());
    }

    @Override
    public Object fromString(String serialized) {
        UUID ui = UUID.fromString(serialized);
        return new FrostbitePlayer(Bukkit.getPlayer(ui));
    }

    public void save() {
        FrostbiteCore.getPlayerConfig().saveSerializable(uuid.toString(), this);
    }
}
