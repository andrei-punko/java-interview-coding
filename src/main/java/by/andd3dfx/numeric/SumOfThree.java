package by.andd3dfx.numeric;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;

/**
 * <pre>
 * Даны массивы a[], b[], c[] и число N.
 * Найти такие индексы i,j,k, что выполняется условие: a[i] + b[j] + c[k] == N
 * </pre>
 *
 * @see <a href="https://youtu.be/P-2jXiQ1OFo">Video solution</a>
 */
public class SumOfThree {

    public static SearchResult find_N3(int[] a, int[] b, int[] c, int N) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    if (a[i] + b[j] + c[k] == N) {
                        return SearchResult.builder()
                            .exists(true)
                            .indexes(new int[]{i, j, k})
                            .build();
                    }
                }
            }
        }
        return SearchResult.builder().build();
    }

    public static SearchResult find_N2logN(int[] a, int[] b, int[] c, int N) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int k = Arrays.binarySearch(c, N - a[i] - b[j]);
                if (k >= 0) {
                    return SearchResult.builder()
                        .exists(true)
                        .indexes(new int[]{i, j, k})
                        .build();
                }

            }
        }
        return SearchResult.builder().build();
    }

    @Getter
    @Builder
    public static class SearchResult {
        private boolean exists;
        private int[] indexes;
    }
}
