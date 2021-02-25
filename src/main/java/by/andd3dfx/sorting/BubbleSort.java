package by.andd3dfx.sorting;

public class BubbleSort extends AbstractSort {

    @Override
    public void sort() {
        for (int out_index = items.length - 1; out_index > 0; out_index--) {
            for (int in_index = 0; in_index < out_index; in_index++) {
                if (items[in_index + 1] < items[in_index]) {
                    swap(in_index, in_index + 1);
                }
            }
        }
    }
}
