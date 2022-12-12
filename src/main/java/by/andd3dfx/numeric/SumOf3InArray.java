package by.andd3dfx.numeric;

import lombok.Builder;

import static java.util.Arrays.binarySearch;

/**
 * Даны массивы a[], b[], c[] и число N.
 * Найти такие индексы i,j,k, что выполняется условие: a[i] + b[j] + c[k] == N
 */
public class SumOf3InArray {

    public SearchResult find(int[] a, int[] b, int[] c, int N) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int k = binarySearch(c, N - a[i] - b[j]);
                if (k >= 0) {
                    return SearchResult.builder()
                            .indexes(new int[]{i, j, k})
                            .exists(true)
                            .build();
                }
            }
        }
        return SearchResult.builder().build();
    }

    @Builder
    public static class SearchResult {
        boolean exists;
        int[] indexes;
    }
}
