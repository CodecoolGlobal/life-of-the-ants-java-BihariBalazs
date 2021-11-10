package com.codecool.ants;

import com.codecool.ants.ants.Colony;

import java.util.concurrent.TimeUnit;

public class  Simulator {
    private static final int ROUNDS = 100;

    public static void main(String[] args) throws InterruptedException {
        Colony colony = new Colony(20);
        colony.createAnts(1, 1, 1);
        for (int time = 0; time < ROUNDS; time++){
            colony.display();
            colony.newAnts();
            colony.step();
            TimeUnit.SECONDS.sleep(2);
        }
    }

}
