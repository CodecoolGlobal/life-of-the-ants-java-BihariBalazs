package com.codecool.ants.geometry;

import java.util.Random;

public enum Direction {
        NORTH (0, 1),
        EAST (1, 0),
        SOUTH (0, -1),
        WEST (-1, 0);

        private static Random random = new Random();
        private final int x;
        private final int y;
        private static final int numberOfDirections = Direction.values().length;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Direction getRandomDirection(){
            return Direction.values()[random.nextInt(numberOfDirections)];
        }
    }
