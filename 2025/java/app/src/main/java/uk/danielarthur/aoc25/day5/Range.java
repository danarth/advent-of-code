package uk.danielarthur.aoc25.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Range {

  private long min;
  private long max;

  public Range(long min, long max) {
    this.min = min;
    this.max = max;
  }

  public boolean contains(long number) {
    return number >= min && number <= max;
  }

  public boolean isOverlap(Range other) {
    return this.contains(other.min) || this.contains(other.max) || other.contains(this.min) || other.contains(this.max);
  }

  public boolean fullyContains(Range other) {
    return contains(other.getMin()) && contains(other.getMax());
  }

  public long getMin() {
      return min;
  }

  public long getMax() {
      return max;
  }

  public Range join(Range r) {
    return new Range(
      Long.min(this.min, r.min),
      Long.max(this.max, r.max)
    );
  }

  public static Range join(Range r1, Range r2) {
    return new Range(
      Long.min(r1.min, r2.min),
      Long.max(r1.max, r2.max)
    );
  }

  public static Range fromString(String s) {
      String[] bounds = s.split("-");
      return new Range(Long.parseLong(bounds[0]), Long.parseLong(bounds[1]));
  }

  public static List<Range> mergeAll(List<Range> input) {
    List<Range> sorted = input.stream().sorted((r1, r2) -> r1.getMin() < r2.getMin() ? -1 : 1).toList();
    List<Range> merged = new ArrayList<>();
    for (Range r : sorted) {
      if (merged.isEmpty()) {
        merged.add(r);
      } else {
        Range lastMerged = merged.getLast();
        if(lastMerged.isOverlap(r)) {
          merged.set(merged.size() - 1, lastMerged.join(r));
        } else {
          merged.add(r);
        }
      }
    }
    return merged;
  }

  @Override
  public int hashCode() {
    return Objects.hash(min, max);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Range && ((Range) obj).getMin() == min && ((Range) obj).getMax() == max;
  }

  @Override
  public String toString() {
    return min + "-" + max;
  }

}
