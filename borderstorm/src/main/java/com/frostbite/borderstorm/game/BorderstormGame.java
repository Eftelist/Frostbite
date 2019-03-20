package com.frostbite.borderstorm.game;

import com.frostbite.borderstorm.objects.BorderstormBorder;
import com.frostbite.core.abstracts.Game;
import com.frostbite.core.objects.GameManager;
import com.frostbite.core.objects.Lobby;
import org.bukkit.Bukkit;

public class BorderstormGame extends Game {

    public BorderstormGame(GameManager manager, Lobby lobby, int gameId) {
        super(manager, "borderstorm-" + gameId, lobby);
    }

    @Override
    public void setup() {
        getManager().addElement(new BorderstormBorder(Bukkit.getWorld("borderstorm"), 0, 0, 0));
    }
}
