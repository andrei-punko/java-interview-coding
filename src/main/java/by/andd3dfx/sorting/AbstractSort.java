package by.andd3dfx.sorting;

import java.util.Arrays;

public abstract class AbstractSort<T extends Comparable<T>> {

    protected T[] items;

    public void init(T[] items) {
        this.items = items;
    }

    public abstract void sort();

    protected void swap(int in_index, int out_index) {
        T temp = items[in_index];
        items[in_index] = items[out_index];
        items[out_index] = temp;
    }

    public T[] getItems() {
        return Arrays.copyOf(items, items.length);
    }

    protected boolean lessThan(T a, T b) {
        return a.compareTo(b) < 0;
    }

    protected boolean lessOrEqualsThan(T a, T b) {
        return a.compareTo(b) <= 0;
    }

    protected boolean greaterOrEqualsThan(T a, T b) {
        return a.compareTo(b) >= 0;
    }
}
