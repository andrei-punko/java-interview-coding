package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/merge-intervals/description/">Task description</a>
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *  Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 *  Output: [[1,6],[8,10],[15,18]]
 *  Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 *  Input: intervals = [[1,4],[4,5]]
 *  Output: [[1,5]]
 *  Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * Example 3:
 *  Input: intervals = [[4,7],[1,4]]
 *  Output: [[1,7]]
 *  Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 * </pre>
 *
 * @see <a href="https://youtu.be/gyTPrnGg2Yk">Video solution</a>
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        List<Point> points = new ArrayList<>();
        populatePointList(intervals, points);
        points.sort(Comparator.comparing(Point::x)
            .thenComparingInt(o -> o.type.ordinal())
        );

        List<Pair> intersections = determinePairs(points);

        int[][] result = new int[intersections.size()][2];
        for (int i = 0; i < intersections.size(); i++) {
            result[i][0] = intersections.get(i).x1;
            result[i][1] = intersections.get(i).x2;
        }
        return result;
    }

    private List<Pair> determinePairs(List<Point> points) {
        List<Pair> intersections = new ArrayList<>();
        var startsAmount = 0;
        var x = 0;
        for (var point : points) {
            switch (point.type) {
                case START -> {
                    startsAmount++;
                    if (startsAmount == 1) {
                        x = point.x;
                    }
                }
                case END -> {
                    if (startsAmount <= 0) {
                        throw new IllegalStateException("END going before any START!");
                    }
                    startsAmount--;
                    if (startsAmount == 0) {
                        intersections.add(new Pair(x, point.x));
                    }
                }
            }
        }
        return intersections;
    }

    private void populatePointList(int[][] intervals, List<Point> points) {
        for (var pair : intervals) {
            points.add(new Point(pair[0], Point.Type.START));
            points.add(new Point(pair[1], Point.Type.END));
        }
    }

    public record Point(int x, Type type) {

        public enum Type {
            START, END
        }
    }

    public record Pair(int x1, int x2) {

    }
}
