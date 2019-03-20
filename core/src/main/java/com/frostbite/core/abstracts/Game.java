package com.frostbite.core.abstracts;

import com.frostbite.core.enums.GameState;
import com.frostbite.core.objects.GameManager;
import com.frostbite.core.objects.Lobby;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Game {

    private final String id;
    private final Lobby lobby;
    private final GameManager manager;
    private final JavaPlugin core;
    private Level currentLevel;
    private Integer levelIndex = 0;
    private GameState state;

    public Game(GameManager manager, String id, Lobby lobby) {
        this.manager = manager;
        this.id = id;
        this.lobby = lobby;
        this.core = manager.getCore();
        setup();
        state = GameState.SETTING_UP;
    }

    public void setup() {
    }

    public void boardingLoad() {
        state = GameState.LOBBYING;
    }

    public void destroy() {
        state = GameState.DISABLED;
    }

    private void stop() {
        manager.disposeElements();
        state = GameState.STOPPED;
    }

    public void play() {
        state = GameState.STARTING;
        run(0);
        new BukkitRunnable() {
            private int tick;

            @Override
            public void run() {
                if (state == GameState.STARTED) {
                    getManager().tickElements(tick);
                    tick += 1;
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(core, 0, 0);
    }

    private void run(int level) {
        state = GameState.STARTED;
        levelIndex = level;
        currentLevel = this.manager.getLevels().get(level);

        if (currentLevel != null) {


            new BukkitRunnable() {
                private int tick;
                private int max = currentLevel.getDuration().getTicks();

                @Override
                public void run() {
                    if (tick >= max) {
                        cancel();
                        Game.this.run(level + 1);
                    }
                    currentLevel.tick(tick);
                    tick += 1;
                }
            }.runTaskTimer(core, 0, 0);
        } else {
            stop();
        }
    }

    public String getId() {
        return id;
    }

    public GameManager getManager() {
        return manager;
    }

    public Integer getLevelIndex() {
        return levelIndex;
    }

    public JavaPlugin getCore() {
        return core;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }
}
