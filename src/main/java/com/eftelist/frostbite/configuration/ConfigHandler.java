package com.eftelist.frostbite.configuration;

import com.eftelist.frostbite.FrostbiteCore;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigHandler {

    private final YamlConfiguration config;
    private final File file;

    public ConfigHandler(FrostbiteCore core, File config, String defaultFile) {
        if (!config.exists()) {
            config = new File(FrostbiteCore.getInstance().getDataFolder(), defaultFile);
        }
        this.file = config;
        this.config = YamlConfiguration.loadConfiguration(config);
    }

    public Object get(String key) {
        return config.get(key);
    }

    public void saveString(String key, String value) {
        config.set(key, value);
        save();
    }

    private void save() {
        try {
            this.config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveObject(String key, Object value) {
        config.set(key, value);
        save();
    }

    public void saveSerializable(String key, ConfigObject serializable) {
        config.set(key, serializable.toConfig());
        save();
    }
}
