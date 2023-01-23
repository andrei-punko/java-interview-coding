package by.andd3dfx.recursion;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Кирпичная пирамида.
 *
 * Пирамида бесконечна. На верхнем слое лежит один кирпич весом 1кг, на втором слое - 2 кирпича по 1кг каждый,
 * на третьем - три и т.д.
 * Каждый кирпич равномерно давит на кирпичи под ним: 1/2 на левый кирпич и 1/2 на правый кирпич.
 * Если на кирпич давит сверху общая масса 100кг, то давление также распределяется поровну на нижние кирпичи.
 *
 * Требуется:
 * Реализовать функцию w(row, pos), которая вычисляет давление на кирпич на позиции row, pos.
 * row - номер строки сверху, начиная с нуля,
 * pos - номер кирпича в строке слева направо, начиная с нуля.
 *
 * Проверочные значения:
 * w(0,0) = 0
 *
 * w(1,0) = 0.5
 * w(0,1) = 0.5
 *
 * w(2,0) = 0.75
 * w(2,1) = 1.5
 * w(2,2) = 0.75
 *
 * w(3,0) = 0.875
 * w(3,1) = 2.125
 * w(3,2) = 2.125
 * w(3,3) = 0.875
 *
 * w(322,156) = 306.48749781747574
 * </pre>
 */
public class BrickPyramid {

    private static final Map<Position, Double> cache = new HashMap<>() {{
        put(new Position(0, 0), 0d);
    }};

    @Data
    @RequiredArgsConstructor
    public static class Position {
        private final int row;
        private final int pos;
    }

    public static double w(int row, int pos) {
        if (row < 0 || pos < 0 || row < pos) {
            throw new IllegalArgumentException("row and pos should satisfy conditions: row>=0, pos>=0, row>=pos");
        }

        Position position = new Position(row, pos);
        if (cache.containsKey(position)) {
            return cache.get(position);
        }

        double result = 0;
        if (pos == 0) {
            result += 0.5 * w(row - 1, pos) + 0.5;
        } else if (pos == row) {
            result += 0.5 * w(row - 1, pos - 1) + 0.5;
        } else {
            result += 0.5 * w(row - 1, pos - 1) + 0.5 * w(row - 1, pos) + 1;
        }

        cache.put(position, result);
        return result;
    }
}
