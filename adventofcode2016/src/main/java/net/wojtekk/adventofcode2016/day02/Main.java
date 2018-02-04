package net.wojtekk.adventofcode2016.day02;


import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    String fileName = args[0];

    try {
      Solution solution = new Solution();
      solution.part1(fileName);
      solution.part2(fileName);
    } catch (IOException err) {
      System.err.println("File " + fileName + "does not exists");
    }
  }
}
