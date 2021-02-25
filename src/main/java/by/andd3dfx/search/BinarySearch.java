package by.andd3dfx.search;

/**
 * Implement binary search. Return element index or -1 if it's not exist
 */
public class BinarySearch {

  public static int search(int[] array, int element) {
    int left = 0;
    int right = array.length;
    int steps = 0;

    try {
      do {
        int middle = (left + right) / 2;
        if (array[middle] == element) {
          return middle;
        }
        if (array[middle] < element) {
          left = middle;
        } else {
          right = middle;
        }
        steps++;
      } while (right - left > 1);

      return -1;
    } finally {
      System.out.println("Binary search steps count: " + steps);
    }
  }
}
