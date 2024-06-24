package by.andd3dfx.string;

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

        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        if (len1 == len2) {
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
        var diffs_amount = 0;
        while (i1 < len1 && i2 < len2) {
            if (s1[i1] == s2[i2]) {
                i1++;
                i2++;
                continue;
            }

            if (i1 + 1 < len1 && s1[i1 + 1] == s2[i2]) {
                i1++;
                diffs_amount++;
                if (diffs_amount > 1) {
                    return false;
                }
            }
            if (i2 + 1 < len2 && s1[i1] == s2[i2 + 1]) {
                i2++;
                diffs_amount++;
                if (diffs_amount > 1) {
                    return false;
                }
            }

            i1++;
            i2++;
        }
        return diffs_amount <= 1;
    }
}
