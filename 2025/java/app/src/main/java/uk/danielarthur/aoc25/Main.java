package uk.danielarthur.aoc25;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import uk.danielarthur.aoc25.day1.PasswordGenerator;

public class Main {
  public static void main(String[] args) {
    InputStream input = Main.class.getResourceAsStream("day1/input.txt");
    List<String> puzzleInput = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8))
      .lines().collect(Collectors.toList());
    PasswordGenerator pg = new PasswordGenerator(puzzleInput);
    System.out.println("Part 1: " + pg.generatePassword());
    System.out.println("Part 2: " + pg.generateAdvancedPassword());
  }
}
