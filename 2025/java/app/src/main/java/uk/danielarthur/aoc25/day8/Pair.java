package uk.danielarthur.aoc25.day8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pair {

  private Set<Point> set;

  public Pair(Point p1, Point p2) {
    this.set = new HashSet<>();
    this.set.add(p1);
    this.set.add(p2);
  }

  public Point[] getPoints() {
    return set.toArray(new Point[2]);
  }

  @Override
  public String toString() {
    List<Point> p = set.stream().toList();
    return p.getFirst() + " -> " + p.getLast();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((set == null) ? 0 : set.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Pair other = (Pair) obj;
    if (set == null) {
      if (other.set != null)
        return false;
    } else if (!set.equals(other.set))
      return false;
    return true;
  }

}
