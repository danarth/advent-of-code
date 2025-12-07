package uk.danielarthur.aoc25.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import uk.danielarthur.aoc25.util.InputUtils;

public class BatteryCalculatorTest {

  @Test void testCalculateWithTestInput() {
    List<String> input = InputUtils.getInputAsList(this.getClass());
    BatteryCalculator bc = new BatteryCalculator();
    assertEquals(357, bc.calculate(input));
  }

  @Test void testCalculateAdvancedWithTestInput() {
    List<String> input = InputUtils.getInputAsList(this.getClass());
    BatteryCalculator bc = new BatteryCalculator();
    assertEquals(3121910778619l, bc.calculateLargeJoltage(input));
  }
  
}
