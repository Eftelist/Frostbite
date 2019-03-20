package com.frostbite.borderstorm.objects;

import com.frostbite.core.interfaces.GameElement;
import org.bukkit.Location;
import org.bukkit.World;

public class BorderstormBorder implements GameElement {

    private final static double BORDER_RADIUS = 200.0;
    private final static double BORDER_STEP = 0.01;

    private final World world;
    private final Location center;

    private double radius;
    private int tickPerSecond;

    public BorderstormBorder(World world, double x, double y, double z) {
        this.world = world;
        this.center = new Location(world, x + 0.5, y, z + 0.5);
    }

    @Override
    public void onUpdate(int tick) {
        world.getWorldBorder().setSize(radius);
        tickPerSecond += 1;
        if (tickPerSecond >= 20) {
            tickPerSecond = 0;
            radius -= BORDER_STEP;
        }
    }

    @Override
    public void onInit() {
        world.getWorldBorder().setCenter(center);
        world.getWorldBorder().setSize(BORDER_RADIUS);
    }

    @Override
    public void onDispose() {
        world.getWorldBorder().setSize(BORDER_RADIUS);
    }

}
