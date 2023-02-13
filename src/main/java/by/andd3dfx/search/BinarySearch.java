package by.andd3dfx.search;

/**
 * Implement binary search in sorted array. Return element index or -1 if it doesn't exist
 */
public class BinarySearch {

  public static int perform(int[] array, int target) {
    int left = 0;
    int right = array.length;
    int steps = 0;

    try {
      do {
        steps++;

        int middle = (left + right) / 2;
        if (array[middle] == target) {
          return middle;
        }
        if (array[middle] < target) {
          left = middle;
        } else {
          right = middle;
        }
      } while (right - left > 1);

      return -1;
    } finally {
      System.out.println("target: " + target + ", total steps count: " + steps);
    }
  }
}
