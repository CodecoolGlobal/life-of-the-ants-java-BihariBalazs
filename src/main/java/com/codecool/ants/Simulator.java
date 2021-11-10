package com.codecool.ants;

import com.codecool.ants.ants.Colony;

public class  Simulator {
    private static final int ROUNDS = 10;

    public static void main(String[] args) {
        Colony colony = new Colony(20);
        colony.createAnts(1, 1, 1);
        for (int time = 0; time < ROUNDS; time++){
            colony.display();
            colony.step();
        }
    }

}
