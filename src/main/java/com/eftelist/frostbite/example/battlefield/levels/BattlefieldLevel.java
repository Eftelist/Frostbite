package com.eftelist.frostbite.example.battlefield.levels;

import com.eftelist.frostbite.FrostbiteCore;
import com.eftelist.frostbite.interfaces.Game;
import com.eftelist.frostbite.interfaces.Level;
import com.eftelist.frostbite.objects.Duration;
import com.eftelist.frostbite.objects.GameUnit;

public class BattlefieldLevel implements Level {

    @Override
    public Game getGame() {
        return FrostbiteCore.getCurrentHandler().getGames().get("Battlefield");
    }

    @Override
    public String getID() {
        return "level1";
    }

    @Override
    public Duration getLength() {
        return new Duration(GameUnit.SECOND, 1);
    }
}
