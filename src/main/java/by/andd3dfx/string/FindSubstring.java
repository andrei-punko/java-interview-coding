package by.andd3dfx.string;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

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
            while (posInPattern >= 0 && isNotMatched(text, posInText, pattern, posInPattern, counter)) {
                posInPattern--;
            }

            if (posInPattern < 0) { // Символ в паттерне не нашли, поэтому сдвигаем паттерн так, чтобы он начинался после этого символа
                shift = posInText + 1;
            } else {                // Нашли символ в паттерне, сдвигаем его так, чтобы выровнять позицию этого символа в паттерне и тексте
                shift += patternLen - posInPattern - 1;
            }
        }

        System.out.println("Comparisons: " + counter.value);
        return -1;
    }

    public static class FreqMap extends HashMap<Character, Integer> {
        public FreqMap(String pattern) {
            var length = pattern.length();
            for (var i = 0; i < length; i++) {
                put(pattern.charAt(length - i - 1), i);
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

        FreqMap map = new FreqMap(pattern);
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
            // просто берем вычисленное ранее нужное значение из FreqMap (если оно есть там)
            var value = map.get(text.charAt(posInText));
            if (value == null) {    // Символ в паттерне не нашли, поэтому сдвигаем паттерн так, чтобы он начинался после этого символа
                shift = posInText + 1;
            } else {                // Нашли символ в паттерне, сдвигаем его так, чтобы выровнять позицию этого символа в паттерне и тексте
                shift += value;
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
