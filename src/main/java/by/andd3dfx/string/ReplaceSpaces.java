package by.andd3dfx.string;

import java.util.Arrays;

/**
 * Заменить последовательности пробелов в строке на одиночные пробелы. O(n) по времени, O(1) по памяти.
 * "some    string  " -> "some string "
 * Считается, что строка в языке mutable, если это не так, то можно считать, что в функцию передается изменяемый массив с символами.
 */
public class ReplaceSpaces {

    public char[] normalize(char[] str) {
        boolean spaceFound = false;
        int newPtr = 0;
        int currPtr = 0;

        while (currPtr < str.length) {
            if (str[currPtr] == ' ') {
                if (!spaceFound) {
                    str[newPtr] = str[currPtr];
                    newPtr++;
                    spaceFound = true;
                }
            } else {
                spaceFound = false;
                str[newPtr] = str[currPtr];
                newPtr++;
            }
            currPtr++;
        }

        return Arrays.copyOfRange(str, 0, newPtr);
    }
}
