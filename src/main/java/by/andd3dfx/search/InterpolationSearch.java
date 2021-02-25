package by.andd3dfx.search;

/*
 Implement interpolation search. Return element index or -1 if it's not exist
 */
public class InterpolationSearch {

  public static int perform(int[] array, int target) {
    int min = 0;
    int max = array.length - 1;
    int steps = 0;

    try {
      while (min <= max) {
        int mid = (array[max] == array[min]) ? min :
            min + (max - min) * (target - array[min]) / (array[max] - array[min]);
        if (mid < min) {
          mid = min;
        }
        if (mid > max) {
          mid = max;
        }

        if (array[mid] == target) {
          return mid;
        }
        if (array[mid] < target) {
          min = mid + 1;
        } else {
          max = mid - 1;
        }

        steps++;
      }
      return -1;
    } finally {
      System.out.println("Interpolation search steps count: " + steps);
    }
  }
}
