package by.andd3dfx.interview.wf.exam;

/*
A large package can hold five items, while the small package can hold only one item. All items must be placed in
packages and used packages have to be filled up completely.

Write a function that calculates the minimum number of packages needed to hold a given number of items. If it's not
possible to meet the requirements, return -1.

For example, if we have 16 items, 2 large and 10 small packages, the function should return 8 (2 large packages +
6 small packages).
 */
public class Shipping {

  public static final int LARGE_PACKAGE = 5;
  public static final int SMALL_PACKAGE = 1;
  private static final int WRONG_NUMBER = -1;

  public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {

    if (items < 0 || availableLargePackages < 0 || availableSmallPackages < 0) {
      return WRONG_NUMBER;
    }

    int numberOfPossibleLargePackage = items / LARGE_PACKAGE;
    int result = Math.min(numberOfPossibleLargePackage, availableLargePackages);

    items -= result * LARGE_PACKAGE;

    if (items > availableSmallPackages) {
      return WRONG_NUMBER;
    }
    result += items;

    return result;
  }

  public static void main(String[] args) {
    System.out.println(minimalNumberOfPackages(16, 2, 10));
  }
}
