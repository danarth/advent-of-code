package uk.danielarthur.aoc25.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import uk.danielarthur.aoc25.util.InputUtils;


public class ProductCheckerTest {

  @Test void testWithInput() {
    String puzzleInput = InputUtils.getInputAsString(this.getClass());
    ProductChecker pc = new ProductChecker();
    long res = pc.getInvalidProducts(puzzleInput);
    assertEquals(1227775554, res);
  }
  
  @Test void testWithInputPart2() {
    String puzzleInput = InputUtils.getInputAsString(this.getClass());
    ProductChecker pc = new ProductChecker();
    long res = pc.getInvalidProductsAdvanced(puzzleInput);
    assertEquals(4174379265l, res);
  }

}
