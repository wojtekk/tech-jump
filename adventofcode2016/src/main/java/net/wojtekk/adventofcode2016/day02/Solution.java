package net.wojtekk.adventofcode2016.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class Solution {
  Map<Character, int[]> moves = Map.ofEntries(
    entry('U', new int[]{0, 1}),
    entry('R', new int[]{1, 0}),
    entry('D', new int[]{0, -1}),
    entry('L', new int[]{-1, 0})
  );

  List<String> digits2 = List.of("  1  ", " 234 ", "56789", " ABC ", "  D  ");

  final Integer SIZE = 3;

  public void part1(String fileName) throws IOException {
    List<String> steps = readFile(fileName);

    int[] pos = {1, 1};
    List<String> result = new ArrayList<>();

    for (String line : steps) {
      for (Character c : line.toCharArray()) {
        int[] move = moves.get(c);
        if (canMove(pos, move)) {
          pos = add(pos, move);
        }
      }

      Integer digit = pos[0] + 1 + (2 - pos[1]) * 3;
      result.add(digit.toString());
    }

    System.out.println(String.join("", result));
  }

  private int[] add(int[] pos, int[] move) {
    return new int[]{pos[0] + move[0], pos[1] + move[1]};
  }

  private boolean canMove(int[] pos, int[] move) {
    int[] n = add(pos, move);
    return Math.max(n[0], n[1]) < SIZE && Math.min(n[0], n[1]) >= 0;
  }

  public void part2(String fileName) throws IOException {
    List<String> steps = readFile(fileName);

    int[] pos = {-2, 0};
    StringBuilder result = new StringBuilder();

    for (String line : steps) {
      for (Character c : line.toCharArray()) {
        int[] move = moves.get(c);
        if (canMove2(pos, move)) {
          pos = add(pos, move);
        }
      }

      char digit = getDigit2(pos);
      result.append(digit);
    }

    System.out.println(result.toString());
  }

  public char getDigit2(int[] pos) {
    return digits2.get(Math.abs(pos[1] - 2)).toCharArray()[2 + pos[0]];
  }

  private boolean canMove2(int[] pos, int[] move) {
    int[] n = add(pos, move);
    return Math.abs(n[0]) + Math.abs(n[1]) < SIZE;
  }

  private List<String> readFile(String fileName) throws IOException {
    Path path = Paths.get(getClass().getClassLoader().getResource(fileName).getPath());

    return Files.readAllLines(path);
  }
}
