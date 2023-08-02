package by.andd3dfx.string;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class FindSubstring {

    @Data
    @NoArgsConstructor
    public static class Counter {
        private int value;
    }

    public static int indexOf(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        var counter = new Counter();

        outerLoop:
        for (int i = 0; i <= textLen - patternLen; i++) {
            for (int pos = 0; pos < patternLen; pos++) {
                if (isNotMatched(text, i + pos, pattern, pos, counter)) {
                    continue outerLoop;
                }
            }

            System.out.println("Comparisons: " + counter.value);
            return i;
        }

        System.out.println("Comparisons: " + counter.value);
        return -1;
    }

    /**
     * Алгоритм Бойера-Мура
     */
    public static int indexOf_BoyerMoore(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        var counter = new Counter();

        if (patternLen > textLen) {
            System.out.println("Comparisons: " + counter.value);
            return -1;
        }

        int shift = 0;
        while (shift <= textLen - patternLen) {
            var posInPattern = patternLen - 1;
            var posInText = shift + posInPattern;
            // Идем по паттерну справа налево, сравниваем с символами в text, пока не найдем различие либо не дойдем до конца паттерна
            while (posInPattern >= 0 && isMatched(text, posInText, pattern, posInPattern, counter)) {
                posInPattern--;
                posInText--;
            }

            if (posInPattern < 0) {    // Дошли до начала паттерна, полное совпадение. Возвращаем результат
                System.out.println("Comparisons: " + counter.value);
                return shift;
            }

            // Нашли различие. Фиксируем posInText, уменьшаем posInPattern, ищем такой символ в нем
            posInPattern--;
            while (posInPattern >= 0 && isNotMatched(text, posInText, pattern, posInPattern, counter)) {
                posInPattern--;
            }

            var oldShift = shift;
            if (posInPattern < 0) { // Символ в паттерне не нашли, поэтому сдвигаем паттерн так, чтобы он начинался после этого символа
                shift = posInText + 1;
                System.out.println("New shift value 1: " + oldShift + "->" + shift);
            } else {                // Нашли символ в паттерне, сдвигаем его так, чтобы выровнять позицию этого символа в паттерне и тексте
                shift = posInText - posInPattern;
                System.out.println("New shift value 2: " + oldShift + "->" + shift);
            }
        }

        System.out.println("Comparisons: " + counter.value);
        return -1;
    }

    public static class CharPosMap extends HashMap<Character, List<Integer>> {
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

    /**
     * Алгоритм Бойера-Мура с использованием таблицы смещений
     */
    public static int indexOf_BoyerMooreEnhanced(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        var counter = new Counter();

        if (patternLen > textLen) {
            System.out.println("Comparisons: " + counter.value);
            return -1;
        }

        var map = new CharPosMap(pattern);
        int shift = 0;
        while (shift <= textLen - patternLen) {
            var posInPattern = patternLen - 1;
            var posInText = shift + posInPattern;
            // Идем по паттерну справа налево, сравниваем с символами в text, пока не найдем различие либо не дойдем до конца паттерна
            while (posInPattern >= 0 && isMatched(text, posInText, pattern, posInPattern, counter)) {
                posInPattern--;
                posInText--;
            }

            if (posInPattern < 0) {    // Дошли до начала паттерна, полное совпадение. Возвращаем результат
                System.out.println("Comparisons: " + counter.value);
                return shift;
            }

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

            var oldShift = shift;
            if (posInPatternFromMap.isEmpty()) {    // Символ в паттерне не нашли. Или символ в паттерне расположен правее интересующей нас позиции
                shift = posInText + 1;      // поэтому сдвигаем паттерн так, чтобы он начинался после этого символа
                System.out.println("New shift value 1: " + oldShift + "->" + shift);
            } else {                // Нашли символ в паттерне, сдвигаем его так, чтобы выровнять позицию этого символа в паттерне и тексте
                shift = posInText - posInPatternFromMap.get();
                System.out.println("New shift value 2: " + oldShift + "->" + shift);
            }
        }

        System.out.println("Comparisons: " + counter.value);
        return -1;
    }

    private static boolean isMatched(String str1, int pos1, String str2, int pos2, Counter counter) {
        counter.value++;
        return str1.charAt(pos1) == str2.charAt(pos2);
    }

    private static boolean isNotMatched(String str1, int pos1, String str2, int pos2, Counter counter) {
        return !isMatched(str1, pos1, str2, pos2, counter);
    }
}
