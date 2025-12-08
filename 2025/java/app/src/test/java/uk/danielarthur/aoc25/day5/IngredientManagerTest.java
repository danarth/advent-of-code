package uk.danielarthur.aoc25.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import uk.danielarthur.aoc25.util.InputUtils;

public class IngredientManagerTest {

  @Test void testGetFreshIngredientsWithRealInput() {
    List<List<String>> input = InputUtils.getInputAsDoubleList(this.getClass());
    IngredientManager im = new IngredientManager();
    assertEquals(3, im.getFreshIngredients(input.get(0), input.get(1)));
  }

  @Test void testGetAllFreshIngredientsWithRealInput() {
    List<List<String>> input = InputUtils.getInputAsDoubleList(this.getClass());
    IngredientManager im = new IngredientManager();
    assertEquals(14, im.getAllFreshIngredients(input.get(0)));
  }
  
}
