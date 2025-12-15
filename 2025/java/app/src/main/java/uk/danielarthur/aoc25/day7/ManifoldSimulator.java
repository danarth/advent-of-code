package uk.danielarthur.aoc25.day7;

import java.util.HashMap;
import java.util.Map;

public class ManifoldSimulator {

  public int simulate(char[][] input) {
    ManifoldDiagram diagram = new ManifoldDiagram(input);
    ManifoldNode tree = diagram.parseTree();
    return tree.collectAll().stream().filter(ManifoldNode::isParent).toList().size();
  }

  public long quantumSimulate(char[][] input) {
    ManifoldDiagram diagram = new ManifoldDiagram(input);
    ManifoldNode tree = diagram.parseTree();
    return countAll(tree, new HashMap<>());
  }

  private long countAll(ManifoldNode node, Map<ManifoldNode, Long> cache) {
    if (cache.containsKey(node)) {
      return cache.get(node);
    }
    if (node.isLeaf()) {
      cache.put(node, 1l);
      return 1;
    }
    long res = countAll(node.getLeft(), cache) + countAll(node.getRight(), cache);
    cache.put(node, res);
    return res;
  }

}
