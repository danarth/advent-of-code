package uk.danielarthur.aoc25.day7;

public class ManifoldDiagram {

  private char[][] diagram;

  public ManifoldDiagram(char[][] diagram) {
    this.diagram = diagram;
  }


  public ManifoldTree toTree() {
    int emitterLocation = 0;
    boolean foundEmitter = false;
    while(emitterLocation < getWidth() && !foundEmitter) {
      if(get(emitterLocation, 0) == CellStatus.EMITTER) {
        foundEmitter = true;
        break;
      }
      emitterLocation++;
    }
    ManifoldNode root = parseNode(emitterLocation, 0);
    return new ManifoldTree(root);
  }

  /**
   * given a splitter at the current location, create a node with everything underneath it
   */
  private ManifoldNode parseNode(int x, int y) {
    CellStatus current = get(x, y);
    if (current == null) return null;
    if (current == CellStatus.SPLITTER) {
      ManifoldNode left = parseNode(x - 1, y);
      ManifoldNode right = parseNode(x + 1, y);
      ManifoldNode node = new ManifoldNode(x, y);
      node.setLeft(left);
      node.setRight(right);
      return node;
    }
    CellStatus below = get(x, y + 1);
    if (below == null) {
      return new ManifoldNode(x, y);
    } else {
      return parseNode(x, y + 1);
    }
  }

  public boolean splitBeam(int x, int y) {
    boolean isSplit = false;
    if (get(x, y - 1) == CellStatus.EMITTER && get(x, y) == CellStatus.EMPTY) {
      diagram[x][y] = CellStatus.BEAM.getSymbol();
    } else if (get(x, y - 1) == CellStatus.BEAM && get(x, y) == CellStatus.EMPTY) {
      diagram[x][y] = CellStatus.BEAM.getSymbol();
    } else if (
        get(x, y) == CellStatus.SPLITTER &&
        get(x, y - 1) == CellStatus.BEAM
    ) {
      if (get(x - 1, y) == CellStatus.EMPTY) {
        diagram[x - 1][y] = CellStatus.BEAM.getSymbol();
        isSplit = true;
      }
      if (get(x + 1, y) == CellStatus.EMPTY) {
        diagram[x + 1][y] = CellStatus.BEAM.getSymbol();
        isSplit = true;
      }
    }
    return isSplit;
  }

  public CellStatus get(int x, int y) {
    if (x < 0 || x >= diagram.length || y < 0 || y >= diagram[0].length) {
      return null;
    }
    char value = diagram[x][y];
    if (value == CellStatus.EMITTER.getSymbol()) {
      return CellStatus.EMITTER;
    }
    if (value == CellStatus.SPLITTER.getSymbol()) {
      return CellStatus.SPLITTER;
    }
    if (value == CellStatus.BEAM.getSymbol()) {
      return CellStatus.BEAM;
    }
    return CellStatus.EMPTY;
  }

  public int getWidth() {
    return diagram.length;
  }

  public int getHeight() {
    return diagram[0].length;
  }

  @Override
  public String toString() {
    String out = "";
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        out += diagram[x][y];
      }
      out += "\n";
    }
    return out;
  }

  public enum CellStatus {
    EMITTER('S'),
    BEAM('|'),
    SPLITTER('^'),
    EMPTY('.');

    private char symbol;

    private CellStatus(char symbol) {
      this.symbol = symbol;
    }

    public char getSymbol() {
      return symbol;
    }
  }

}
