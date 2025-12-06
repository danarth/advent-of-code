package uk.danielarthur.aoc25.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DialTest {

  @Test void testRightZeros() {
    Dial dial = new Dial();
    assertEquals(1, dial.right(100));
  }

  @Test void testRightLandsOnZero() {
    Dial dial = new Dial();
    assertEquals(1, dial.right(50));
  }

  @Test void testRightLongLandsOnZero() {
    Dial dial = new Dial();
    assertEquals(5, dial.right(450));
  }

  @Test void testLeftZeros() {
    Dial dial = new Dial();
    assertEquals(1, dial.left(100));
  }

  @Test void testLeftLandsOnZero() {
    Dial dial = new Dial();
    assertEquals(1, dial.left(50));
  }

  @Test void testLeftLongLandsOnZero() {
    Dial dial = new Dial();
    assertEquals(5, dial.left(450));
  }
    
}
