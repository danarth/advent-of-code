package uk.danielarthur.aoc25.day8;

import java.util.List;

import uk.danielarthur.aoc25.util.AdventOfCodeChallenge;
import uk.danielarthur.aoc25.util.InputUtils;

public class Day8 extends AdventOfCodeChallenge {

  private JunctionConnector junctionConnector;
  private List<String> puzzleInput;

  public Day8() {
    this.junctionConnector = new JunctionConnector();
    this.puzzleInput = InputUtils.getInputAsList(getClass());
  }

  @Override
	public String getPart1Answer() {
    return String.valueOf(junctionConnector.calculate(puzzleInput, 1000));
	}

  @Override
  public String getPart2Answer() {
    return String.valueOf(junctionConnector.calculatePart2(puzzleInput));
  }

}
