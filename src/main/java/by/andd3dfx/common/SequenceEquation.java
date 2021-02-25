package by.andd3dfx.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for task:
 * https://www.hackerrank.com/challenges/permutation-equation/problem
 */
public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            map.put(p[i], i + 1);
        }
        int[] result = new int[p.length];
        for (int i = 1; i <= p.length; i++) {
            result[i - 1] = map.get(map.get(i));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        final int[] result = permutationEquation(new int[]{2, 3, 1});
        for (int v : result) {
            System.out.println(v);
        }
    }
}
