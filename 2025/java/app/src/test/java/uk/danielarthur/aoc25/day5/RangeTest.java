package uk.danielarthur.aoc25.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

public class RangeTest {

  @Test void testMergeAllOverlappingRanges() {
    List<Range> ranges = List.of(
      new Range(2, 4),
      new Range(6, 8),
      new Range(3, 7)
    );
    List<Range> output = Range.mergeAll(ranges);
    assertEquals(1, output.size());
    assertEquals(2, output.get(0).getMin());
    assertEquals(8, output.get(0).getMax());
  }

  @Test void testMergeAllIndependentRanges() {
    List<Range> ranges = List.of(new Range(3, 5), new Range(10, 14));
    List<Range> output = Range.mergeAll(ranges);
    assertEquals(2, output.size());
    assertEquals(new Range(3, 5), output.get(0));
    assertEquals(new Range(10, 14), output.get(1));
  }

  @Test void testMergeAllAdjacentRanges() {
    List<Range> ranges = List.of(new Range(3, 5), new Range(5, 14));
    List<Range> output = Range.mergeAll(ranges);
    assertEquals(1, output.size());
    assertEquals(new Range(3, 14), output.get(0));
  }

  @Test void testMergeAllWithDupes() {
    List<Range> ranges = List.of(new Range(1, 6), new Range(3, 6));
    List<Range> output = Range.mergeAll(ranges);
    assertEquals(1, output.size());
    assertEquals(new Range(1, 6), output.get(0));
  }

  @Test void testMergeAllWithBigDupes() {
    List<Range> ranges = List.of(
      new Range(383043617664892l, 389277822354893l),
      new Range(387921155483286l, 389277822354893l)
    );
    List<Range> output = Range.mergeAll(ranges);
    assertEquals(1, output.size());
    assertEquals(new Range(383043617664892l, 389277822354893l), output.get(0));
  }
  
  @Test void testIsOverlap() {
    Range r = new Range(3, 5);
    assertFalse(r.isOverlap(new Range(10, 14)));
  }

}
