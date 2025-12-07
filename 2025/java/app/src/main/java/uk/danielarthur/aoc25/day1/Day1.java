package uk.danielarthur.aoc25.day1;

import java.util.List;

import uk.danielarthur.aoc25.util.AdventOfCodeChallenge;
import uk.danielarthur.aoc25.util.InputUtils;

public class Day1 extends AdventOfCodeChallenge {

  private List<String> puzzleInput;
  private PasswordGenerator passwordGenerator;

  public Day1() {
     this.puzzleInput = InputUtils.getInputAsList(this.getClass());
     this.passwordGenerator = new PasswordGenerator();
  }

	@Override
	public String getPart1Answer() {
    return Integer.toString(passwordGenerator.generatePassword(puzzleInput));
	}

	@Override
	public String getPart2Answer() {
    return Integer.toString(passwordGenerator.generateAdvancedPassword(puzzleInput));
	}

  
}
