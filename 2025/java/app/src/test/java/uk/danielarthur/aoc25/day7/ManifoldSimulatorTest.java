package uk.danielarthur.aoc25.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uk.danielarthur.aoc25.util.InputUtils;

public class ManifoldSimulatorTest {

  @Test void testSimulateRealInput() {
    char[][] input = InputUtils.getInputAsCharMap(getClass());
    ManifoldSimulator ms = new ManifoldSimulator();
    assertEquals(21, ms.simulate(input));
  }

}
