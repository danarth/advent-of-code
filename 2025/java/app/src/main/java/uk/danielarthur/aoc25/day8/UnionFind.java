package uk.danielarthur.aoc25.day8;

import java.util.Arrays;

public class UnionFind {

  private int[] parent;

  public UnionFind(int size) {
    this.parent = new int[size];
    for (int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  public int find(int i) {
    if (parent[i] == i) {
      return i;
    }
    return find(parent[i]);
  }

  public void union(int i, int j) {
    int irep = find(i);
    int jrep = find(j);
    parent[irep] = jrep;
  }

  public int[] getParents() {
    return parent;
  }

  public boolean isSingleTree() {
    return Arrays.stream(parent).map(this::find).distinct().count() == 1l;
  }

}
