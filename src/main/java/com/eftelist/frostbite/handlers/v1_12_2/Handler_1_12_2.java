package com.eftelist.frostbite.handlers.v1_12_2;

import com.eftelist.frostbite.handlers.FrostbiteHandler;
import com.eftelist.frostbite.server.FrostbiteServer;

public class Handler_1_12_2 implements FrostbiteHandler {

    private FrostbiteServer server;
    private boolean loaded;

    @Override
    public String getVersion() {
        return "1_12_2";
    }

    @Override
    public boolean load() {
        this.server = new FrostbiteServer();
        if (this.server.getState() == FrostbiteServer.State.STARTING) {
            this.loaded = true;
            return true;
        } else {
            this.loaded = false;
            return false;
        }
    }

    @Override
    public void destroy() {
        this.server.destroy();
        this.loaded = false;
    }

    @Override
    public FrostbiteServer getServer() {
        return server;
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }
}
