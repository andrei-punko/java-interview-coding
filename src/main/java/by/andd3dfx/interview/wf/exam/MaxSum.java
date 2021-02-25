package by.andd3dfx.interview.wf.exam;

/*
Implement the findMaxSum method that returns the largest sum of any two elements in the given list of positive numbers.

For example, the largest sum of the list {5, 9, 7, 11} is the sum of the elements 9 and 11, which is 20.
 */

import java.util.Arrays;
import java.util.List;

public class MaxSum {

  public static int findMaxSum(List<Integer> list) {
    if (list == null || list.isEmpty()) {
      return 0;
    }

    if (list.size() == 1) {
      return list.get(0);
    }

    Integer m1 = Math.max(list.get(0), list.get(1));
    Integer m2 = Math.min(list.get(0), list.get(1));

    if (list.size() == 2) {
      return m1 + m2;
    }

    for (int i = 2; i < list.size(); i++) {
      if (list.get(i) > m1 || list.get(i) > m2) {
        if (list.get(i) > m1) {
          m2 = m1;
          m1 = list.get(i);
        } else {
          m2 = list.get(i);
        }
      }
    }
    return m1 + m2;
  }

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(-5, -10, 7);
    System.out.println(findMaxSum(list));
  }
}
