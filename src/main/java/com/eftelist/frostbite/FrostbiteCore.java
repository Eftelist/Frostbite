package com.eftelist.frostbite;

import com.eftelist.frostbite.configuration.ConfigHandler;
import com.eftelist.frostbite.handlers.FrostbiteHandler;
import com.eftelist.frostbite.handlers.v1_12_2.Handler_1_12_2;
import com.eftelist.frostbite.utils.ErrorUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class FrostbiteCore extends JavaPlugin {
    
    private static FrostbiteCore instance;
    private static FrostbiteHandler currentHandler;
    private static ConfigHandler config, player;

    @Override
    public void onEnable() {
        instance = this;
        setupHandler();
        setupConfig();
    }

    private void setupConfig() {
        try {
            player = new ConfigHandler(this, new File(this.getDataFolder(), "players.yml"), "players.yml");
            config = new ConfigHandler(this, new File(this.getDataFolder(), "config.yml"), "config.yml");
        } catch (Exception e) {
            ErrorUtil.print(e);
        }
    }

    private void setupHandler() {
        String server_version = "Unknown";
        try {
            server_version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        } catch (Exception e) {
            ErrorUtil.print(e);
        }
        getLogger().info("Your server is running version " + server_version);
        if (server_version.equals("v1_12_R1")) {
            currentHandler = new Handler_1_12_2();
            currentHandler.load();
        } else {
            getLogger().info("Unsupported version found!");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        currentHandler.destroy();
        instance = null;
    }

    public static FrostbiteCore getInstance() {
        return instance;
    }

    public static FrostbiteHandler getCurrentHandler() {
        return currentHandler;
    }

    public static ConfigHandler getConfigHandler() {
        return config;
    }

    public static ConfigHandler getPlayerConfig() {
        return player;
    }
}
