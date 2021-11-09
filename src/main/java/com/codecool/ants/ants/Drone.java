package com.codecool.ants.ants;

public class Drone extends Ant{
    private Queen queen;

    public Drone(int x, int y, Queen queen) {
        super(x, y);
        this.queen = queen;
    }
}
