package net.wojtekk.adventofcode2016.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

  public void part1(String fileName) throws IOException {
    List<String> lines = readFile(fileName);

    Long res = lines.stream()
      .map(line -> Arrays.asList(line.trim().split("[ ]+")))
      .map(numbers -> numbers.stream().map(Integer::valueOf).collect(Collectors.toList()))
      .filter(n -> n.get(0) + n.get(1) > n.get(2) && n.get(1) + n.get(2) > n.get(0) && n.get(2) + n.get(0) > n.get(1))
      .count();

    System.out.println(res);
  }


  public void part2(String fileName) throws IOException {
    List<String> lines = readFile(fileName);

    List<List<Integer>> list = lines.stream()
      .map(line -> Arrays.asList(line.trim().split("[ ]+")))
      .map(numbers -> numbers.stream().map(Integer::valueOf).collect(Collectors.toList()))
      .collect(Collectors.toList());

    int BATCH = 3;

    Long res = IntStream.range(0, (list.size() + BATCH - 1) / BATCH)
      .mapToObj(i -> list.subList(i * BATCH, Math.min(list.size(), (i + 1) * BATCH)))
      .flatMap(b -> Arrays.asList(
        Arrays.asList(b.get(0).get(0), b.get(1).get(0), b.get(2).get(0)),
        Arrays.asList(b.get(0).get(1), b.get(1).get(1), b.get(2).get(1)),
        Arrays.asList(b.get(0).get(2), b.get(1).get(2), b.get(2).get(2))
      ).stream())
      .filter(n -> n.get(0) + n.get(1) > n.get(2) && n.get(1) + n.get(2) > n.get(0) && n.get(2) + n.get(0) > n.get(1))
      .count();

    System.out.println(res);
  }

  private List<String> readFile(String fileName) throws IOException {
    Path path = Paths.get(getClass().getClassLoader().getResource(fileName).getPath());

    return Files.readAllLines(path);
  }
}
