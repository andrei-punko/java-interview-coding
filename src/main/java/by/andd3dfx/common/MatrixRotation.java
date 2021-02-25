package by.andd3dfx.common;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Solution for matrix rotation task: https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 *
 * Input next line to test:
 * 2 3 1
 * 1 2 3
 * 4 5 6
 */
public class MatrixRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int left = 0;
        int up = 0;
        while (m >= 1 && n >= 1) {
            int count = 2 * m + 2 * n - 4;
            int[] tmp = new int[count];
            int curr = 0;
            for (int i = 0; i < n; i++) {
                tmp[curr] = matrix.get(up).get(left + i);
                curr++;
            }
            for (int i = 1; i < m - 1; i++) {
                tmp[curr] = matrix.get(up + i).get(left + n - 1);
                curr++;
            }
            for (int i = n - 1; i >= 0; i--) {
                tmp[curr] = matrix.get(up + m - 1).get(left + i);
                curr++;
            }
            for (int i = m - 2; i >= 1; i--) {
                tmp[curr] = matrix.get(up + i).get(left);
                curr++;
            }

            curr = r % count;
            for (int i = 0; i < n; i++) {
                matrix.get(up).set(left + i, tmp[curr]);
                curr++;
                if (curr >= count) {
                    curr -= count;
                }
            }
            for (int i = 1; i < m - 1; i++) {
                matrix.get(up + i).set(left + n - 1, tmp[curr]);
                curr++;
                if (curr >= count) {
                    curr -= count;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                matrix.get(up + m - 1).set(left + i, tmp[curr]);
                curr++;
                if (curr >= count) {
                    curr -= count;
                }
            }
            for (int i = m - 2; i >= 1; i--) {
                matrix.get(up + i).set(left, tmp[curr]);
                curr++;
                if (curr >= count) {
                    curr -= count;
                }
            }
            m -= 2;
            n -= 2;
            left++;
            up++;
        }

        for (List<Integer> row : matrix) {
            for (Integer item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int m = Integer.parseInt(mnr[0]);
        int n = Integer.parseInt(mnr[1]);
        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();
        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);
        bufferedReader.close();
    }
}
