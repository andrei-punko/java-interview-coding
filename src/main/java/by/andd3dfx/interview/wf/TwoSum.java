package by.andd3dfx.interview.wf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Write a function that, given a list and a target sum, returns zero-based indices of any two distinct elements whose sum
is equal to the target sum. If there are no such elements, the function should return null.

For example, findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12) should return a single dimensional array with two elements and
contain any of the following pairs of indices:
    1 and 4 (3 + 9 = 12)
    2 and 3 (5 + 7 = 12)
    3 and 2 (7 + 5 = 12)
    4 and 1 (9 + 3 = 12)
 */
public class TwoSum {

  public static int[] findTwoSum(int[] list, int sum) {
    Map<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < list.length; i++) {
      int item = list[i];
      List<Integer> indexes = map.get(item);
      if (indexes == null) {
        indexes = new ArrayList<>();
        map.put(item, indexes);
      }
      indexes.add(i);
    }

    for (Integer key : map.keySet()) {
      int remainderToFind = sum - key;
      if (map.containsKey(remainderToFind)) {
        if (remainderToFind == key) {
          if (map.get(key).size() < 2) {
            continue;
          }
          return new int[]{map.get(key).get(0), map.get(key).get(1)};
        }
        return new int[]{map.get(key).get(0), map.get(remainderToFind).get(0)};
      }
    }

    return null;
  }

  public static void main(String[] args) {
    int[] indices = findTwoSum(new int[]{1, 3, 5, 7, 9}, 12);
    if (indices != null) {
      System.out.println(indices[0] + " " + indices[1]);
    }
  }
}
