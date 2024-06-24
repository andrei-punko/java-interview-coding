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

        var i1 = 0;
        var i2 = 0;
        while (i1 < len1 && i2 < len2) {    // Lengths differ by 1 - need to remove/add one character
            if (s1[i1] == s2[i2]) {
                i1++;
                i2++;
                continue;
            }

            if (i1 + 1 < len1 && s1[i1 + 1] == s2[i2]) {
                return remainingPartsShouldBeEqual(first, i1 + 1, second, i2);
            }
            if (i2 + 1 < len2 && s1[i1] == s2[i2 + 1]) {
                return remainingPartsShouldBeEqual(first, i1, second, i2 + 1);
            }
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
