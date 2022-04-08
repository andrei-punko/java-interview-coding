package by.andd3dfx.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Convert incoming string into string with char frequencies: AAABBCDDDDEFFFFFFF -> A3B2C1D4E1F7
 */
public class MakeStringCompact {

    public static String convert(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        str.chars().forEach(item -> {
            char character = (char) item;

            int value = 1;
            if (map.containsKey(character)) {
                value += map.get(character);
            }
            map.put(character, value);
        });

        return map.entrySet().stream()
            .map(entry -> String.format("%s%d", entry.getKey(), entry.getValue()))
            .collect(Collectors.joining());
    }
}
