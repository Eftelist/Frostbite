package com.eftelist.frostbite.handlers.v1_12_2;

import com.eftelist.frostbite.handlers.FrostbiteHandler;

public class Handler_1_12_2 implements FrostbiteHandler {

    @Override
    public String getVersion() {
        return "1_12_2";
    }

    @Override
    public boolean load() {
        return false;
    }

    @Override
    public void destroy() {
    }
}
