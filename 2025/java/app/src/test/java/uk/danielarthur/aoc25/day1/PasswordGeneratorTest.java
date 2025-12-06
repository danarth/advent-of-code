package uk.danielarthur.aoc25.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class PasswordGeneratorTest {

  @Test void testGenerateWithRealInput() {
    InputStream input = PasswordGeneratorTest.class.getResourceAsStream("input.txt");
    List<String> puzzleInput = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))
      .lines().collect(Collectors.toList());
    PasswordGenerator pg = new PasswordGenerator(puzzleInput);
    long res = pg.generatePassword();
    assertEquals(3, res);
  }

  @Test void testGenerateLeftLandsOnZero() {
    List<String> input = List.of("L50");
    PasswordGenerator pg = new PasswordGenerator(input);
    long res = pg.generatePassword();
    assertEquals(1, res);
  }

  @Test void testGenerateRightLongValueNoLandOnZero() {
    List<String> input = List.of("R495");
    PasswordGenerator pg = new PasswordGenerator(input);
    assertEquals(0, pg.generatePassword());
  }

  @Test void testGenerateLeftNoLandOnZero() {
    List<String> input = List.of("L450");
    PasswordGenerator pg = new PasswordGenerator(input);
    assertEquals(1, pg.generatePassword());
  }

  @Test void testGenerateMultipleRotationsLandsOnZero() {
    List<String> input = List.of("L68", "L30", "R48");
    PasswordGenerator pg = new PasswordGenerator(input);
    assertEquals(1, pg.generatePassword());
  }

  @Test void testGeneratePart2WithRealInput() {
    InputStream input = PasswordGeneratorTest.class.getResourceAsStream("input.txt");
    List<String> puzzleInput = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))
      .lines().collect(Collectors.toList());
    PasswordGenerator pg = new PasswordGenerator(puzzleInput);
    long res = pg.generateAdvancedPassword();
    assertEquals(6, res);
  }
}
