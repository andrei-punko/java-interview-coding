package by.andd3dfx.sitesparsing.tutby;

import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Statistics {

    private Map<String, Integer> keywordToFreqMap = new HashMap<>();

    public void putKeyword(String keyword) {
        if (!keywordToFreqMap.containsKey(keyword)) {
            keywordToFreqMap.put(keyword, 0);
        }
        keywordToFreqMap.put(keyword, keywordToFreqMap.get(keyword) + 1);
    }

    public Integer get(String keyword) {
        return keywordToFreqMap.get(keyword);
    }

    public LinkedHashMap<String, Integer> buildSortedMap() {
        return keywordToFreqMap
            .entrySet()
            .stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .collect(toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e2,
                LinkedHashMap::new
            ));
    }
}
