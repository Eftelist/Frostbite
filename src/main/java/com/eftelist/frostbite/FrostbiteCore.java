package com.eftelist.frostbite;

import org.bukkit.plugin.java.JavaPlugin;

public class FrostbiteCore extends JavaPlugin {
    
    private static FrostbiteCore instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static FrostbiteCore getInstance() {
        return instance;
    }
}
