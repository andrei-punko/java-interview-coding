package by.andd3dfx.collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Examples how to reverse any list using different methods
 */
public class ReverseAnySequence {

    public static <T> List<T> reverseUsingStack(List<T> list) {
        var stack = new ArrayDeque<T>();
        list.forEach(stack::push);
        return stack.stream().toList();
    }

    public static <T> List<T> reverseUsingRecursion(List<T> list) {
        if (list.size() == 1) {
            return list;
        }

        var firstItem = list.get(0);
        List<T> subList = list.subList(1, list.size());
        return compose(reverseUsingRecursion(subList), firstItem);
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
