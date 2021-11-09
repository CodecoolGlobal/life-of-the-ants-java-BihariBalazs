package com.codecool.ants.ants;

public class Drone extends Ant {
    private static final int MATING_DISTANCE = 1;
    private static final int MATING_DURATION = 10;
    private Queen queen;
    private int counterAfterMating;

    public Drone(int x, int y, Queen queen) {
        super(x, y);
        this.queen = queen;
    }

    @Override
    public void step() {
        if (counterAfterMating > 0) {
            counterAfterMating--;
            if (counterAfterMating == 0) {
                kickOff();
            }
        } else {
            if (distanceFrom(queen) > MATING_DISTANCE) {
                move(directionTo(queen));
            } else {
                tryMating();
            }
        }
    }

    private void tryMating() {
        if (queen.isMatingMood()) {
            mating();
        } else {
            kickOff();
        }
    }

    private void mating() {
        queen.awaitForMating();
        counterAfterMating = MATING_DURATION;
    }

}
