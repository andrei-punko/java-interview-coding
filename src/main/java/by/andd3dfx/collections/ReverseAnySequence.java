package by.andd3dfx.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Examples how to reverse any list using different methods
 */
public class ReverseAnySequence {

    public static <T> List<T> reverseUsingStack(List<T> list) {
        ArrayDeque<T> stack = new ArrayDeque<>();
        for (T item : list) {
            stack.push(item);
        }

        List<T> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static <T> List<T> reverseUsingRecursion(List<T> list) {
        if (list.size() == 1) {
            return list;
        }

        T item = list.get(0);
        List<T> subList = list.subList(1, list.size());
        return compose(reverseUsingRecursion(subList), item);
    }

    private static <T> List<T> compose(List<T> list, T item) {
        List<T> result = new ArrayList<>(list);
        result.add(item);
        return result;
    }

    public static <T> List<T> reverseUsingLoop(List<T> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            swap(list, i, list.size() - 1 - i);
        }
        return list;
    }

    private static <T> void swap(List<T> list, int i, int j) {
        var tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }
}
