package by.andd3dfx.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Дана строка из малых латинских символов.
 * Определить кол-во ее различных подстрок, не содержащих повторяющихся символов.
 * Подстрока определяется границами [left, right] и различной соответственно считается,
 * если другая подстрока содержит отличающиеся границы.
 * <p>
 * Постараться придумать алгоритм решения со сложностью O(n).
 * <p>
 * Примеры:
 * a -> a -> 1
 * ab -> a b ab -> 3
 * abc -> a b c ab bc abc -> 6
 * aba -> a ab b ba a -> 5
 * abcdb -> a ab abc abcd b bc bcd c cd cdb d db b -> 13
 */
public class AmountOfPossibleSubstringsWithoutRepeatingChars {

    public static int determine(String str) {
        var chars = str.toCharArray();
        var result = 0;
        var left = 0;
        var right = 0;

        Map<Character, Integer> positions = new HashMap<>();
        while (right < chars.length) {
            var currCharacter = chars[right];
            if (positions.containsKey(currCharacter)) {
                left = positions.get(currCharacter) + 1;
            }
            result += (right - left) + 1;
            positions.put(currCharacter, right);
            right++;
        }
        return result;
    }
}
