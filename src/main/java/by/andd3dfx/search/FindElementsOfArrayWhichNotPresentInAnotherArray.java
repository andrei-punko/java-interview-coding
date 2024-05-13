package by.andd3dfx.search;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Даны два отсортированных массива (A1,A2...AN), (B1,B2...BN), значения могут быть отрицательными, могут повторяться.
 * Вернуть элементы первого массива, которых нет во втором массиве.
 *
 * input {-1, 2, 2, 5, 7} {2, 5, 8, 8, 8}
 * output {-1, 7}
 * </pre>
 *
 * @see <a href="https://youtu.be/bJIzoT-CmUg">Video solution</a>
 */
public class FindElementsOfArrayWhichNotPresentInAnotherArray {

    public static Integer[] find(Integer[] a, Integer[] b) {
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result.add(a[i]);
                i++;
            } else if (a[i] > b[j]) {
                result.add(b[j]);
                j++;
            } else {
                var element = a[i];
                while (i < a.length && a[i] == element) i++;
                while (j < b.length && b[j] == element) j++;
            }
        }

        // Add remaining part of a[]
        while (i < a.length) {
            result.add(a[i]);
            i++;
        }

        return result.toArray(new Integer[0]);
    }
}
