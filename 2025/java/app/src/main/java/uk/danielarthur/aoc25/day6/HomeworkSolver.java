package uk.danielarthur.aoc25.day6;

import java.util.ArrayList;
import java.util.List;

public class HomeworkSolver {

  public long solve(List<String> input) {
    List<List<String>> problems = input.stream().map(s -> List.of(s.trim().split("\\s+"))).toList();
    long sum = 0;
    for (int x = 0; x < problems.get(0).size(); x++) {
      String operator = problems.get(problems.size() - 1).get(x);
      List<Long> operands = new ArrayList<>();
      for (int y = 0; y < problems.size() - 1; y++) {
        operands.add(Long.parseLong(problems.get(y).get(x)));
      }
      sum += calculate(operator, operands);
    }
    return sum;
  }

  public long solveCephalopod(List<String> input) {
    String operators = input.getLast();
    long sum = 0;
    int i = 0;
    while (i < operators.length()) {
      char operator = operators.charAt(i);
      if (operator == ' ') {
        i++;
        continue;
      }
      int j = i + 1;
      boolean foundNextOperator = false;
      while (j < operators.length() && !foundNextOperator) {
        if (operators.charAt(j) == ' ') {
          j++;
          continue;
        }
        foundNextOperator = true;
      }

      List<Long> numbers = new ArrayList<>();
      int upperLimit = foundNextOperator ? j - 2 : j - 1;
      for (int k = upperLimit; k >= i; k--) {
        String number = "";
        for (int y = 0; y < input.size() - 1; y++) {
          if (input.get(y).charAt(k) != ' ') {
            number += input.get(y).charAt(k);
          }
        }
        numbers.add(Long.parseLong(number));
      }
      sum += calculate(String.valueOf(operator), numbers);
      i = j;
    }
    return sum;
  }

  private long calculate(String operator, List<Long> numbers) {
    if (numbers.isEmpty())
      return 0;
    long res = numbers.getFirst();
    for (int i = 1; i < numbers.size(); i++) {
      if ("*".equals(operator)) {
        res *= numbers.get(i);
      } else if ("+".equals(operator)) {
        res += numbers.get(i);
      }
    }
    return res;
  }

}
