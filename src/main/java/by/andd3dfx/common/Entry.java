package by.andd3dfx.common;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <pre>
 * Implement a class Entry that will be used as a part of a larger simulation of a passport checkpoint.
 *
 * The class Entry needs to contain the following methods:
 * • void enter(String passportNumber) - puts the specified passport number at the end of the line.
 * • String exit() - removes the passport from the queue and returns the passport. If no passports are in the queue,
 * null should be returned.
 *
 * For example, the following code snippet should write "AB54321", "UK32032":
 *   Entry entry = new Entry();
 *   entry.enter("AB54321");
 *   entry.enter("UK32032");
 *
 *   System.out.println(entry.Exit());
 *   System.out.println(entry.Exit());
 * </pre>
 */
public class Entry {

  private Queue<String> queue = new ArrayDeque<>();

  public void enter(String passportNumber) {
    queue.add(passportNumber);
  }

  public String exit() {
    if (queue.isEmpty()) {
      return null;
    }
    return queue.remove();
  }
}
