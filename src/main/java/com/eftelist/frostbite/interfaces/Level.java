package com.eftelist.frostbite.interfaces;

import com.eftelist.frostbite.objects.Duration;

import java.util.ArrayList;

public interface Level {

    Game getGame();

    String getID();

    Duration getLength();

    String getShortDescription();

    ArrayList<String> getDescription();

    void tick(int currentTick);

    void reset();
}
