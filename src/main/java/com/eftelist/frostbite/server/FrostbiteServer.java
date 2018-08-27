package com.eftelist.frostbite.server;

import com.eftelist.frostbite.interfaces.Registery;
import com.eftelist.frostbite.managers.player.PlayerManager;
import com.eftelist.frostbite.server.events.PlayerListener;

public class FrostbiteServer implements Registery {

    private final PlayerManager playerManager;
    private State state;

    public FrostbiteServer() {
        this.state = State.STARTING;
        registerEvent(new PlayerListener());
        this.playerManager = new PlayerManager();
        this.state = State.ENABLED;
    }

    public State getState() {
        return this.state;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public void destroy() {
        this.state = State.DESTROYED;
    }

    public enum State {

        STARTING, ENABLED, DESTROYED
    }
}
