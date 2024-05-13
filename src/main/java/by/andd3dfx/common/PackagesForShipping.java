package by.andd3dfx.common;

import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * A large package can hold five items, while the small package can hold only one item.
 * All items must be placed in packages and used packages have to be filled up completely.
 *
 * Write a function that calculates the minimum number of packages needed to hold a given number of items.
 * If it's not possible to meet the requirements, return -1.
 *
 * For example, if we have 16 items, 2 large and 10 small packages, the function should return 8
 * (2 large packages + 6 small packages).
 * </pre>
 *
 * @see <a href="https://youtu.be/ZDntf64fW5Q">Video solution</a>
 */
@RequiredArgsConstructor
public class PackagesForShipping {

  private final int NEGATIVE_RESULT = -1;
  private final int largePackageCapacity;
  private final int smallPackageCapacity;

  public int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
    if (items < 0 || availableLargePackages < 0 || availableSmallPackages < 0) {
      return NEGATIVE_RESULT;
    }

    int possibleLargePackages = items / largePackageCapacity;
    int largePackages = Math.min(possibleLargePackages, availableLargePackages);
    items -= largePackages * largePackageCapacity;

    int possibleSmallPackages = items / smallPackageCapacity;
    int smallPackages = Math.min(possibleSmallPackages, availableSmallPackages);
    items -= smallPackages * smallPackageCapacity;

    if (items == 0) {
      return largePackages + smallPackages;
    }
    return NEGATIVE_RESULT;
  }
}
