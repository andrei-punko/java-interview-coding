package by.andd3dfx.search;

/*
Implement function countNumbers that accepts a sorted array of integers and counts the number of array elements that
are less than the parameter lessThan.

For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array
elements less than 4.
 */
public class SortedSearch {

  public static int countNumbers(int[] sortedArray, int lessThan) {
    int leftIndex = 0;
    int rightIndex = sortedArray.length - 1;

    while (rightIndex - leftIndex > 1) {
      int index = (leftIndex + rightIndex) / 2;
      if (sortedArray[index] < lessThan) {
        leftIndex = index;
      } else {
        rightIndex = index;
      }
    }

    if (sortedArray[rightIndex] < lessThan) {
      return rightIndex + 1;
    }
    if (sortedArray[leftIndex] < lessThan) {
      return leftIndex + 1;
    }
    return leftIndex;
  }

  public static void main(String[] args) {
    System.out.println(SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4));
  }
}
