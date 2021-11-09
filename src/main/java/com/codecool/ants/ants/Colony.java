package com.codecool.ants.ants;

import com.codecool.ants.geometry.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colony {
    private static Random random = new Random();
    private static int width;
    private Queen queen;
    private List<Ant> ants = new ArrayList<>();

    public Colony(int width) {
        this.width = width;
    }

    private static int getRandomNumber(){
        return random.nextInt(width) - width / 2;
    }

    public void addAnt(Ant ant){
        if (ant instanceof Queen){
            if (queen == null){
                queen = (Queen) ant;
            }else{
                System.out.println("Colony already have queen!");
            }
        }
        ants.add(ant);
    }

    public void createAnts(int numberOfWorkers, int numberOfSoldiers, int numberOfDrones){
        addAnt(new Queen(0, 0));
        for (int i = 0; i < numberOfWorkers; i++){
            addAnt(new Worker(getRandomNumber(), getRandomNumber()));
        }
        for (int i = 0; i < numberOfSoldiers; i++){
            addAnt(new Soldier(getRandomNumber(), getRandomNumber(), Direction.getRandomDirection()));
        }
        for (int i = 0; i < numberOfDrones; i++){
            addAnt(new Drone(getRandomNumber(), getRandomNumber(), queen));
        }
    }
}
