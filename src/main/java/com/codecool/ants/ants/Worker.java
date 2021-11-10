package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;

import java.util.Random;

public class Worker extends Ant {
    private static final int WORKER_LIFE_MIN = 58;
    private static final int WORKER_LIFE_MAX = 68;

    static Random r = new Random();

    public Worker(int x, int y) {

        super(x, y, " W ", r.nextInt(WORKER_LIFE_MAX - WORKER_LIFE_MIN) + WORKER_LIFE_MIN);
    }

    @Override
    public void step() {
        move(Direction.getRandomDirection());
    }
}
