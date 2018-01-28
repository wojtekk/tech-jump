package net.wojtekk.adventofcode2016.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.entry;

public class Solution {
    Map<Direction, Point> steps = Map.ofEntries(
            entry(Direction.NORTH, new Point(0, 1)),
            entry(Direction.EAST, new Point(1, 0)),
            entry(Direction.SOUTH, new Point(0, -1)),
            entry(Direction.WEST, new Point(-1, 0)));

    public void part1(String fileName) throws IOException {
        Direction direction = Direction.NORTH;
        Point position = new Point(0, 0);
        List<Move> moves = getMoves(fileName);

        for (Move move : moves) {
            direction = Direction.rotate(direction, move.direction);
            position = Point.add(position, Point.multiply(steps.get(direction), move.steps));
        }

        System.out.println("Part 1");
        System.out.println("Point: " + position.x + ", " + position.y);
        System.out.println("Distance: " + (Math.abs(position.x) + Math.abs(position.y)));
    }

    public void part2(String fileName) throws IOException {
        Direction direction = Direction.NORTH;
        Point position = new Point(0, 0);
        List<Move> moves = getMoves(fileName);
        List<Point> positions = new LinkedList<>();
        positions.add(position);

        OUTER_LOOP:
        for (Move move : moves) {
            direction = Direction.rotate(direction, move.direction);
            for (int s = 0; s < move.steps; s++) {
                position = Point.add(position, steps.get(direction));
                if (positions.contains(position)) {
                    break OUTER_LOOP;
                }
                positions.add(position);
            }
        }

        System.out.println("Part 2");
        System.out.println("Point: " + position.x + ", " + position.y);
        System.out.println("Distance: " + (Math.abs(position.x) + Math.abs(position.y)));
    }

    private List<Move> getMoves(String fileName) throws IOException {
        String data = readFile(fileName);

        return Arrays.stream(data.split(","))
                .map(move -> move.trim())
                .map(move -> new Move(move.substring(0, 1), move.substring(1)))
                .collect(Collectors.toList());
    }

    private String readFile(String fileName) throws IOException {
        String file = Main.class.getClassLoader().getResource(fileName).getPath();
        Path path = Paths.get(file);

        return Files.readAllLines(path).stream()
                .collect(Collectors.joining());
    }
}
