package uk.danielarthur.aoc25.day2;

import java.util.List;

import uk.danielarthur.aoc25.util.AdventOfCodeChallenge;
import uk.danielarthur.aoc25.util.InputUtils;

public class Day2 extends AdventOfCodeChallenge {

  private String puzzleInput;
  private ProductChecker productChecker;

  public Day2() {
     this.puzzleInput = InputUtils.getInputAsString(this.getClass());
     this.productChecker = new ProductChecker();
  }

	@Override
	public String getPart1Answer() {
    return Long.toString(productChecker.getInvalidProducts(puzzleInput));
	}

	@Override
	public String getPart2Answer() {
    return Long.toString(productChecker.getInvalidProductsAdvanced(puzzleInput));
	}

  
}
