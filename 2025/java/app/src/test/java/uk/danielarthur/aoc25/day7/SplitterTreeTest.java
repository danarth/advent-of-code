package uk.danielarthur.aoc25.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SplitterTreeTest {

  /*
   
      a
     / \
    b   c
   / \ / \
  d   e   f

  a -> b -> d
  a -> b -> e
  a -> c -> e
  a -> c -> f
   */
  @Test void testGetNumOfPaths() {
    var a = new SplitterTree("a");
    var b = new SplitterTree("b");
    var c = new SplitterTree("c");
    var d = new SplitterTree("d");
    var e = new SplitterTree("e");
    var f = new SplitterTree("f");

    b.setLeft(d);
    b.setRight(e);
    c.setLeft(e);
    c.setRight(f);
    a.setLeft(b);
    a.setRight(c);

    assertEquals(4, a.getPossiblePaths().size());
  }
  
}
