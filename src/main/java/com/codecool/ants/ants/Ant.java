package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;


public abstract class Ant {
    public String type;
    static Random random = new Random();
    private int life;

    public Position position;
    private static final int KICK_DISTANCE = 20;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public Ant(int x, int y, String type, int life) {
        this.type = type;
        this.position = new Position(x, y);
        this.life = life;
    }

    public void move(Direction direction) {
        if (position.getX() + direction.getX() < Colony.getWidth() && position.getX() + direction.getX() > 0) {
            this.position.setX(position.getX() + direction.getX());
        }
        if (position.getY() + direction.getY() < Colony.getWidth() && position.getY() + direction.getY() > 0) {
            this.position.setY(position.getY() + direction.getY());
        }
    }

    public int distanceFrom(Ant otherAnt) {
        return Math.abs(position.getX() - otherAnt.position.getX()) + Math.abs(position.getY() - otherAnt.position.getY());
    }

    public Direction directionTo(Ant otherAnt) {
        if (Math.abs(position.getX() - otherAnt.position.getX()) > Math.abs(position.getY() - otherAnt.position.getY())) {
            return position.getX() > otherAnt.position.getX() ? Direction.WEST : Direction.EAST;
        } else {
            return position.getY() > otherAnt.position.getY() ? Direction.SOUTH : Direction.NORTH;
        }
    }

    public abstract void step();


    public void kickOff() {
        this.position.setX(random.nextInt(KICK_DISTANCE));
        this.position.setY(random.nextInt(KICK_DISTANCE));
    }
}
