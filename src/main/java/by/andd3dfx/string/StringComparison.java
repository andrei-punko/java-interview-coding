package by.andd3dfx.string;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <pre>
 * String comparison methods
 *
 * Dice-Sørensen coefficient, also known as:
 * - Sørensen–Dice index
 * - Sørensen index
 * - Dice's coefficient
 * - Dice similarity coefficient (DSC)
 * </pre>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Dice-S%C3%B8rensen_coefficient">Wiki page</a>
 * @see <a href="https://youtu.be/i7O4R4gfZqE">Video solution</a>
 * @see <a href="https://habr.com/ru/articles/671136/">Habr article</a>
 */
public class StringComparison {

    public static double serencen(String first, String second) {
        return serencen(toBigram(first), toBigram(second));
    }

    private static Set<String> toBigram(String text) {
        if (text == null || text.length() < 2) {
            return new HashSet<>();
        }

        // Создаем поток индексов от 0 до length - 2 и собираем биграммы в Set
        return IntStream.range(0, text.length() - 1)
            .mapToObj(i -> text.substring(i, i + 2))
            .collect(HashSet::new, Set::add, Set::addAll);
    }

    public static <T> double serencen(Set<T> set1, Set<T> set2) {
        var intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return 2.0 * intersection.size() / (set1.size() + set2.size());
    }
}
