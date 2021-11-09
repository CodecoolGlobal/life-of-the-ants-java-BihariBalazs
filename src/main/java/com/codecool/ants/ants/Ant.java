package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;


public abstract class Ant {
        private Position position;

    public Ant(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    public void move(Direction direction){
        this.position.setX(position.getX() + direction.getX());
        this.position.setY(position.getY() + direction.getY());
    }

    public abstract void step();

}
