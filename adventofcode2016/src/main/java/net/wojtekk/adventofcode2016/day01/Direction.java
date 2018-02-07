package net.wojtekk.adventofcode2016.day01;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    private static int NUM_OF_DIRECTIONS = 4;

    public Direction rotate(Rotation rotation) {
        int dir = this.ordinal();
        if (rotation == Rotation.LEFT) {
            dir = (NUM_OF_DIRECTIONS + dir - 1) % NUM_OF_DIRECTIONS;
        } else {
            dir = (NUM_OF_DIRECTIONS + dir + 1) % NUM_OF_DIRECTIONS;
        }

        return Direction.values()[dir];
    }
}
