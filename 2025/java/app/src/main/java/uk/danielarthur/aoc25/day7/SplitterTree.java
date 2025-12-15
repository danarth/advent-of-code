package uk.danielarthur.aoc25.day7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitterTree {

  private String value;
  private SplitterTree left;
  private SplitterTree right;

  public SplitterTree(String value) {
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

  public Set<String> collectParents() {
    return collectParents(new HashSet<>());
  }

  private Set<String> collectParents(Set<String> visited) {
    if (!visited.add(value)) {
      return Set.of();
    }
    if (left == null && right == null) {
      return Set.of();
    }
    Set<String> output = new HashSet<>();
    output.add(value);
    output.addAll(left.collectParents(visited));
    output.addAll(right.collectParents(visited));
    return output;
  }

  public List<List<String>> getPossiblePaths() {
    List<List<String>> allPaths = new ArrayList<>();
    getPossiblePaths(allPaths, new ArrayList<>());
    return allPaths;
  }

  private void getPossiblePaths(List<List<String>> allPaths, List<String> currentPath) {
    List<String> currentPathCopy = new ArrayList<>(currentPath);
    currentPathCopy.add(value);
    if (left == null && right == null) {
      allPaths.add(currentPathCopy);
    } else {
      left.getPossiblePaths(allPaths, (currentPathCopy));
      right.getPossiblePaths(allPaths, (currentPathCopy));
    }
  }

  public SplitterTree getLeft() {
    return left;
  }

  public void setLeft(SplitterTree left) {
    this.left = left;
  }

  public SplitterTree getRight() {
    return right;
  }

  public void setRight(SplitterTree right) {
    this.right = right;
  }

  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof SplitterTree &&
        ((SplitterTree) obj).value.equals(this.value);
  }

  @Override
  public int hashCode() {
    return this.value.hashCode();
  }

}
