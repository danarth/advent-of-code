package uk.danielarthur.aoc25.day7;

import uk.danielarthur.aoc25.util.AdventOfCodeChallenge;
import uk.danielarthur.aoc25.util.InputUtils;

public class Day7 extends AdventOfCodeChallenge {

  private char[][] input;
  private ManifoldSimulator manifoldSimulator;

  public Day7() {
    this.input = InputUtils.getInputAsCharMap(getClass());
    this.manifoldSimulator = new ManifoldSimulator();
  }

  @Override
  public String getPart1Answer() {
    return String.valueOf(manifoldSimulator.simulate(input));
  }

  @Override
  public String getPart2Answer() {
    return String.valueOf(manifoldSimulator.quantumSimulate(input));
  }

}
