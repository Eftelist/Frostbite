package com.eftelist.frostbite.interfaces;

import com.eftelist.frostbite.FrostbiteCore;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public interface Registery {

    default void registerEvent(Listener listener) {
        Bukkit.getServer().getPluginManager().registerEvents(listener, FrostbiteCore.getInstance());
    }

    default void registerCommand(String command, CommandExecutor executor) {
        FrostbiteCore.getInstance().getCommand(command).setExecutor(executor);
    }
}
