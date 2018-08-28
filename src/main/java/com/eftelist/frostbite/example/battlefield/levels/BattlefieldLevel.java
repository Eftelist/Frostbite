package com.eftelist.frostbite.example.battlefield.levels;

import com.eftelist.frostbite.FrostbiteCore;
import com.eftelist.frostbite.example.battlefield.manager.BattlefieldManager;
import com.eftelist.frostbite.interfaces.Game;
import com.eftelist.frostbite.interfaces.Level;
import com.eftelist.frostbite.objects.Duration;
import com.eftelist.frostbite.objects.GameUnit;

import java.util.ArrayList;

public class BattlefieldLevel implements Level {

    private final BattlefieldManager manager;

    public BattlefieldLevel(BattlefieldManager battlefieldManager) {
        this.manager = battlefieldManager;
    }

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
        return new Duration(GameUnit.SECOND, 5);
    }

    @Override
    public String getShortDescription() {
        return "&cBreak through the germanline #1";
    }

    @Override
    public ArrayList<String> getDescription() {
        return new ArrayList<>();
    }

    @Override
    public void tick(int currentTick) {
        if (currentTick == 0) {
            manager.getTeam("german").sendTitle("&cDefend your line #1", "", 20, 60, 20);
            manager.getTeam("english").sendTitle("&aCapture the germanline", "", 20, 60, 20);
        }
    }

    @Override
    public void reset() {

    }
}
