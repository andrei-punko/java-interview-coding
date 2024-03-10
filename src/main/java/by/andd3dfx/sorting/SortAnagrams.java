package by.andd3dfx.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * We have an array: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * We need to transform it next way:
 * [
 *      ["ate", "eat", "tea"],  --> 3 items, sorted
 *      ["nat", "tan"],         --> 2 items, sorted
 *      ["bat"]                 --> 1 item, sorted
 * ]
 * Determine complexity of proposed algorithm
 * </pre>
 */
public class SortAnagrams {

    public List<List<String>> apply(String[] items) {
        Map<String, List<String>> vocabulary = new HashMap<>();

        for (String item : items) {
            String key = normalize(item);
            if (!vocabulary.containsKey(key)) {
                vocabulary.put(key, new ArrayList<>());
            }
            vocabulary.get(key).add(item);
        }

        for (var value : vocabulary.values()) {
            Collections.sort(value);
        }
        return vocabulary.values().stream()
                .sorted((List<String> a, List<String> b) -> (b.size() - a.size()))
                .toList();
    }

    /**
     * Determine key by sorting chars in string. Give this procedure name 'normalization'
     */
    private String normalize(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
