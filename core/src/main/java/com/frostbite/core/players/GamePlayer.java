package com.frostbite.core.players;

import java.util.UUID;

public class GamePlayer {

    private final UUID uuid;

    public GamePlayer(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
