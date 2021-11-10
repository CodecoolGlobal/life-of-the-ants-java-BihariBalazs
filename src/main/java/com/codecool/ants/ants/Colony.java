package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {
    private static Random random = new Random();

    public static int getWidth() {
        return width;
    }

    private static int width;
    private Queen queen;
    private List<Ant> ants = new ArrayList<>();

    public Colony(int width) {
        Colony.width = width;
    }

    private static int getRandomNumber() {
        return random.nextInt(width);
    }

    public void addAnt(Ant ant) {
        if (ant instanceof Queen) {
            if (queen == null) {
                queen = (Queen) ant;
            } else {
                System.out.println("Colony already have queen!");
            }
        }
        ants.add(ant);
    }

    public void createAnts(int numberOfWorkers, int numberOfSoldiers, int numberOfDrones) {
        if (queen == null) {
            addAnt(new Queen(width / 2, width / 2));
        }
        for (int i = 0; i < numberOfWorkers; i++) {
            addAnt(new Worker(getRandomNumber(), getRandomNumber()));
        }
        for (int i = 0; i < numberOfSoldiers; i++) {
            addAnt(new Soldier(getRandomNumber(), getRandomNumber(), Direction.getRandomDirection()));
        }
        for (int i = 0; i < numberOfDrones; i++) {
            addAnt(new Drone(getRandomNumber(), getRandomNumber(), queen));
        }
    }

    public void newAnts() {
        if (queen.getCounterAfterMating() > 45) {
            createAnts((int) Math.round(Math.random()), (int) Math.round(Math.random()), (int) Math.round(Math.random()));
        }
    }

    public void step() {
        for (Ant ant : ants) {
            ant.step();
        }
    }

    public String displayAnt(int x, int y) {
        for (Ant ant : ants) {
            if (x == ant.position.getX() && y == ant.position.getY()) {
                return ant.type;
            }
        }
        return null;
    }

    public void display() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (displayAnt(i, j) != null) {
                    System.out.print(displayAnt(i, j));
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------------");
    }

}
