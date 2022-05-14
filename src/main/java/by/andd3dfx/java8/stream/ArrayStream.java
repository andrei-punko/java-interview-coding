package by.andd3dfx.java8.stream;

import java.util.Arrays;

/**
 * Что напечатает следующее выражение:
 * <pre>
 * Arrays.stream(new Integer[]{1, 4, 3})
 *         .peek(e -> {
 *             System.out.println("Saw " + e);
 *         })
 *         .sorted()
 *         .peek(e -> {
 *             System.out.println("Saw 2 " + e);
 *         })
 *         .anyMatch(item -> item == 3);
 * </pre>
 */
public class ArrayStream {

    public static void main(String[] args) {
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
     * Ответ:
     * Saw 1
     * Saw 4
     * Saw 3
     * Saw 2 1
     * Saw 2 3
     *
     * Cтрока "Saw 2 4" не выводится, т.к. на числе 3 выполнилось условие anyMatch() и дальнейший поиск не производится.
     * Из javadoc к anyMatch():
     * "Returns whether any elements of this stream match the provided predicate.
     * May not evaluate the predicate on all elements if not necessary for determining the result."
     */
}
