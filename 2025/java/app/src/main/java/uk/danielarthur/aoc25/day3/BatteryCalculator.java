package uk.danielarthur.aoc25.day3;

import java.util.List;

public class BatteryCalculator {

  public int calculate(List<String> batteryBank) {
    int sum = 0;
    for(String bank : batteryBank) {
      int firstBattery = getMaxNumber(bank.substring(0, bank.length() - 1));
      int position = bank.indexOf(String.valueOf(firstBattery));
      int secondBattery = getMaxNumber(bank.substring(position + 1, bank.length()));
      sum += Integer.parseInt((String.valueOf(firstBattery) + String.valueOf(secondBattery)));
    }
    return sum;
  }

  public long calculateLargeJoltage(List<String> batteryBank) {
    long sum = 0;
    int numBatteries = 12;
    for(String bank : batteryBank) {
      int startIndex = 0;
      String thisBank = "";
      for (int remainingBatteries = numBatteries; remainingBatteries > 0; remainingBatteries--) {
        int maxIndex = getIndexOfMaxNumber(bank, startIndex, bank.length() - remainingBatteries + 1);
        thisBank += bank.charAt(maxIndex);
        startIndex = maxIndex + 1;
      }
      sum += Long.parseLong(thisBank);
    }
    return sum;
  }

  private int getIndexOfMaxNumber(String s, int startIndex, int endIndex) {
    int max = 0;
    int index = startIndex;
    for (int i = startIndex; i < endIndex; i++) {
      int value = Integer.parseInt(String.valueOf(s.charAt(i)));
      if (value > max) {
        max = value;
        index = i;
      }
    }
    return index;
  }

  private int getMaxNumber(String s) {
    int max = 0;
    for (char c : s.toCharArray()) {
      int value = Integer.parseInt(String.valueOf(c));
      if (value > max) {
        max = value;
      }
    }
    return max;
  }

}
