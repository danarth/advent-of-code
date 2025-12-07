package uk.danielarthur.aoc25.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import uk.danielarthur.aoc25.util.InputUtils;

public class PasswordGeneratorTest {

  @Test void testGenerateWithRealInput() {
    List<String> input = InputUtils.getInputAsList(PasswordGeneratorTest.class);
    PasswordGenerator pg = new PasswordGenerator();
    long res = pg.generatePassword(input);
    assertEquals(3, res);
  }

  @Test void testGenerateLeftLandsOnZero() {
    List<String> input = List.of("L50");
    PasswordGenerator pg = new PasswordGenerator();
    long res = pg.generatePassword(input);
    assertEquals(1, res);
  }

  @Test void testGenerateRightLongValueNoLandOnZero() {
    List<String> input = List.of("R495");
    PasswordGenerator pg = new PasswordGenerator();
    assertEquals(0, pg.generatePassword(input));
  }

  @Test void testGenerateLeftNoLandOnZero() {
    List<String> input = List.of("L450");
    PasswordGenerator pg = new PasswordGenerator();
    assertEquals(1, pg.generatePassword(input));
  }

  @Test void testGenerateMultipleRotationsLandsOnZero() {
    List<String> input = List.of("L68", "L30", "R48");
    PasswordGenerator pg = new PasswordGenerator();
    assertEquals(1, pg.generatePassword(input));
  }

  @Test void testGeneratePart2WithRealInput() {
    List<String> input = InputUtils.getInputAsList(PasswordGeneratorTest.class);
    PasswordGenerator pg = new PasswordGenerator();
    long res = pg.generateAdvancedPassword(input);
    assertEquals(6, res);
  }
}
