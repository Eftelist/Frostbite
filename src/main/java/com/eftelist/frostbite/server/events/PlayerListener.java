package com.eftelist.frostbite.server.events;

import com.eftelist.frostbite.FrostbiteCore;
import com.eftelist.frostbite.handlers.FrostbiteHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void handleJoin(PlayerJoinEvent event) {
        if (loadedHandler()) {
            getHandler().getServer().getPlayerManager().add(event.getPlayer());
        }
    }

    @EventHandler
    public void handleQuit(PlayerQuitEvent event) {
        if (loadedHandler()) {
            getHandler().getServer().getPlayerManager().remove(event.getPlayer());
        }
    }

    private FrostbiteHandler getHandler() {
        return FrostbiteCore.getCurrentHandler();
    }

    private boolean loadedHandler() {
        return FrostbiteCore.getCurrentHandler().isLoaded();
    }
}
