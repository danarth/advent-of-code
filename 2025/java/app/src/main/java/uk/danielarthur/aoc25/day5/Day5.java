package uk.danielarthur.aoc25.day5;

import java.util.List;

import uk.danielarthur.aoc25.util.AdventOfCodeChallenge;
import uk.danielarthur.aoc25.util.InputUtils;

public class Day5 extends AdventOfCodeChallenge {

  private List<String> freshRanges;
  private List<String> ingredients;
  private IngredientManager ingredientManager;

  public Day5() {
    List<List<String>> puzzleInput = InputUtils.getInputAsDoubleList(this.getClass());
    this.freshRanges = puzzleInput.get(0);
    this.ingredients = puzzleInput.get(1);
    this.ingredientManager = new IngredientManager();
  }

  @Override
  public String getPart1Answer() {
    return String.valueOf(ingredientManager.getFreshIngredients(freshRanges, ingredients));
  }

  @Override
  public String getPart2Answer() {
    return String.valueOf(ingredientManager.getAllFreshIngredients(freshRanges));
  }

}
