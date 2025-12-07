package uk.danielarthur.aoc25.day2;

public class ProductChecker {

  public long getInvalidProducts(String ranges) {
    String[] splitRanges = ranges.split(",");
    long sum = 0;
    for(int i = 0; i < splitRanges.length; i++) {
      String[] boundaries = splitRanges[i].split("-");
      long lower = Long.parseLong(boundaries[0]);
      long upper = Long.parseLong(boundaries[1]);
      for(long j = lower; j <= upper; j++) {
        if (isRepeatingString(Long.toString(j))) {
          sum += j;
        }
      }
    }
    return sum;
  }

  public long getInvalidProductsAdvanced(String ranges) {
    String[] splitRanges = ranges.split(",");
    long sum = 0;
    for(int i = 0; i < splitRanges.length; i++) {
      String[] boundaries = splitRanges[i].split("-");
      long lower = Long.parseLong(boundaries[0]);
      long upper = Long.parseLong(boundaries[1]);
      for(long j = lower; j <= upper; j++) {
        if (isRepeatingStringMultiple(Long.toString(j))) {
          sum += j;
        }
      }
    }
    return sum;
  }

  private boolean isRepeatingStringMultiple(String s) {
    int length = s.length();
    for (int i = length / 2; i > 0; i--) {
      if ((length % i) != 0) continue;
      String chunkToTest = s.substring(0, i);
      int numRepeats = length / i;
      boolean isMatch = true;
      for (int j = 1; j < numRepeats; j++) {
        int start = chunkToTest.length() * j;
        String nextBit = s.substring(start, start + chunkToTest.length());
        if (!chunkToTest.equals(nextBit)) {
          isMatch = false;
        }
      }
      if (isMatch == true) {
        return true;
      }
    }
    return false;
  }

  private boolean isRepeatingString(String s) {
    int length = s.length();
    if ((length % 2) != 0) return false;
    
    String firstHalf = s.substring(0, length / 2);
    String secondHalf = s.substring(length / 2);

    return firstHalf.equals(secondHalf);
  }
  
}
