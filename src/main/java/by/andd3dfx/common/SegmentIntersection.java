package by.andd3dfx.common;

/**
 * Дано множество из N целочисленных отрезков на Ox.
 * Необходимо найти пару непересекающихся отрезков.
 * <p>
 * Пожелания: O(N) по времени, O(1) дополнительной памяти.
 * <p>
 * Пример: [[20, 30], [19, 21], [20, 26], [29, 35]] -> [[19, 21], [29, 35]]
 * Пример: [[29, 30], [19, 21], [20, 26], [29, 35], [10, 50]] -> [[19, 21], [29, 35]]
 */
public class SegmentIntersection {

    /**
     * Проходим 1 раз по массиву отрезков, ищем самую левую из правых границ и самую правую из левых.
     * <p>
     * После этого, если между этими двумя найденными отрезками есть расстояние - возвращаем их,
     * либо возвращаем пустое множество.
     */
    public static int[][] find(int[][] segments) {
        int leftMostRightBorderSegment = 0;
        int rightMostLeftBorderSegment = 0;

        for (int i = 1; i < segments.length; i++) {
            if (segments[i][1] < segments[leftMostRightBorderSegment][1]) {
                leftMostRightBorderSegment = i;
            }

            if (segments[i][0] > segments[rightMostLeftBorderSegment][0]) {
                rightMostLeftBorderSegment = i;
            }
        }

        if (segments[leftMostRightBorderSegment][1] < segments[rightMostLeftBorderSegment][0]) {
            return new int[][]{segments[leftMostRightBorderSegment], segments[rightMostLeftBorderSegment]};
        }
        return new int[][]{};
    }
}
