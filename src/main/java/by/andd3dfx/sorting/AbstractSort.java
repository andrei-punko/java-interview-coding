package by.andd3dfx.sorting;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractSort {

    protected Long[] items;

    public void insert(Long[] items) {
        this.items = items;
    }

    protected void insert(List<Long> bucket) {
        this.items = bucket.toArray(new Long[0]);
    }

    public abstract void sort();

    protected void swap(int in_index, int out_index) {
        long temp = items[in_index];
        items[in_index] = items[out_index];
        items[out_index] = temp;
    }

    public Long[] getItems() {
        return Arrays.copyOf(items, items.length);
    }
}
