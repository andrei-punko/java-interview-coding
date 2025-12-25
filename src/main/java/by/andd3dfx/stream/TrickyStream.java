package by.andd3dfx.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @see <a href="https://youtu.be/Man9zRalhPs">Video solution</a>
 */
public class TrickyStream {

    /**
     * Ответ:
     * Saw 1
     * Saw 4
     * Saw 3
     * Saw 2 1
     * Saw 2 3
     * <p>
     * Cтрока "Saw 2 4" не выводится, т.к. на числе 3 выполнилось условие anyMatch() и дальнейший поиск не производится.
     * Из javadoc к anyMatch():
     * "Returns whether any elements of this stream match the provided predicate.
     * May not evaluate the predicate on all elements if not necessary for determining the result."
     */
    public static void case1() {
        Arrays.stream(new Integer[]{1, 4, 3})
            .peek(e -> {
                System.out.println("Saw " + e);
            })
            .sorted()
            .peek(e -> {
                System.out.println("Saw 2 " + e);
            })
            .anyMatch(item -> item == 3);
    }


    /**
     * It will be: 123455
     */
    public static void case2() {
        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
            .stream()
            .peek(i -> System.out.print(i))
            .filter(i -> i > 4)
            .peek(i -> System.out.print(i))
            .findAny();
    }
}
