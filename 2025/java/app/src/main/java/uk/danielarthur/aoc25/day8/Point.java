package uk.danielarthur.aoc25.day8;

import java.util.Objects;

public class Point {

  private int id;
  private int x;
  private int y;
  private int z;

  private Point(int id, int x, int y, int z) {
    this.id = id;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public int getId() {
    return id;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getZ() {
    return z;
  }

  public static Point fromString(int id, String s) {
    String[] parts = s.split(",");
    return new Point(
        id,
        Integer.parseInt(parts[0]),
        Integer.parseInt(parts[1]),
        Integer.parseInt(parts[2]));
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ", " + z + ")";
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Point other = (Point) obj;
    if (x != other.x)
      return false;
    if (y != other.y)
      return false;
    if (z != other.z)
      return false;
    return true;
  }

}
