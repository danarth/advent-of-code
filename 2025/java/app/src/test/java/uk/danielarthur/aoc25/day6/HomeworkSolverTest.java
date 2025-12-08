package uk.danielarthur.aoc25.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import uk.danielarthur.aoc25.util.InputUtils;

public class HomeworkSolverTest {

  @Test void testSolveWithRealInput() {
    List<String> problems = InputUtils.getInputAsList(getClass());
    HomeworkSolver hs = new HomeworkSolver();
    assertEquals(4277556, hs.solve(problems));
  }
  
  @Test void testSolveCephalopodWithRealInput() {
    List<String> problems = InputUtils.getInputAsList(getClass());
    HomeworkSolver hs = new HomeworkSolver();
    assertEquals(3263827, hs.solveCephalopod(problems));
  }

}
