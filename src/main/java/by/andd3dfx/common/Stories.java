package by.andd3dfx.common;

import java.util.HashMap;
import java.util.Map;

/**
 * An industrial building is being divided up and converted into apartments. A large apartment takes up two stories
 * of the building, and a small apartment takes up one story.
 * <p>
 * Write a function that, given the number of stories in the building, calculates the number of different apartment
 * combinations.
 * <p>
 * For example, if the building is three stories high it can accommodate three different apartment combinations:
 * small-small-small, small-large and large-small.
 */
public class Stories {

  private static Map<Integer, Integer> cache = new HashMap<>();

  public static int combinations(int numberOfStories) {
    return fibonacci(numberOfStories + 1);
  }

  static int fibonacci(int n) {
    Integer value = cache.get(n);
    if (value != null) {
      return value;
    }

    if (n <= 1) {
      return n;
    }

    int result = fibonacci(n - 1) + fibonacci(n - 2);
    cache.put(n, result);
    return result;
  }
}
