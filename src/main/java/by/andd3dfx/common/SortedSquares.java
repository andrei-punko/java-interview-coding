package by.andd3dfx.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * <pre>
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Дан массив целых чисел, отсортированный по возрастанию.
 * Вернуть массив, содержащий эл-ты исходного массива в квадрате, также отсортированный по возрастанию.
 *
 * Пример:
 * [-5,-3,0,1,2,4] -> [0,1,4,9,16,25]
 * </pre>
 */
public class SortedSquares {

    public static Integer[] transformUsingSorting(Integer[] items) {
        return Arrays.stream(items)
                .map(integer -> integer * integer)
                .sorted()
                .collect(Collectors.toList())
                .toArray(new Integer[0]);
    }

    public static Integer[] transformUsingDeque(Integer[] items) {
        int left = 0;
        int right = items.length - 1;

        Deque<Integer> queue = new ArrayDeque<>();
        while (left <= right) {
            var leftValue = items[left] * items[left];
            var rightValue = items[right] * items[right];

            if (leftValue < rightValue) {
                queue.addFirst(rightValue);
                right--;
            } else {
                queue.addFirst(leftValue);
                left++;
            }
        }

        return queue.toArray(new Integer[0]);
    }

    public static Integer[] transformUsingPriorityQueue(Integer[] items) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(value -> value));
        for (var item : items) {
            priorityQueue.add(item * item);
        }

        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }
        return result.toArray(new Integer[0]);
    }
}
