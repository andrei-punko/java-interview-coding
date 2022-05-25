package by.andd3dfx.search;

/**
 * Есть массив целых чисел А. Необходимо для каждого элемента вывести размер его окрестности.
 * Окрестностью является непрерывная последовательность чисел той же четности, в которую входит рассматриваемое число.
 * <p>
 * Пример: для массива [1, 2, 4, 6, 1, 3, 2] результат будет [1, 3, 3, 3, 2, 2, 1]
 */
public class FindNeighborhoodSequence {

    public static Integer[] find(Integer[] a) {
        Integer[] result = new Integer[a.length];

        int currIndex = 0;
        while (currIndex < a.length) {
            int shift = 1;
            for (; currIndex + shift < a.length && (a[currIndex] - a[currIndex + shift]) % 2 == 0; shift++) {
            }

            for (int i = currIndex; i < currIndex + shift; i++) {
                result[i] = shift;
            }
            currIndex += shift;
        }

        return result;
    }
}
