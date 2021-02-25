package by.andd3dfx.interview.wf.exam;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

  public static void main(String[] args) {
    Collection<Integer> numbers = Arrays.asList(1, 2, 1, 3);
    for (int number : findUniqueNumbers(numbers)) {
      System.out.println(number);
    }
  }
}
