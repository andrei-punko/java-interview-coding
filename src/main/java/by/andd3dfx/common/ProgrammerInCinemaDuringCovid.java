package by.andd3dfx.common;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/maximize-distance-to-closest-person/description/">Task description</a>
 *
 * Программист решил пойти в кино. Но он хочет сесть как можно дальше от других людей, чтобы не заразиться covid.
 * Поэтому он хочет написать функцию, определяющую максимальное расстояние,
 * на котором можно сесть от других зрителей в одном ряду.
 *
 * Дан массив из 0 и 1 описывающий посадку зрителей в ряду.
 * 0 - место свободно, 1 - место занято другим зрителем.
 * Вывести максимальное расстояние, на котором можно сесть от других зрителей.
 * Гарантируется, что есть 0 и 1.
 *
 * Примеры:
 * [1,0,0,0,1] -> 2
 * [1,0,0,0,0,1] -> 2
 * [1,0,0,0,0,0,1] -> 3
 * [1,0,0,0,0,0,1,0,0,1] -> 3
 * [1,0,0,0] -> 3
 * [0,0,1,0] -> 2
 * </pre>
 *
 * @see <a href="https://youtu.be/ClBUqbfSJ18">Video solution</a>
 */
public class ProgrammerInCinemaDuringCovid {

    public static int find(int[] places) {
        var leftFound = false;
        var left = -1;
        var right = -1;
        List<Interval> intervals = new ArrayList<>();

        for (int current = 0; current < places.length; current++) {
            if (places[current] == 0) {
                right = current;
                if (!leftFound) {
                    leftFound = true;
                    left = current;
                }
            } else {
                if (leftFound) {
                    intervals.add(new Interval(left, right));
                    leftFound = false;
                }
            }
        }
        if (leftFound) {
            intervals.add(new Interval(left, right));
        }

        int maxDistance = 0;
        for (var interval : intervals) {
            int distance = determineDistance(interval, places.length);
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    private static int determineDistance(Interval interval, int size) {
        if (interval.left == 0) {
            return interval.right + 1;
        }
        if (interval.right == size - 1) {
            return size - interval.left;
        }
        return (interval.right - interval.left + 2) / 2;
    }

    @ToString
    @AllArgsConstructor
    public static class Interval {
        private int left;
        private int right;
    }
}
