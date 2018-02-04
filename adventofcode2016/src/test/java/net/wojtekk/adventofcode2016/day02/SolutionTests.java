package net.wojtekk.adventofcode2016.day02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTests {

  @Test
  @DisplayName("Convert position to Digit - part 2")
  void getDigits2() {
    Solution solution = new Solution();

    assertEquals('1', solution.getDigit2(new int[]{0, 2}));
    assertEquals('2', solution.getDigit2(new int[]{-1, 1}));
    assertEquals('3', solution.getDigit2(new int[]{0, 1}));
    assertEquals('4', solution.getDigit2(new int[]{1, 1}));
    assertEquals('5', solution.getDigit2(new int[]{-2, 0}));
    assertEquals('6', solution.getDigit2(new int[]{-1, 0}));
    assertEquals('7', solution.getDigit2(new int[]{0, 0}));
    assertEquals('8', solution.getDigit2(new int[]{1, 0}));
    assertEquals('9', solution.getDigit2(new int[]{2, 0}));
    assertEquals('A', solution.getDigit2(new int[]{-1, -1}));
    assertEquals('B', solution.getDigit2(new int[]{0, -1}));
    assertEquals('C', solution.getDigit2(new int[]{1, -1}));
    assertEquals('D', solution.getDigit2(new int[]{0, -2}));
  }

}
