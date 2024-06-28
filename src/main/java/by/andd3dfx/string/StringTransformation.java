package by.andd3dfx.string;

import org.apache.commons.lang3.StringUtils;

import static org.apache.commons.lang3.StringUtils.substring;

/**
 * Написать метод (класс и импорты не нужны) на вход которого приходит две строки.
 * На выходе надо проверить можно ли получить одну строку из другой за 1 исправление:
 * - замена одного символа в одной строке
 * - вставка/удаление одного символа из одной строки
 * <p>
 * Примеры тестовых сценариев:
 * first = "a", second = "b" -> true
 * first = "ab", second = "b" -> true
 * first = "ab", second = "cb" -> true
 * first = "ab", second = "ba" -> false
 * first = "abcd", second = "abd" -> true
 */
public class StringTransformation {

    public static boolean couldTransform(String first, String second) {
        var s1 = first.toCharArray();
        var s2 = second.toCharArray();

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

        // Lengths differ by 1 - need to remove/add one character
        var pos = 0;
        while (pos < len1 && pos < len2 && s1[pos] == s2[pos]) {
            pos++;
        }

        if (pos + 1 < len1 && s1[pos + 1] == s2[pos]) {
            return remainingPartsShouldBeEqual(first, pos + 1, second, pos);
        }
        if (pos + 1 < len2 && s1[pos] == s2[pos + 1]) {
            return remainingPartsShouldBeEqual(first, pos, second, pos + 1);
        }
        return true;
    }

    private static boolean remainingPartsShouldBeEqual(String first, int from1, String second, int from2) {
        return StringUtils.equals(
                substring(first, from1),
                substring(second, from2)
        );
    }
}
