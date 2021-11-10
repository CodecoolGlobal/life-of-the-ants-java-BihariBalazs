package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;

public class Soldier extends Ant{
    private Direction direction;

    public Soldier(int x, int y, Direction direction) {
        super(x, y, " S ");
        this.direction = direction;
    }

    @Override
    public void step() {
        direction = direction.turnLeft();
        move(direction);
    }
}
