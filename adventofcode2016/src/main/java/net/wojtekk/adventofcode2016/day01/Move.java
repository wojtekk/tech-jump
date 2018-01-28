package net.wojtekk.adventofcode2016.day01;

class Move {
    public Rotation direction;
    public int steps;

    public Move(Rotation direction, int steps) {
        this.direction = direction;
        this.steps = steps;
    }

    public Move(String direction, String steps) {
        this(Rotation.fromLetter(direction), Integer.valueOf(steps));
    }
}