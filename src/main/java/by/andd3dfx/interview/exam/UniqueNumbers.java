package by.andd3dfx.interview.exam;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a method that finds all numbers that occur exactly once in the input collection
 * <p>
 * For example, findUniqueNumbers(Arrays.asList(1, 2, 1, 3)) should return { 2, 3 }.
 */
public class UniqueNumbers {

  public static Collection<Integer> findUniqueNumbers(Collection<Integer> numbers) {
    Set<Integer> setNum = new HashSet<>();
    Set<Integer> exists = new HashSet<>();

    for (Integer i : numbers) {
      if (exists.contains(i) || !setNum.add(i)) {
        setNum.remove(i);
        exists.add(i);
      }
    }
    return setNum;
  }
}
