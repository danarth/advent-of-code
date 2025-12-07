package uk.danielarthur.aoc25.day4;

public class ForkliftMap {
  
  private char[][] map;

  public ForkliftMap(char[][] map) {
    this.map = map;
  }

  public MapSquare get(int x, int y) {
    if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
      return MapSquare.OUT_OF_BOUNDS;
    }
    char value = map[x][y];
    if (value == '@') {
      return MapSquare.PAPER_ROLL;
    }
    if (value == 'x') {
      return MapSquare.PAPER_ROLL_REMOVED;
    }
    return MapSquare.EMPTY;
  }

  public int countSurroundingRolls(int x, int y) {
    int sum = 0;
    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (i == x && j == y) continue;
        MapSquare sq = get(i, j);
        if (sq == MapSquare.PAPER_ROLL || sq == MapSquare.PAPER_ROLL_REMOVED) {
          sum++;
        }
      }
    }
    return sum;
  }

  public void removeRoll(int x, int y) {
    if (x >= 0 && x < getWidth() && y >= 0 && y < getHeight()) {
      map[x][y] = 'x';
    }
  }

  public void convertRemovedToEmpty() {
    for (int x = 0; x < getWidth(); x++) {
      for (int y = 0; y < getHeight(); y++) {
        if (get(x, y) == MapSquare.PAPER_ROLL_REMOVED) {
          map[x][y] = '.';
        }
      }
    }
  }

  public int getWidth() {
    return map.length;
  }

  public int getHeight() {
    return map[0].length;
  }

  @Override
  public String toString() {
    String out = "";
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        out += map[x][y];
      }
      out += "\n";
    }
    return out;
  }
  
  public enum MapSquare {
    PAPER_ROLL,
    PAPER_ROLL_REMOVED,
    EMPTY,
    OUT_OF_BOUNDS,
  }
}

