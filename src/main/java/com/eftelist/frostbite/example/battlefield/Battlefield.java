package com.eftelist.frostbite.example.battlefield;

import com.eftelist.frostbite.FrostbiteCore;
import com.eftelist.frostbite.enums.GameState;
import com.eftelist.frostbite.example.battlefield.levels.BattlefieldLevel;
import com.eftelist.frostbite.example.battlefield.manager.BattlefieldManager;
import com.eftelist.frostbite.example.battlefield.teams.BasicTeam;
import com.eftelist.frostbite.interfaces.Game;
import com.eftelist.frostbite.interfaces.GameManager;
import com.eftelist.frostbite.interfaces.Level;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class Battlefield implements Game {

    private GameState state;
    private GameManager manager;

    @Override
    public String getID() {
        return "Battlefield";
    }

    @Override
    public void setup() {
        this.state = GameState.SETUP;
        BattlefieldManager man = new BattlefieldManager();
        this.manager = man;
        Level level1 = new BattlefieldLevel(man);
        this.manager.addLevel(level1.getID(), level1);

        //add teams
        this.manager.addTeam(new BasicTeam("German"));
        this.manager.addTeam(new BasicTeam("English"));

        // load to core
        FrostbiteCore.getCurrentHandler().addGame(this);
    }

    @Override
    public void load() {
        this.state = GameState.LOADING;
        this.getManager().sortTeams();
        this.state = GameState.ENABLED;
        this.play();
    }

    @Override
    public void destroy() {
        this.state = GameState.DISABLED;
    }

    @Override
    public GameState getState() {
        return state;
    }

    @Override
    public GameManager getManager() {
        return this.manager;
    }

    @Override
    public void play() {
        this.state = GameState.IN_GAME;
        int delayInTicks = 0;

        // Gamerunnable
        for (Map.Entry<String, Level> levelEntry : getManager().getLevels().entrySet()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    new BukkitRunnable() {
                        private int currentTick;

                        @Override
                        public void run() {
                            levelEntry.getValue().tick(currentTick);
                            if (currentTick >= levelEntry.getValue().getLength().getTicks()) {
                                cancel();
                            }
                            currentTick += 1;
                        }
                    }.runTaskTimer(FrostbiteCore.getInstance(), 0, 0);
                }
            }.runTaskLater(FrostbiteCore.getInstance(), delayInTicks);
            delayInTicks += levelEntry.getValue().getLength().getTicks();
        }
    }
}
