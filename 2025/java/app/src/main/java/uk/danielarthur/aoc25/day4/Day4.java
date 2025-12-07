package uk.danielarthur.aoc25.day4;

import uk.danielarthur.aoc25.util.AdventOfCodeChallenge;
import uk.danielarthur.aoc25.util.InputUtils;

public class Day4 extends AdventOfCodeChallenge {

  private char[][] puzzleInput;
  private ForkliftOptimiser forkliftOptimiser;

  public Day4() {
     this.puzzleInput = InputUtils.getInputAsCharMap(this.getClass());
     this.forkliftOptimiser = new ForkliftOptimiser();
  }

	@Override
	public String getPart1Answer() {
    return String.valueOf(forkliftOptimiser.getAccessibleRolls(puzzleInput));
	}

	@Override
	public String getPart2Answer() {
    return String.valueOf(forkliftOptimiser.removeAccessibleRolls(puzzleInput));
	}

  
}
