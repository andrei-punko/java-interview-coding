package by.andd3dfx.sorting;

import java.util.ArrayList;
import java.util.List;

public class BucketSort extends AbstractSort {

  private final int BUCKETS_COUNT = 10;

  @Override
  public void sort() {
    // Prepare empty buckets
    List<List<Long>> buckets = new ArrayList<>(BUCKETS_COUNT);
    for (int i = 0; i < BUCKETS_COUNT; i++) {
      buckets.add(new ArrayList<>());
    }

    // Fill in buckets
    for (int i = 0; i < items.length; i++) {
      buckets.get(determineBucketIndex(items[i], BUCKETS_COUNT)).add(items[i]);
    }

    int currIndex = 0;
    for (int bucketIndex = 0; bucketIndex < BUCKETS_COUNT; bucketIndex++) {
      List<Long> bucket = buckets.get(bucketIndex);

      // Sort elements in each bucket
      InsertionSort insertionSort = new InsertionSort();
      insertionSort.insert(bucket);
      insertionSort.sort();

      // Populate result array with values from bucket
      for (long item : insertionSort.items) {
        items[currIndex] = item;
        currIndex++;
      }
    }
  }

  private int determineBucketIndex(long element, int bucketsCount) {
    return (int) ((bucketsCount - 1) *
        ((double) element - (double) Long.MIN_VALUE) / ((double) Long.MAX_VALUE - (double) Long.MIN_VALUE));
  }
}
