package by.andd3dfx.sorting;

public class SelectionSort extends AbstractSort {

    @Override
    public void sort() {
        for (int out_index = 0; out_index < items.length; out_index++) {
            int min_index = out_index;
            for (int in_index = out_index + 1; in_index < items.length; in_index++) {
                if (items[in_index] < items[min_index]) min_index = in_index;
            }
            swap(out_index, min_index);
        }
    }
}
