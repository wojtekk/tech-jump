package net.wojtekk.javamasterclass.lecture94;

public class X {
  public int x;

  public X(int x) {
    this.x = x;
  }

  public void x() {
    for (int x = 1; x < 13; x++) {
      System.out.println(x + " x " + this.x + " = " + (x * this.x));
    }
  }
}
