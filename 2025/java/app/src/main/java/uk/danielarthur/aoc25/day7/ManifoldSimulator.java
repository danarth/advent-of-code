package uk.danielarthur.aoc25.day7;

public class ManifoldSimulator {

  public int simulateold(char[][] input) {
    ManifoldDiagram diagram = new ManifoldDiagram(input);
    int count = 0;
    for (int y = 1; y < diagram.getHeight(); y++) {
      for (int x = 0; x < diagram.getWidth(); x++) {
        if (diagram.splitBeam(x, y)) {
          count ++;
        }
      }
    }
    return count;
  }

  public int simulate(char[][] input) {
    ManifoldDiagram diagram = new ManifoldDiagram(input);
    ManifoldTree tree = diagram.toTree();
    return tree.getRoot().size();
  }
  
}
