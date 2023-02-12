package by.andd3dfx.sorting;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    private static final int BUCKETS_COUNT = 10;

    public static <T extends Comparable> void apply(T[] items) {
        // Prepare empty buckets
        List<List<Comparable>> buckets = new ArrayList<>(BUCKETS_COUNT);
        for (int i = 0; i < BUCKETS_COUNT; i++) {
            buckets.add(new ArrayList<>());
        }

        // Fill in buckets
        for (int i = 0; i < items.length; i++) {
            buckets.get(determineBucketIndex(items[i], BUCKETS_COUNT)).add(items[i]);
        }

        int currIndex = 0;
        for (int bucketIndex = 0; bucketIndex < BUCKETS_COUNT; bucketIndex++) {
            List<Comparable> bucket = buckets.get(bucketIndex);

            // Sort elements in each bucket
            Comparable[] array = bucket.toArray(new Comparable[0]);
            InsertionSort.apply(array);

            // Populate result array with values from bucket
            for (var item : array) {
                items[currIndex] = (T) item;
                currIndex++;
            }
        }
    }

    /**
     * Not found better way, but sorter parameterized now
     */
    private static int determineBucketIndex(Comparable element, int bucketsCount) {
        if (element instanceof Integer) {
            return (int) ((bucketsCount - 1) *
                    ((Integer) element - (double) Integer.MIN_VALUE) / ((double) Integer.MAX_VALUE - (double) Integer.MIN_VALUE));
        }
        if (element instanceof Long) {
            return (int) ((bucketsCount - 1) *
                    ((Long) element - (double) Long.MIN_VALUE) / ((double) Long.MAX_VALUE - (double) Long.MIN_VALUE));
        }
        if (element instanceof Double) {
            return (int) ((bucketsCount - 1) *
                    ((Double) element - Double.MIN_VALUE) / (Double.MAX_VALUE - Double.MIN_VALUE));
        }
        if (element instanceof Float) {
            return (int) ((bucketsCount - 1) *
                    ((Float) element - Float.MIN_VALUE) / (Float.MAX_VALUE - Float.MIN_VALUE));
        }
        if (element instanceof Byte) {
            return (bucketsCount - 1) *
                    ((Byte) element - Byte.MIN_VALUE) / (Byte.MAX_VALUE - Byte.MIN_VALUE);
        }
        if (element instanceof Short) {
            return (bucketsCount - 1) *
                    ((Short) element - Byte.MIN_VALUE) / (Short.MAX_VALUE - Short.MIN_VALUE);
        }

        throw new UnsupportedOperationException("This type is not supported!");
    }
}
