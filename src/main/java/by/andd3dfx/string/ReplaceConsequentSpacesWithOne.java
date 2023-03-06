package by.andd3dfx.string;

import java.util.Arrays;

/**
 * <pre>
 * Заменить последовательности пробелов в строке на одиночные пробелы, например:
 * "some    string  " -> "some string "
 *
 * Желательно: O(n) по времени, O(1) по памяти.
 * Считается, что строка в языке mutable; если это не так, то можно считать,
 * что в функцию передается изменяемый массив с символами.
 * </pre>
 */
public class ReplaceConsequentSpacesWithOne {

    public static char[] apply(char[] str) {
        boolean spaceFound = false;
        int current = 0;
        int newEnd = 0;

        while (current < str.length) {
            if (str[current] == ' ') {
                if (spaceFound) {
                    current++;
                    continue;
                }

                spaceFound = true;
            } else {
                spaceFound = false;
            }

            copy(str, current, newEnd);
            newEnd++;

            current++;
        }

        return Arrays.copyOfRange(str, 0, newEnd);
    }

    private static void copy(char[] str, int from, int to) {
        str[to] = str[from];
    }
}
