package by.andd3dfx.string;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/jewels-and-stones/description/">Task description</a>
 *
 * You're given strings jewels representing the types of stones that are jewels, and stones
 * representing the stones you have. Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 * </pre>
 */
public class JewelsAndStones {

    public static int numJewelsInStones(String jewels, String stones) {
        var count = 0;
        for (var ch : stones.toCharArray()) {
            if (jewels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int numJewelsInStones2(String jewels, String stones) {
        Set<Character> jewelsSet = jewels.chars()
            .mapToObj(jewel -> (char) jewel)
            .collect(Collectors.toSet());

        return (int) stones.chars()
            .mapToObj(stone -> (char) stone)
            .filter(jewelsSet::contains)
            .count();
    }
}
