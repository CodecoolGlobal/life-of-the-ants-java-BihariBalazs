package com.codecool.ants;

import com.codecool.ants.ants.Colony;

public class  Simulator {
    private static final int ROUNDS = 10;

    public static void main(String[] args) {
        Colony colony = new Colony(100);
        colony.createAnts(5, 4, 2);
        for (int time = 0; time < ROUNDS; time++){
            System.out.println(colony);
        }
    }

}
