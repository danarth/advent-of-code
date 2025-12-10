package uk.danielarthur.aoc25.day7;

import java.util.Objects;
import java.util.Set;

public class ManifoldNode {

  private int x;
  private int y;
  private ManifoldNode left;
  private ManifoldNode right;

  public ManifoldNode(int x, int y) {
    this.x = x;
    this.y = y;
    this.left = null;
    this.right = null;
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

  public Set<ManifoldNode> collect() {
    if (left == null && right == null) {
      // TODO
    }
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof ManifoldNode &&
        ((ManifoldNode) obj).x == this.x &&
        ((ManifoldNode) obj).y == this.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public int size() {
    if (left == null && right == null) {
      return 0;
    }
    System.out.println("(" + x + ", " + y + ")");
    int sizeLeft = left == null ? 0 : left.size();
    int sizeRight = right == null ? 0 : right.size();
    return 1 + sizeLeft + sizeRight;
  }

}
