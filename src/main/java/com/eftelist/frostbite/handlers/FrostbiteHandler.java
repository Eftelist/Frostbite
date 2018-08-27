package com.eftelist.frostbite.handlers;

public interface FrostbiteHandler {

    String getVersion();

    boolean load();

    void destroy();
}
