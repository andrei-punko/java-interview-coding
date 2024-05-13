package by.andd3dfx.string.boyermoore;

import java.util.HashMap;
import java.util.Map;

/**
 * Алгоритм Бойера-Мура
 *
 * @see <a href="https://youtu.be/77fzfJIs_YY">Video solution</a>
 */
public class FindSubstringBoyerMoore implements IFindSubstring {

    @Override
    public int indexOf(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        var counter = new Counter();

        if (patternLen > textLen) {
            System.out.println("Comparisons: " + counter.get());
            return -1;
        }

        int shift = 0;
        var context = createContext(text, pattern);
        while (shift <= textLen - patternLen) {
            var posInPattern = patternLen - 1;
            var posInText = shift + posInPattern;
            // Идем по паттерну справа налево, сравниваем с символами в text, пока не найдем различие либо не дойдем до конца паттерна
            while (posInPattern >= 0 && isMatched(text, posInText, pattern, posInPattern, counter)) {
                posInPattern--;
                posInText--;
            }

            if (posInPattern < 0) {    // Дошли до начала паттерна, полное совпадение. Возвращаем результат
                System.out.println("Comparisons: " + counter.get());
                return shift;
            }

            shift = determineShift(text, posInText, pattern, posInPattern, counter, context);
        }

        System.out.println("Comparisons: " + counter.get());
        return -1;
    }

    protected Map<String, Object> createContext(String text, String pattern) {
        return new HashMap<>();
    }

    protected int determineShift(String text, int posInText, String pattern, int posInPattern, Counter counter, Map<String, Object> context) {
        // Нашли различие. Фиксируем posInText, уменьшаем posInPattern, ищем такой символ в нем
        posInPattern--;
        while (posInPattern >= 0 && isNotMatched(text, posInText, pattern, posInPattern, counter)) {
            posInPattern--;
        }

        if (posInPattern < 0) { // Символ в паттерне не нашли, поэтому сдвигаем паттерн так, чтобы он начинался после этого символа
            return posInText + 1;
        }

        // Нашли символ в паттерне, сдвигаем его так, чтобы выровнять позицию этого символа в паттерне и тексте
        return posInText - posInPattern;
    }
}
