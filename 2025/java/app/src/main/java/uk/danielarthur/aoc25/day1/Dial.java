package uk.danielarthur.aoc25.day1;

public class Dial {

  private final int size;
  private final int start;

  private int pointer;

  public Dial() {
    this(100, 50);
  }

  public Dial(int size, int start) {
    this.size = size;
    this.start = start;
    this.pointer = this.start;
  }

  public int right(int clicks) {
    int zeroesPassed = (this.pointer + clicks) / this.size;
    int remainder = clicks % this.size;
    int nextPointer = this.pointer + remainder;
    this.pointer = nextPointer % this.size;
    return zeroesPassed;
  }

  public int left(int clicks) {
    int zerosPassed = clicks / this.size;
    int remainder = clicks % this.size;
    int nextPointer = this.pointer - remainder;
    if (this.pointer != 0 && nextPointer <= 0) {
      zerosPassed++;
    }
    this.pointer = (this.size + nextPointer) % this.size;
    return zerosPassed;
  }

  public int getPointer() {
    return this.pointer;
  }
  
}
