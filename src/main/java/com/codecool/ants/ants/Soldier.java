package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;

import java.util.Random;

public class Soldier extends Ant{
    private static final int SOLDIER_LIFE_MIN = 60;
    private static final int SOLDIER_LIFE_MAX = 70;

    static Random r = new Random();
    private Direction direction;

    public Soldier(int x, int y, Direction direction) {
        super(x, y, " S ", r.nextInt(SOLDIER_LIFE_MAX - SOLDIER_LIFE_MIN) + SOLDIER_LIFE_MIN);
        this.direction = direction;
    }

    @Override
    public void step() {
        direction = direction.turnLeft();
        move(direction);
    }
}
