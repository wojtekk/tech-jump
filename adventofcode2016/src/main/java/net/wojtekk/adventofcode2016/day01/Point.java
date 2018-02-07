package net.wojtekk.adventofcode2016.day01;


import java.util.Objects;

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point add(Point a, Point b) {
        return new Point(a.x + b.x, a.y + b.y);
    }

    public static Point multiply(Point a, int b) {
        return new Point(a.x * b, a.y * b);
    }

    public Point add(Point other) {
        Objects.requireNonNull(other);
        return new Point(x + other.x, y + other.y);
    }

    public Point multiply(Integer multiplier) {
        Objects.requireNonNull(multiplier);
        return new Point(x * multiplier, y * multiplier);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}