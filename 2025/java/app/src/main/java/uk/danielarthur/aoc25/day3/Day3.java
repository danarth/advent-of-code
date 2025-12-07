package uk.danielarthur.aoc25.day3;

import java.util.List;

import uk.danielarthur.aoc25.util.AdventOfCodeChallenge;
import uk.danielarthur.aoc25.util.InputUtils;

public class Day3 extends AdventOfCodeChallenge {

  private List<String> puzzleInput;
  private BatteryCalculator batteryCalculator;

  public Day3() {
     this.puzzleInput = InputUtils.getInputAsList(this.getClass());
     this.batteryCalculator = new BatteryCalculator();
  }


	@Override
	public String getPart1Answer() {
    return String.valueOf(batteryCalculator.calculate(puzzleInput));
	}

	@Override
	public String getPart2Answer() {
    return String.valueOf(batteryCalculator.calculateLargeJoltage(puzzleInput));
	}

  
}
