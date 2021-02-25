package by.andd3dfx.sorting;

public class InsertionSort extends AbstractSort {

    @Override
    public void sort() {
        for (int out_index = 1; out_index < items.length; out_index++) {
            long temp = items[out_index];
            int in_index;
            for (in_index = out_index; in_index > 0 && items[in_index - 1] >= temp; in_index--) {
                swap(in_index, in_index - 1);
            }
            items[in_index] = temp;
        }
    }
}
