package net.wojtekk.adventofcode2016.day01;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    String fileName = args[0];

    Solution solution = new Solution();
    solution.part1(fileName);
    solution.part2(fileName);
  }
}
