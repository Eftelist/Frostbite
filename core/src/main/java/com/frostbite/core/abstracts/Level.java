package com.frostbite.core.abstracts;

import com.frostbite.core.objects.Duration;

public class Level {

    private final Game game;
    private final String id;
    private final Duration duration;

    public Level(Game game, String id, Duration duration) {
        this.game = game;
        this.id = id;
        this.duration = duration;
    }

    public Game getGame() {
        return game;
    }

    public String getId() {
        return id;
    }

    public Duration getDuration() {
        return duration;
    }

    public void tick(int v) {
    }

    public void dispose() {
    }
}
