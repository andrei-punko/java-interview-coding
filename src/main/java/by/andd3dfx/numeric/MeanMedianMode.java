package by.andd3dfx.numeric;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MeanMedianMode {

    public static double mean(int[] items) {
        return Arrays.stream(items).sum() / items.length;
    }

    public static double median(int[] items) {
        Arrays.sort(items);

        int n = items.length;
        if (n % 2 == 0) {
            return (items[n / 2 - 1] + items[n / 2]) / 2.0;
        }
        return items[n / 2];
    }

    public static double mode(int[] items) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int item : items) {
            Integer count = freq.get(item);
            if (count == null) {
                count = 0;
            }
            count++;
            freq.put(item, count);
        }

        int mode = items[0];
        for (var key : freq.keySet()) {
            if (freq.get(key) == freq.get(mode) && key < mode) {
                mode = key;
            }
            if (freq.get(key) > freq.get(mode)) {
                mode = key;
            }
        }
        return mode;
    }

    public static double quartile1(int[] data) {
        int n = data.length;
        int[] left = new int[n / 2];
        Arrays.sort(data);
        System.arraycopy(data, 0, left, 0, n / 2);
        return median(left);
    }

    public static double quartile2(int[] items) {
        return median(items);
    }

    public static double quartile3(int[] items) {
        int n = items.length;
        int[] right = new int[n / 2];
        Arrays.sort(items);
        int pos = (n % 2 == 0) ? (n / 2) : (n / 2 + 1);
        System.arraycopy(items, pos, right, 0, n / 2);
        return median(right);
    }
}
