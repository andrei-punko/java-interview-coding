package by.andd3dfx.string;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of characters and a dictionary of words,
 * find the longest words that can be obtained by characters.,
 * i.e. if array is {e, o, t, s} and dictionary words are [otse, tse, eo, stoe]
 * then function should return [otse, stoe].
 *
 * @see <a href="https://youtu.be/LQeAY_jx3SA">Video solution</a>
 */
public class LongestDictWordsFromCharacters {

    public static String[] find(char[] characters, String[] words) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> baseFreqMap = buildFreqMap(characters);

        List<String> sortedWords = Arrays.stream(words)
                .sorted(Comparator.comparingInt(String::length))
                .toList().reversed();
        var lastLength = -1;
        for (var word : sortedWords) {
            if (word.length() < lastLength) {
                break;
            }

            Map<Character, Integer> wordFreqMap = buildFreqMap(word.toCharArray());
            if (couldMakeThisWordUsingBaseChars(baseFreqMap, wordFreqMap)) {
                result.add(word);
                lastLength = word.length();
            }
        }
        return result.toArray(new String[0]);
    }

    private static boolean couldMakeThisWordUsingBaseChars(Map<Character, Integer> baseFreqMap, Map<Character, Integer> wordFreqMap) {
        for (var entry : wordFreqMap.entrySet()) {
            var key = entry.getKey();
            if (!baseFreqMap.containsKey(key) || baseFreqMap.get(key) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> buildFreqMap(char[] chars) {
        return Arrays.stream(ArrayUtils.toObject(chars))
                .collect(Collectors.groupingBy(
                        ch -> ch, Collectors.summingInt(element -> 1)
                ));
    }

    private static Map<Character, Integer> buildFreqMap_Old(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        for (var ch : chars) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }
        return map;
    }
}
