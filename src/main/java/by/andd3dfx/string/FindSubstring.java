package by.andd3dfx.string;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class FindSubstring {

    @Data
    @NoArgsConstructor
    public static class Counter {
        private int value;
    }

    public static int indexOf_NM(String text, String pattern) {
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

    public static class FreqMap extends HashMap<Character, Integer> {
        private int length;

        public FreqMap(String pattern) {
            length = pattern.length();
            for (var i = 0; i < length - 1; i++) {
                put(pattern.charAt(i), length - i - 1);
            }
        }

        @Override
        public Integer get(Object key) {
            if (!containsKey(key)) {
                return length;
            }
            return super.get(key);
        }
    }

    /**
     * Алгоритм Бойера-Мура с использованием таблицы смещений
     */
    public static int indexOf_NPlusM(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        var counter = new Counter();

        if (patternLen > textLen) {
            System.out.println("Comparisons: " + counter.value);
            return -1;
        }

        Map<Character, Integer> offsetTable = new FreqMap(pattern);
        int i = patternLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= textLen - 1) {
            j = patternLen - 1;
            k = i;
            while (j >= 0 && isMatched(text, k, pattern, j, counter)) {
                k--;
                j--;
            }
            i += offsetTable.get(text.charAt(i));
        }

        if (k >= textLen - patternLen) {
            System.out.println("Comparisons: " + counter.value);
            return -1;
        }

        System.out.println("Comparisons: " + counter.value);
        return k + 1;
    }

    private static boolean isMatched(String str1, int pos1, String str2, int pos2, Counter counter) {
        counter.value++;
        return str1.charAt(pos1) == str2.charAt(pos2);
    }

    private static boolean isNotMatched(String str1, int pos1, String str2, int pos2, Counter counter) {
        return !isMatched(str1, pos1, str2, pos2, counter);
    }
}
