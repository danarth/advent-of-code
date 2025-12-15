package uk.danielarthur.aoc25.day7;

import java.util.HashMap;
import java.util.Map;

public class ManifoldDiagram {

  private static final char EMITTER = 'S';
  private static final char SPLITTER = '^';
  private static final char OUT_OF_BOUNDS = 'x';

  private char[][] diagram;
  private Map<String, ManifoldNode> seen;

  public ManifoldDiagram(char[][] diagram) {
    this.diagram = diagram;
    this.seen = new HashMap<>();
  }

  public ManifoldNode parseTree() {
    boolean foundEmitter = false;
    int x = 0;
    while(x < diagram.length && !foundEmitter) {
      if (get(x, 0) == EMITTER) {
        foundEmitter = true;
        break;
      }
      x++;
    }
    if (foundEmitter) {
      return parseTree(x, 1);
    }
    return null;
  }

  private ManifoldNode parseTree(int x, int y) {
    char current = get(x, y);
    String xy = x + "," + y;
    if (seen.containsKey(xy)) {
      return seen.get(xy);
    }
    if (current == OUT_OF_BOUNDS) return null;
    if (current == SPLITTER) {
      ManifoldNode node = new ManifoldNode(xy);
      node.setLeft(parseTree(x - 1, y));
      node.setRight(parseTree(x + 1, y));
      seen.put(xy, node);
      return node;
    }
    char below = get(x, y + 1);
    if (below == OUT_OF_BOUNDS) {
      return new ManifoldNode(xy);
    } else {
      return parseTree(x, y + 1);
    }
  }

  public char get(int x, int y) {
    if (x < 0 || x >= diagram.length || y < 0 || y >= diagram[0].length) {
      return OUT_OF_BOUNDS;
    }
    return diagram[x][y];
  }

}
