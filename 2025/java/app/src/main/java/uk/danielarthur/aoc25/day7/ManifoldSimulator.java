package uk.danielarthur.aoc25.day7;

public class ManifoldSimulator {

  public int simulate(char[][] input) {
    ManifoldDiagram diagram = new ManifoldDiagram(input);
    SplitterTree tree = diagram.parseTree();
    return tree.collectParents().size();
  }

  public int quantumSimulate(char[][] input) {
    ManifoldDiagram diagram = new ManifoldDiagram(input);
    SplitterTree tree = diagram.parseTree();
    return tree.getPossiblePaths().size();
  }

}
