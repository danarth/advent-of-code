package uk.danielarthur.aoc25.day8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JunctionConnector {

  public long calculate(List<String> input, int passes) {
    UnionFind uf = new UnionFind(input.size());
    Set<Point> allPoints = new HashSet<>();
    Map<Pair, Double> distances = new HashMap<>();
    for (int i = 0; i < input.size(); i++) {
      allPoints.add(Point.fromString(i, input.get(i)));
    }
    for (Point current : allPoints) {
      for (Point other : allPoints) {
        Pair pair = new Pair(current, other);
        if (!current.equals(other) && !distances.containsKey(pair)) {
          distances.put(pair, getEuclideanDistance(current, other));
        }
      }
    }
    List<Entry<Pair, Double>> sortedEdges = distances.entrySet().stream()
        .sorted((e1, e2) -> e1.getValue() < e2.getValue() ? -1 : 1)
        .toList();

    for (int i = 0; i < passes; i++) {
      Point[] points = sortedEdges.get(i).getKey().getPoints();
      uf.union(points[0].getId(), points[1].getId());
    }
    return Arrays.stream(uf.getParents())
      .map(uf::find)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
      .values().stream()
      .sorted(Comparator.comparingLong(i -> i))
      .sorted(Comparator.reverseOrder())
      .limit(3)
      .reduce(1l, (subtotal, element) -> subtotal * element);
  }

  public long calculatePart2(List<String> input) {
    UnionFind uf = new UnionFind(input.size());
    Set<Point> allPoints = new HashSet<>();
    Map<Pair, Double> distances = new HashMap<>();
    for (int i = 0; i < input.size(); i++) {
      allPoints.add(Point.fromString(i, input.get(i)));
    }
    for (Point current : allPoints) {
      for (Point other : allPoints) {
        Pair pair = new Pair(current, other);
        if (!current.equals(other) && !distances.containsKey(pair)) {
          distances.put(pair, getEuclideanDistance(current, other));
        }
      }
    }
    List<Entry<Pair, Double>> sortedEdges = distances.entrySet().stream()
        .sorted((e1, e2) -> e1.getValue() < e2.getValue() ? -1 : 1)
        .toList();

    int i = 0;
    while (i < sortedEdges.size() && !uf.isSingleTree()) {
      Point[] points = sortedEdges.get(i).getKey().getPoints();
      uf.union(points[0].getId(), points[1].getId());
      i++;
    }
    if (uf.isSingleTree()) {
      Point[] points = sortedEdges.get(i - 1).getKey().getPoints();
      return Integer.toUnsignedLong(points[0].getX()) * Integer.toUnsignedLong(points[1].getX());
    }
    return 0;
  }

  public double getEuclideanDistance(Point p1, Point p2) {
    return Math.sqrt(
        Math.pow(p1.getX() - p2.getX(), 2) +
            Math.pow(p1.getY() - p2.getY(), 2) +
            Math.pow(p1.getZ() - p2.getZ(), 2));
  }

}
