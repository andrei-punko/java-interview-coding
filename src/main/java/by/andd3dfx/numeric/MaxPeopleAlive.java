package by.andd3dfx.numeric;

/**
 * <pre>
 * У нас есть статистика о людях, которые родились начиная с 1980 года с годами их смертей.
 * Нужно выяснить, в каком году жило больше всего людей одновременно.
 *
 * Статистика представляет собой набор пар чисел: год рождения и год смерти.
 * В год смерти человек не учитывается в статистике. Временные ограничения по годам 1980 - 2080
 *
 * Например:
 * 1980 1991
 * 1990 2001
 * 2000 2011
 *
 * Ответ: 1990 - это минимальный год, в который жило 2 человека
 * </pre>
 *
 * @see <a href="https://youtu.be/V1qTYQKxRAA">Video solution</a>
 */
public class MaxPeopleAlive {

    public static int findMaximum(int[][] logs) {
        int[] alive = new int[101];

        for (int[] pair : logs) {
            for (int year = pair[0]; year < pair[1]; year++) {
                alive[year - 1980]++;
            }
        }

        int maxYear = 0;
        for (int i = 0; i < alive.length; i++) {
            if (alive[i] > alive[maxYear]) {
                maxYear = i;
            }
        }
        return maxYear + 1980;
    }

    public static int findMaximum2(int[][] logs) {
        int[] diff = new int[101];

        for (int[] pair : logs) {
            diff[pair[0] - 1980]++;
            diff[pair[1] - 1980]--;
        }

        int maxAlive = 0;
        int maxAliveYear = 0;
        int alive = 0;
        for (var i = 0; i < diff.length; i++) {
            alive += diff[i];
            if (alive > maxAlive) {
                maxAlive = alive;
                maxAliveYear = i;
            }
        }

        return maxAliveYear + 1980;
    }
}
