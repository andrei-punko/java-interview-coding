package by.andd3dfx.string;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.math.NumberUtils.min;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/one-edit-distance/description/">Task description</a>
 *
 * Написать метод, на вход которого приходит две строки.
 * На выходе надо проверить, можно ли получить одну строку из другой за 1 исправление:
 * - замена одного символа в одной строке
 * - вставка/удаление одного символа из одной строки
 *
 * Примеры тестовых сценариев:
 * first = "a", second = "b" -> true
 * first = "ab", second = "b" -> true
 * first = "ab", second = "cb" -> true
 * first = "ab", second = "ba" -> false
 * first = "abcd", second = "abd" -> true
 * </pre>
 *
 * @see <a href="https://youtu.be/GOSWr4jHng8">Video solution</a>
 * @see <a href="https://youtu.be/0543ZryeIx4">Video solution 2</a>
 */
public class OneEditDistance {

    public static boolean couldTransform(String first, String second) {
        char[] s1 = first.toCharArray();
        char[] s2 = second.toCharArray();

        var len1 = s1.length;
        var len2 = s2.length;

        if (Math.abs(len1 - len2) > 1) {    // Lengths differ significantly
            return false;
        }

        if (len1 == len2) {                 // Same lengths
            var count = 0;
            for (var i = 0; i < len1; i++) {
                if (s1[i] != s2[i]) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        // Lengths differ by 1 - so need to remove/add one character
        var pos = 0;
        while (pos < len1 && pos < len2 && s1[pos] == s2[pos]) {
            pos++;
        }

        if (pos + 1 < len1 && pos < len2 && s1[pos + 1] == s2[pos]) {
            return remainingPartsShouldBeEqual(first, pos + 1, second, pos);
        }
        if (pos < len1 && pos + 1 < len2 && s1[pos] == s2[pos + 1]) {
            return remainingPartsShouldBeEqual(first, pos, second, pos + 1);
        }

        return true;
    }

    private static boolean remainingPartsShouldBeEqual(String first, int from1, String second, int from2) {
        return StringUtils.equals(
            first.substring(from1),
            second.substring(from2)
        );
    }

    public static boolean couldTransformUsingLevenshteinDistance(String first, String second) {
        return levenshteinDistance(first, second) <= 1;
    }

    /**
     * Use Wagner-Fisher algorithm. For details check
     * <a href="https://habr.com/ru/articles/676858/">article1</a>,
     * <a href="https://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm">article2</a>
     *
     * @param str1 First string
     * @param str2 Second string
     * @return Levenshtein distance
     */
    public static int levenshteinDistance(String str1, String str2) {
        var m = str1.length();
        var n = str2.length();
        // for all i and j, d[i,j] will hold the distance between
        // the first i characters of s and the first j characters of t
        // note that d has (m+1)*(n+1) values
        var d = new int[m + 1][n + 1];

        // source prefixes can be transformed into empty string by
        // dropping all characters
        for (int i = 1; i <= m; i++) {
            d[i][0] = i;
        }

        // target prefixes can be reached from empty source prefix
        // by inserting every character
        for (int j = 1; j <= n; j++) {
            d[0][j] = j;
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                var substitutionCost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;

                d[i][j] = min(d[i - 1][j] + 1,               // deletion
                    d[i][j - 1] + 1,                        // insertion
                    d[i - 1][j - 1] + substitutionCost);    // substitution
            }
        }
        return d[m][n];
    }
}
