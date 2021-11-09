package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;

public class Worker extends Ant{
    public Worker(int x, int y) {
        super(x, y);
    }

    @Override
    public void step() {
        move(Direction.getRandomDirection());
    }
}
