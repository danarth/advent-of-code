package uk.danielarthur.aoc25.util;

public abstract class AdventOfCodeChallenge {

  public abstract String getPart1Answer();

  public abstract String getPart2Answer();
  
  public void printAnswers() {
    System.out.println("Part 1: " + getPart1Answer());
    System.out.println("Part 2: " + getPart2Answer());
  }
  
}
