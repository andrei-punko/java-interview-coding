package by.andd3dfx.interview.train2021;

/**
 * Дана последовательность целых чисел. Необходимо найти минимально возможное произведение
 * пары эл-тов последовательности.
 * Например, для последовательности чисел 9 4 2 5 3 ответ будет 6.
 * Попробовать сделать это за O(n)
 */
public class MinMultiplication {

    public int minMultiplication(int[] arr) {
        // 1. negative at the left, positive at the right - multiplication of most left and right numbers
        // 2. all are positive - multiplication of two left numbers
        // 3. all are negative - multiplication of two right numbers

        int n = arr.length;
        if (n < 2) {
            throw new IllegalArgumentException("Not enough elements in array!");
        }

        int[] left = sortPair(arr[0], arr[1]);
        int[] right = sortPair(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int curr = arr[i];
            if (curr < left[0]) {
                left[1] = left[0];
                left[0] = curr;
            } else if (curr < left[1]) {
                left[1] = curr;
            }

            if (curr > right[1]) {
                right[0] = right[1];
                right[1] = curr;
            } else if (curr > right[0]) {
                right[0] = curr;
            }
        }

        // 3
        if (right[1] < 0) {
            return right[0] * right[1];
        }
        // 2
        if (left[0] > 0) {
            return left[0] * left[1];
        }
        // 1
        return left[0] * right[1];
    }

    private int[] sortPair(int first, int second) {
        return (first < second) ? new int[]{first, second} : new int[]{second, first};
    }
}
