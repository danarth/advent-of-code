package uk.danielarthur.aoc25.day1;

import java.util.List;

public class PasswordGenerator {

  List<String> puzzleInput;

  public PasswordGenerator(List<String> puzzleInput) {
    this.puzzleInput = puzzleInput;
  }

  public int generatePassword() {
    int landedOnZero = 0;
    Dial dial = new Dial();
    for(String instruction : puzzleInput) {
      char direction = instruction.charAt(0);
      int clicks = Integer.parseInt(instruction.substring(1));
      if (direction == 'R') {
        dial.right(clicks);
      } else {
        dial.left(clicks);
      }
      if (dial.getPointer() == 0) {
        landedOnZero++;
      }
    }
    return landedOnZero;
  }

  public int generateAdvancedPassword() {
    int zeroCount = 0;
    Dial dial = new Dial();
    for(String instruction : puzzleInput) {
      char direction = instruction.charAt(0);
      int clicks = Integer.parseInt(instruction.substring(1));
      if (direction == 'R') {
        zeroCount += dial.right(clicks);
      } else {
        zeroCount += dial.left(clicks);
      }
    }
    return zeroCount;
  }

}
