package net.wojtekk.adventofcode2016.day01;


import java.util.Objects;

class Point {
  public int x;
  public int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Point add(Point other) {
    Objects.requireNonNull(other);
    return new Point(this.x + other.x, this.y + other.y);
  }

  public Point multiply(int value) {
    Objects.requireNonNull(value);
    return new Point(this.x * value, this.y * value);
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
