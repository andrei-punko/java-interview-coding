package by.andd3dfx.interview.wf.exam;

import java.util.HashMap;
import java.util.Map;

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

  public static void main(String[] args) {
    System.out.println(combinations(6));
  }
}
