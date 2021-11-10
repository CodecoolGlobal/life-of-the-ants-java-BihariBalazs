package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;


public abstract class Ant {
    public String type;
    static Random random = new Random();

    public Position position;
    private static final int KICK_DISTANCE_MAX = 40;
    private static final int KICK_DISTANCE_MIN = 20;

    public Ant(int x, int y, String type) {
        this.type = type;
        this.position = new Position(x, y);
    }

    public void move(Direction direction) {
        this.position.setX(position.getX() + direction.getX());
        this.position.setY(position.getY() + direction.getY());
    }

    public int distanceFrom(Ant otherAnt) {
        return Math.abs(position.getX() - otherAnt.position.getX()) + Math.abs(position.getY() - otherAnt.position.getY());
    }

    public Direction directionTo(Ant otherAnt){
        if (Math.abs(position.getX() - otherAnt.position.getX()) > Math.abs(position.getY() - otherAnt.position.getY())){
           return position.getX() > otherAnt.position.getX() ? Direction.WEST : Direction.EAST;
        } else {
            return position.getY() > otherAnt.position.getY() ? Direction.SOUTH : Direction.NORTH;
        }
    }

    public abstract void step();


    public void kickOff(){
        this.position.setX(random.nextInt(KICK_DISTANCE_MAX) - KICK_DISTANCE_MIN);
        this.position.setY(random.nextInt(KICK_DISTANCE_MAX) - KICK_DISTANCE_MIN);
    }
}
