package net.wojtekk.javamasterclass.lecture94;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    X x = new X(scanner.nextInt());
    x.x();
  }
}
