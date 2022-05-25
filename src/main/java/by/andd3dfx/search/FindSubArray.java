package by.andd3dfx.search;

import java.util.Collections;
import java.util.HashSet;

/**
 * Даны два отсортированных массива (A1,A2...AN), (B1,B2...BN), значения могут быть отрицательными, могут повторяться.
 * Вернуть элементы первого массива, которых нет во втором массиве.
 * <p>
 * input {-1, 2, 2, 5, 7} {2, 5, 8, 8, 8}
 * output {-1, 7}
 */
public class FindSubArray {

    public static Integer[] find(Integer[] a, Integer[] b) {
        var aSet = new HashSet<>();
        Collections.addAll(aSet, a);

        var bSet = new HashSet<>();
        Collections.addAll(bSet, b);

        aSet.removeAll(bSet);

        return aSet.toArray(new Integer[0]);
    }
}
