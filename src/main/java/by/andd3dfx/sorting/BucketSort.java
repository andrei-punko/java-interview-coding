package by.andd3dfx.sorting;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    private static final int BUCKETS_COUNT = 10;

    public static <T extends Comparable<T>> void apply(T[] items) {
        // Prepare empty buckets
        List<List<Comparable<T>>> buckets = new ArrayList<>(BUCKETS_COUNT);
        for (int i = 0; i < BUCKETS_COUNT; i++) {
            buckets.add(new ArrayList<>());
        }

        // Fill in buckets
        for (var t : items) {
            var bucketIndex = determineBucketIndex(t);
            buckets.get(bucketIndex).add(t);
        }

        int currIndex = 0;
        for (int bucketIndex = 0; bucketIndex < BUCKETS_COUNT; bucketIndex++) {
            var bucket = buckets.get(bucketIndex);

            // Sort elements in each bucket
            var array = bucket.toArray(new Comparable[0]);
            InsertionSort.apply(array);

            // Populate the result array with values from bucket
            for (var item : array) {
                items[currIndex] = (T) item;
                currIndex++;
            }
        }
    }

    /**
     * Not found better way, but sorter parameterized now
     */
    private static <T> int determineBucketIndex(Comparable<T> element) {
        if (element instanceof Integer) {
            return (int) ((BUCKETS_COUNT - 1) *
                    ((Integer) element - (double) Integer.MIN_VALUE) / ((double) Integer.MAX_VALUE - (double) Integer.MIN_VALUE));
        }
        if (element instanceof Long) {
            return (int) ((BUCKETS_COUNT - 1) *
                    ((Long) element - (double) Long.MIN_VALUE) / ((double) Long.MAX_VALUE - (double) Long.MIN_VALUE));
        }
        if (element instanceof Double) {
            return (int) ((BUCKETS_COUNT - 1) *
                    ((Double) element - Double.MIN_VALUE) / (Double.MAX_VALUE - Double.MIN_VALUE));
        }
        if (element instanceof Float) {
            return (int) ((BUCKETS_COUNT - 1) *
                    ((Float) element - Float.MIN_VALUE) / (Float.MAX_VALUE - Float.MIN_VALUE));
        }
        if (element instanceof Byte) {
            return (BUCKETS_COUNT - 1) *
                    ((Byte) element - Byte.MIN_VALUE) / (Byte.MAX_VALUE - Byte.MIN_VALUE);
        }
        if (element instanceof Short) {
            return (BUCKETS_COUNT - 1) *
                    ((Short) element - Byte.MIN_VALUE) / (Short.MAX_VALUE - Short.MIN_VALUE);
        }

        throw new UnsupportedOperationException("This type is not supported!");
    }
}
