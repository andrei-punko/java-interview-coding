package by.andd3dfx.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We have an array: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * <p>
 * We need to transform it next way:
 * [
 * 3  ["ate", "eat", "tea"],  --> sorted
 * 2  ["nat", "tan"],  --> sorted
 * 1  ["bat"]  -->  sorted
 * ]
 * <p>
 * Determine complexity of proposed algorithm
 */
public class SortAnagrams {

    private Map<String, List<String>> vocabulary = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] items) {
        for (String item : items) {
            String key = normalize(item);
            addValue(key, item);
        }

        for (String key : vocabulary.keySet()) {
            Collections.sort(vocabulary.get(key));
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(vocabulary.values());
        Collections.sort(result, (List<String> a, List<String> b) -> (b.size() - a.size()));

        return result;
    }

    /**
     * Determine key by sorting chars in string. Give this procedure name 'normalization'
     */
    private String normalize(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private void addValue(String key, String value) {
        if (!vocabulary.containsKey(key)) {
            vocabulary.put(key, new ArrayList<>());
        }
        vocabulary.get(key).add(value);
    }
}
