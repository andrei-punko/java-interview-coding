package by.andd3dfx.game;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.function.Function;

/**
 * <pre>
 * --- Day 2: Gift Shop ---
 *
 * You get inside and take the elevator to its only other stop: the gift shop. "Thank you for visiting the North Pole!" gleefully exclaims a nearby sign. You aren't sure who is even allowed to visit the North Pole, but you know you can access the lobby through here, and from there you can access the rest of the North Pole base.
 *
 * As you make your way through the surprisingly extensive selection, one of the clerks recognizes you and asks for your help.
 *
 * As it turns out, one of the younger Elves was playing on a gift shop computer and managed to add a whole bunch of invalid product IDs to their gift shop database! Surely, it would be no trouble for you to identify the invalid product IDs for them, right?
 *
 * They've even checked most of the product ID ranges already; they only have a few product ID ranges (your puzzle input) that you'll need to check. For example:
 *
 * 11-22,95-115,998-1012,1188511880-1188511890,222220-222224,
 * 1698522-1698528,446443-446449,38593856-38593862,565653-565659,
 * 824824821-824824827,2121212118-2121212124
 *
 * (The ID ranges are wrapped here for legibility; in your input, they appear on a single long line.)
 *
 * The ranges are separated by commas (,); each range gives its first ID and last ID separated by a dash (-).
 *
 * Since the young Elf was just doing silly patterns, you can find the invalid IDs by looking for any ID which is made only of some sequence of digits repeated twice. So, 55 (5 twice), 6464 (64 twice), and 123123 (123 twice) would all be invalid IDs.
 *
 * None of the numbers have leading zeroes; 0101 isn't an ID at all. (101 is a valid ID that you would ignore.)
 *
 * Your job is to find all of the invalid IDs that appear in the given ranges. In the above example:
 *
 *     11-22 has two invalid IDs, 11 and 22.
 *     95-115 has one invalid ID, 99.
 *     998-1012 has one invalid ID, 1010.
 *     1188511880-1188511890 has one invalid ID, 1188511885.
 *     222220-222224 has one invalid ID, 222222.
 *     1698522-1698528 contains no invalid IDs.
 *     446443-446449 has one invalid ID, 446446.
 *     38593856-38593862 has one invalid ID, 38593859.
 *     The rest of the ranges contain no invalid IDs.
 *
 * Adding up all the invalid IDs in this example produces 1227775554.
 *
 * What do you get if you add up all of the invalid IDs?
 *
 * Your puzzle answer was 23534117921.
 *
 * --- Part Two ---
 *
 * The clerk quickly discovers that there are still invalid IDs in the ranges in your list. Maybe the young Elf was doing other silly patterns as well?
 *
 * Now, an ID is invalid if it is made only of some sequence of digits repeated at least twice. So, 12341234 (1234 two times), 123123123 (123 three times), 1212121212 (12 five times), and 1111111 (1 seven times) are all invalid IDs.
 *
 * From the same example as before:
 *
 *     11-22 still has two invalid IDs, 11 and 22.
 *     95-115 now has two invalid IDs, 99 and 111.
 *     998-1012 now has two invalid IDs, 999 and 1010.
 *     1188511880-1188511890 still has one invalid ID, 1188511885.
 *     222220-222224 still has one invalid ID, 222222.
 *     1698522-1698528 still contains no invalid IDs.
 *     446443-446449 still has one invalid ID, 446446.
 *     38593856-38593862 still has one invalid ID, 38593859.
 *     565653-565659 now has one invalid ID, 565656.
 *     824824821-824824827 now has one invalid ID, 824824824.
 *     2121212118-2121212124 now has one invalid ID, 2121212121.
 *
 * Adding up all the invalid IDs in this example produces 4174379265.
 *
 * What do you get if you add up all of the invalid IDs using these new rules?
 *
 * Your puzzle answer was 31755323497.
 * </pre>
 *
 * @see <a href="https://youtu.be/qUsIi-084Xg">Video solution, Part 1</a>
 * @see <a href="https://youtu.be/m45uHY63ZqI">Video solution, Part 2</a>
 */
public class GiftShop {

    public static Long determinePart1(String inputString) {
        return determinePartInner(inputString, GiftShop::isInvalid);
    }

    public static Long determinePart2(String inputString) {
        return determinePartInner(inputString, GiftShop::isInvalid2);
    }

    private static boolean isInvalid(Long id) {
        var str = String.valueOf(id);
        var len = str.length();
        if (len % 2 == 1) {
            return false;
        }
        return StringUtils.equals(str.substring(0, len / 2), str.substring(len / 2));
    }

    static boolean isInvalid2(long id) {
        var str = String.valueOf(id);
        return str.matches("^(\\d+)\\1+$");
    }

    public static Long determinePartInner(String inputString, Function<Long, Boolean> isInvalidFunc) {
        var set = new HashSet<Long>();
        var ranges = inputString.split(",");
        for (var range : ranges) {
            var borders = range.split("-");
            var left = NumberUtils.toLong(borders[0]);
            var right = NumberUtils.toLong(borders[1]);

            for (var current = left; current <= right; current++) {
                if (isInvalidFunc.apply(current)) {
                    set.add(current);
                }
            }
        }
        var result = 0L;
        for (var item : set) {
            result += item;
        }

        return result;
    }

    @SneakyThrows
    public static void main(String[] args) {
        var inputString = read("/game/gift-shop.txt");
        var resultPart1 = determinePart1(inputString);
        var resultPart2 = determinePart2(inputString);
        System.out.println(resultPart1 + ", " + resultPart2);
    }

    private static String read(String filePathName) throws IOException {
        InputStream inputStream = GiftShop.class.getResourceAsStream(filePathName);
        try (var br = new BufferedReader(new InputStreamReader(inputStream))) {
            return br.readLine();
        }
    }
}
