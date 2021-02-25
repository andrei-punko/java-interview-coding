package by.andd3dfx.numeric;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MeanMedianMode {

    public static double mean(int[] data) {
        int N = data.length;
        double mean = 0;
        for (int i = 0; i < N; i++) {
            mean += data[i];
        }
        mean /= N;
        return mean;
    }

    public static double median(int[] data) {
        int N = data.length;
        Arrays.sort(data);
        double median = (N % 2 == 0) ?
                ((double) data[N / 2 - 1] + (double) data[N / 2]) / 2. : (double) data[N / 2];
        return median;
    }

    public static double mode(int[] data) {
        int N = data.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Integer count = freq.get(data[i]);
            if (count == null) {
                count = 0;
            }
            count++;
            freq.put(data[i], count);
        }
        int mode = data[0];
        for (Integer i : freq.keySet()) {
            if (freq.get(i) == freq.get(mode) && i<mode) {
                mode = i;
            }
            if (freq.get(i) > freq.get(mode)) {
                mode = i;
            }
        }
        return mode;
    }

    public static double quartile1(int[] data) {
        int N = data.length;
        int[] left = new int[N/2];
        Arrays.sort(data);
        System.arraycopy(data, 0, left, 0, N/2);
        return median(left);
    }

    public static double quartile2(int[] data) {
        return median(data);
    }

    public static double quartile3(int[] data) {
        int N = data.length;
        int[] right = new int[N/2];
        int pos = (N%2==0) ? N/2 : N/2+1;
        Arrays.sort(data);
        System.arraycopy(data, pos, right, 0, N/2);
        return median(right);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = scan.nextInt();
        }

        System.out.println("Mean = " + mean(data));
        System.out.println("Median = " + median(data));
        System.out.println("Mode = " + mode(data));
        System.out.println("Q1 = " + quartile1(data));
        System.out.println("Q2 = " + quartile2(data));
        System.out.println("Q3 = " + quartile3(data));
    }
}
