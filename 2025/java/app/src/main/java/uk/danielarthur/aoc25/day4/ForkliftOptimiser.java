package uk.danielarthur.aoc25.day4;

import uk.danielarthur.aoc25.day4.ForkliftMap.MapSquare;

public class ForkliftOptimiser {

  public int getAccessibleRolls(char[][] input) {
    ForkliftMap map = new ForkliftMap(input);
    int count = 0;
    for (int x = 0; x < input.length; x++) {
      for (int y = 0; y < input[0].length; y++) {
        if (map.get(x, y) == MapSquare.PAPER_ROLL && map.countSurroundingRolls(x, y) < 4) {
          count++;
        }
      }
    }
    return count;
  }
  
  public int removeAccessibleRolls(char[][] input) {
    ForkliftMap map = new ForkliftMap(input);
    return removeRollsRecursive(map);
  }

  private int removeRollsRecursive(ForkliftMap map) {
    int count = 0;
    for (int x = 0; x < map.getWidth(); x++) {
      for (int y = 0; y < map.getHeight(); y++) {
        if (map.get(x, y) == MapSquare.PAPER_ROLL && map.countSurroundingRolls(x, y) < 4) {
          map.removeRoll(x, y);
          count++;
        }
      }
    }
    if (count == 0) {
      return 0;
    }
    map.convertRemovedToEmpty();
    return count + removeRollsRecursive(map);
  }

}
