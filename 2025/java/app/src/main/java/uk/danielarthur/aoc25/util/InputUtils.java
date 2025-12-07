package uk.danielarthur.aoc25.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public abstract class InputUtils {
  
  private static final String DEFAULT_INPUT_FILE = "input.txt";

  public static List<String> getInputAsList(Class<?> cls) {
    return getInputAsList(cls, DEFAULT_INPUT_FILE);
  }

  public static List<String> getInputAsList(Class<?> cls, String path) {
    try (BufferedReader br = getBufferedReader(cls, path)) {
      return br.lines().collect(Collectors.toList());
    } catch (IOException e) {
      return null;
    }
  }

  public static String getInputAsString(Class<?> cls) {
    return getInputAsString(cls, DEFAULT_INPUT_FILE);
  }

  public static String getInputAsString(Class<?> cls, String path) {
    try (BufferedReader br = getBufferedReader(cls, path)) {
      return br.lines().collect(Collectors.joining());
    } catch (IOException e) {
      return null;
    }
  }

  public static char[][] getInputAsCharMap(Class<?> cls) {
    return getInputAsCharMap(cls, DEFAULT_INPUT_FILE);
  }

  public static char[][] getInputAsCharMap(Class<?> cls, String path) {
    List<String> inputAsList = getInputAsList(cls, path);
    int height = inputAsList.size();
    int width = inputAsList.get(0).length();
    char[][] map = new char[width][height];
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        map[x][y] = inputAsList.get(y).charAt(x);
      }
    }
    return map;
  }

  private static BufferedReader getBufferedReader(Class<?> cls, String path) {
    InputStream input = cls.getResourceAsStream(path);
    return new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
  }
  
}
