package com.codecool.ants.ants;


public class Queen extends Ant{
    private static final int MATING_AWAIT_MIN = 50;
    private int counterAfterMating = 0;


    public Queen(int x, int y) {
        super(x, y, " Q ");
    }

    @Override
    public void step() {
        if (counterAfterMating > 0){
            counterAfterMating--;
        }
    }

    public boolean isMatingMood(){
        return counterAfterMating == 0;
    }

    public void awaitForMating(){
        counterAfterMating = random.nextInt(MATING_AWAIT_MIN) + MATING_AWAIT_MIN;
    }
}
