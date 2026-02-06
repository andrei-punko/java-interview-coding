package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/interval-list-intersections/description/">Task description</a>
 *
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi]
 * and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 *
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 *
 * Example 1:
 * <img src="https://assets.leetcode.com/uploads/2019/01/30/interval1.png"/>
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 * Example 2:
 * Input: firstList = [[1,3],[5,9]], secondList = []
 * Output: []
 * </pre>
 */
public class IntervalListIntersections {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<Point> points = new ArrayList<>();
        populatePointList(firstList, points);
        populatePointList(secondList, points);
        points.sort(Comparator.comparing(Point::x)
            .thenComparingInt(o -> o.type.ordinal()));

        List<Pair> intersections = determinePairs(points);

        int[][] result = new int[intersections.size()][2];
        for (int i = 0; i < intersections.size(); i++) {
            result[i][0] = intersections.get(i).x1;
            result[i][1] = intersections.get(i).x2;
        }
        return result;
    }

    private static void populatePointList(int[][] intervals, List<Point> points) {
        for (var pair : intervals) {
            points.add(new Point(pair[0], Point.Type.START));
            points.add(new Point(pair[1], Point.Type.END));
        }
    }

    private static List<Pair> determinePairs(List<Point> points) {
        List<Pair> intersections = new ArrayList<>();
        var startsAmount = 0;
        var x = 0;
        for (var point : points) {
            switch (point.type) {
                case START -> {
                    startsAmount++;
                    x = point.x;
                }
                case END -> {
                    if (startsAmount <= 0) {
                        throw new IllegalStateException("END going before any START!");
                    }
                    if (startsAmount == 2) {
                        intersections.add(new Pair(x, point.x));
                    }
                    startsAmount--;
                }
            }
        }
        return intersections;
    }

    public record Point(int x, Type type) {

        public enum Type {
            START, END
        }
    }

    public record Pair(int x1, int x2) {

    }
}
