package net.wojtekk.adventofcode2016.day01;

public enum Rotation {
    LEFT, RIGHT;

    public static Rotation fromLetter(String rotation) {
        Rotation result;
        switch (rotation.toUpperCase()) {
            case "R":
                result = Rotation.RIGHT;
                break;
            case "L":
            default:
                result = Rotation.LEFT;
        }
        return result;
    }
}