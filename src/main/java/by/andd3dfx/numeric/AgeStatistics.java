package by.andd3dfx.numeric;

import java.util.Scanner;

/**
 * <pre>
 * У нас есть статистика о людях, которые родились начиная с 1980 года с датами их смертей.
 * Нужно выяснить, в каком году жило больше всего людей одновременно.
 *
 * Статистика представляет собой набор пар чисел: год рождения и год смерти.
 * В год смерти человек не учитывается в статистике. Временные ограничения по годам 1980 - 2080
 *
 * Например:
 * 3
 * 1980 1991
 * 1990 2001
 * 2000 2011
 *
 * Ответ: 1990 - это минимальный год, в который жило 2 человека
 *
 * import java.util.Scanner;
 *
 * public class Main {
 *   public static void main(String[] args) {
 *     Scanner scanner = new Scanner(System.in);
 *     int length = scanner.nextInt();
 *     int[][] logs = new int[length][];
 *
 *     for (int i = 0; i < length; i++) {
 *       logs[i] = new int[] { scanner.nextInt(), scanner.nextInt() };
 *     }
 *
 *     System.out.println(findMaximum(logs));
 *   }
 *
 *   private static int findMaximum(int[][] logs) {
 *     return 0;
 *   }
 * }
 * </pre>
 */
public class AgeStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[][] logs = new int[length][];

        for (int i = 0; i < length; i++) {
            logs[i] = new int[] { scanner.nextInt(), scanner.nextInt() };
        }

        System.out.println(findMaximum(logs));
    }

    public static int findMaximum(int[][] logs) {
        int[] years = new int[101];

        for (int[] pair : logs) {
            for (int year = pair[0]; year < pair[1]; year++) {
                years[year - 1980]++;
            }
        }

        int maxYear = 0;
        for (int i = 0; i < years.length; i++) {
            if (years[i] > years[maxYear]){
                maxYear = i;
            }
        }
        return maxYear + 1980;
    }
}
