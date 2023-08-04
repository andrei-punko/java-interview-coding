package by.andd3dfx.string.boyermoore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Алгоритм Бойера-Мура с использованием таблицы смещений
 */
public class FindSubstringBoyerMooreEnhanced extends FindSubstringBoyerMoore {

    private static final String SHIFTS = "shifts";

    public class CharPosMap extends HashMap<Character, List<Integer>> {
        public CharPosMap(String pattern) {
            for (var i = 0; i < pattern.length(); i++) {
                var key = pattern.charAt(i);
                if (!containsKey(key)) {
                    put(key, new ArrayList<>());
                }
                get(key).add(i);
            }
        }
    }

    @Override
    protected Map<String, Object> createContext(String text, String pattern) {
        return new HashMap<>() {{
            put(SHIFTS, new CharPosMap(pattern));
        }};
    }

    @Override
    protected int determineShift(String text, int posInText, String pattern, int posInPattern, Counter counter, Map<String, Object> context) {
        var map = (Map<Character, List<Integer>>) context.get(SHIFTS);

        // Нашли различие.
        // Но вместо действия "Фиксируем posInText, уменьшаем posInPattern, ищем такой символ в нем" -
        // просто берем список вычисленных ранее значений (для данного символа) и берем максимальный из них, меньший posInPattern
        var characterInText = text.charAt(posInText);

        Optional<Integer> posInPatternFromMap = Optional.empty();
        if (map.containsKey(characterInText)) {
            int finalPosInPattern = posInPattern;
            posInPatternFromMap = map.get(characterInText).stream()
                    .filter(integer -> integer < finalPosInPattern)
                    .max(Integer::compareTo);
        }

        if (posInPatternFromMap.isEmpty()) {    // Символ в паттерне не нашли. Или символ в паттерне расположен правее интересующей нас позиции
            return posInText + 1;      // поэтому сдвигаем паттерн так, чтобы он начинался после этого символа
        }

        // Нашли символ в паттерне, сдвигаем его так, чтобы выровнять позицию этого символа в паттерне и тексте
        return posInText - posInPatternFromMap.get();
    }
}
