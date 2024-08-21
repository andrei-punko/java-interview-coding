package by.andd3dfx.dynamic;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Золотоискатель находится на вершине горы, представленной в виде "треугольного" массива,
 * в каждой клетке которого находится какое-то кол-во золота:
 *
 * {0},
 * {5, 8},
 * {9, 8, 2},
 * {1, 3, 5, 6},
 * {6, 2, 4, 4, 5},
 * {9, 5, 3, 5, 5, 7},
 * {7, 4, 6, 4, 7, 6, 8}
 *
 * На каждом шаге он может двигаться только вниз или вправо.
 * Надо так проложить его маршрут, чтобы при спуске он собрал максимальное кол-во золота.
 * Ответ для данного массива: 37
 * </pre>
 *
 * @see <a href="https://youtu.be/UVwWmVbSq9g">Video solution</a>
 */
public class GoldDigger {

    private final Map<Cell, Integer> cache = new HashMap<>();

    public int solve(int[][] goldMatrix) {
        return maxGold(0, 0, goldMatrix);
    }

    private int maxGold(int i, int j, int[][] m) {
        if (i == m.length - 1) {
            return m[i][j];
        }

        var cell = new Cell(i, j);
        if (cache.containsKey(cell)) {
            return cache.get(cell);
        }

        var result = m[i][j] + Math.max(
                maxGold(i + 1, j, m),
                maxGold(i + 1, j + 1, m)
        );
        cache.put(cell, result);
        return result;
    }

    @EqualsAndHashCode
    @AllArgsConstructor
    private static class Cell {
        private int row;
        private int col;
    }
}
