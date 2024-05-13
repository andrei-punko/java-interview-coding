package by.andd3dfx.string;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of characters and a dictionary of words,
 * find the longest words that can be obtained by characters.,
 * i.e. if array is {e, o, t, s} and dictionary words are [otse, tse, eo, stoe]
 * then function should return [otse, stoe].
 */
public class LongestDictWordsFromCharacters {

    public static String[] find(char[] characters, String[] words) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> baseFreqMap = buildFreqMap(characters);

        for (var word : words) {
            Map<Character, Integer> freqMap = buildFreqMap(word.toCharArray());

            if (baseFreqMap.equals(freqMap)) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
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
                map.put(ch, 1);
            }
            map.put(ch, map.get(ch) + 1);
        }
        return map;
    }
}
