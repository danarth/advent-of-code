package uk.danielarthur.aoc25.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import uk.danielarthur.aoc25.util.InputUtils;

public class JunctionConnectorTest {

  @Test void testRealInput() {
    List<String> input = InputUtils.getInputAsList(getClass());
    JunctionConnector jc = new JunctionConnector();
    assertEquals(40, jc.calculate(input, 10));
  }

  @Test void testRealInputPart2() {
    List<String> input = InputUtils.getInputAsList(getClass());
    JunctionConnector jc = new JunctionConnector();
    assertEquals(25272, jc.calculatePart2(input));
  }

}
