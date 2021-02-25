package by.andd3dfx.interview.train2021;

import static java.util.Arrays.binarySearch;

/**
 * Даны массивы a[], b[], c[] и число N.
 * Найти такие индексы i,j,k, что выполняется условие: a[i] + b[j] + c[k] == N
 */
public class FindIndexesForSum {

    public int[] find(int[] a, int[] b, int[] c, int N) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int k = binarySearch(c, N - a[i] - b[j]);
                if (k >= 0) {
                    return new int[]{i, j, k};
                }
            }
        }
        throw new RuntimeException("Indexes set does not exist!");
    }
}
