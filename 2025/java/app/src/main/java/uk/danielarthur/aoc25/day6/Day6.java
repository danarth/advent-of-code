package uk.danielarthur.aoc25.day6;

import java.util.List;

import uk.danielarthur.aoc25.util.AdventOfCodeChallenge;
import uk.danielarthur.aoc25.util.InputUtils;

public class Day6 extends AdventOfCodeChallenge {

  private List<String> puzzleInput;
  private HomeworkSolver homeworkSolver;

  public Day6() {
    this.puzzleInput = InputUtils.getInputAsList(getClass());
    this.homeworkSolver = new HomeworkSolver();
  }

  @Override
  public String getPart1Answer() {
    return String.valueOf(homeworkSolver.solve(puzzleInput));
  }

  @Override
  public String getPart2Answer() {
    return String.valueOf(homeworkSolver.solveCephalopod(puzzleInput));
  }

}
