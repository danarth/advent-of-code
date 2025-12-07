package uk.danielarthur.aoc25.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uk.danielarthur.aoc25.util.InputUtils;

public class ForkliftOptimiserTest {

  @Test void testGetAccessibleRollsWithRealInput() {
    char[][] input = InputUtils.getInputAsCharMap(this.getClass());
    ForkliftOptimiser fo = new ForkliftOptimiser();
    assertEquals(13, fo.getAccessibleRolls(input));
  }

  @Test void testRemoveAccessibleRollsWithRealInput() {
    char[][] input = InputUtils.getInputAsCharMap(this.getClass());
    ForkliftOptimiser fo = new ForkliftOptimiser();
    assertEquals(43, fo.removeAccessibleRolls(input));
  }
    
}
