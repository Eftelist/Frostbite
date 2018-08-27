package com.eftelist.frostbite.handlers;

import com.eftelist.frostbite.server.FrostbiteServer;

public interface FrostbiteHandler {

    String getVersion();

    boolean load();

    void destroy();

    FrostbiteServer getServer();

    boolean isLoaded();
}
