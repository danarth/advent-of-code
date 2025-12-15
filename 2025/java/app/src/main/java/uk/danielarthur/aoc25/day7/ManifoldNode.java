package uk.danielarthur.aoc25.day7;

import java.util.HashSet;
import java.util.Set;

public class ManifoldNode {

  private String value;
  private ManifoldNode left;
  private ManifoldNode right;

  public ManifoldNode(String value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public int depth() {
    int depth = 1;
    if (left != null) {
      depth += left.depth();
    }
    return depth;
  }

  public Set<ManifoldNode> collectAll() {
    return collectAll(new HashSet<>());
  }

  public boolean isLeaf() {
    return left == null && right == null;
  }

  public boolean isParent() {
    return left != null || right != null;
  }

  private Set<ManifoldNode> collectAll(Set<ManifoldNode> visited) {
    if (!visited.add(this)) {
      return Set.of();
    }
    if (left == null && right == null) {
      return Set.of(this);
    }
    Set<ManifoldNode> output = new HashSet<>();
    output.add(this);
    output.addAll(left.collectAll(visited));
    output.addAll(right.collectAll(visited));
    return output;
  }

  public ManifoldNode getLeft() {
    return left;
  }

  public void setLeft(ManifoldNode left) {
    this.left = left;
  }

  public ManifoldNode getRight() {
    return right;
  }

  public void setRight(ManifoldNode right) {
    this.right = right;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ManifoldNode &&
        ((ManifoldNode) obj).value.equals(this.value);
  }

  @Override
  public int hashCode() {
    return this.value.hashCode();
  }
  
  @Override
  public String toString() {
    return "(" + this.value + ")";
  }

}
