package uk.danielarthur.aoc25.day5;

import java.util.List;

public class IngredientManager {

  public int getFreshIngredients(List<String> freshRanges, List<String> ingredients) {
    int count = 0;
    List<Range> allRanges = freshRanges.stream().map(Range::fromString).toList();

    for (String ingredient : ingredients) {
      boolean found = false;
      int i = 0;
      while (i < allRanges.size() && !found) {
        if (allRanges.get(i).contains(Long.parseLong(ingredient))) {
          count++;
          found = true;
        }
        i++;
      }
    }
    return count;
  }

  public long getAllFreshIngredients(List<String> freshRanges) {
    List<Range> allRanges = freshRanges.stream().map(Range::fromString).toList();
    List<Range> condensedRanges = Range.mergeAll(allRanges);
    long count = 0;
    for (Range range : condensedRanges) {
      long thiscount = range.getMax() + 1 - range.getMin();
      assert thiscount > 0;
      count += (range.getMax() + 1 - range.getMin());
    }
    return count;
  }

}
