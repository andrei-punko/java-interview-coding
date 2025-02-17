package by.andd3dfx.search;

/**
 * Есть матрица NxN, состоящая из 0 и 1, и отражающая расположение кораблей на поле для морского боя.
 * Поле может быть любого размера, но обязательно квадратное.
 * Кораблей может быть любое кол-во.
 * Размер кораблей - от 1х1 до 1хN
 * Корабли никак не соприкасаются друг с другом.
 * Необходимо подсчитать кол-во кораблей.
 *
 * @see <a href="https://youtu.be/9ypQAA7ilYo">Video solution</a>
 */
public class CountSeaShips {

    /**
     * Использовал идеи из <a href="https://medium.com/unilecs/%D0%BC%D0%BE%D1%80%D1%81%D0%BA%D0%BE%D0%B9-%D0%B1%D0%BE%D0%B9-9109dafcbc5">статьи</a>
     * <p>
     * Если на очередном шаге мы встретили клетку корабля, проверяем предыдущую клетку по вертикали и по горизонтали,
     * если там также находится клетка корабля, то пропускаем эту итерацию, поскольку уже посчитали этот корабль раньше.
     * <p>
     * Если же на очередном шаге мы встретили клетку корабля и предыдущие клетки по горизонтали и вертикали не являются
     * клетками корабля, то значит мы нашли 1ю клетку нового корабля. В этом случае увеличиваем наш результирующий
     * счетчик.
     */
    public static int count(int[][] matrix) {
        var size = matrix.length;
        var result = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 1) {
                    boolean isNewShip = checkIsNewShip(matrix, i, j);
                    if (isNewShip) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static boolean checkIsNewShip(int[][] matrix, int i, int j) {
        if ((i > 0 && matrix[i - 1][j] == 1) || (j > 0 && matrix[i][j - 1] == 1)) {
            return false;
        }
        return true;
    }
}
