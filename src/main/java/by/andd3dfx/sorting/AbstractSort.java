package by.andd3dfx.sorting;

import java.util.Arrays;

public abstract class AbstractSort {

    protected Long[] items;

    public void init(Long[] items) {
        this.items = items;
    }

    public abstract void sort();

    public Long[] getItems() {
        return Arrays.copyOf(items, items.length);
    }
}
