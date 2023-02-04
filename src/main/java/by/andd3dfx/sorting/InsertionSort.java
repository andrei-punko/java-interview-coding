package by.andd3dfx.sorting;

/**
 * По мотивам алгоритма из "Вирт - Алгоритмы и структуры данных"
 */
public class InsertionSort extends AbstractSort {

    @Override
    public void sort() {
        for (int i = 1; i < items.length; i++) {
            var x = items[i];

            // Вставить х в правильную позицию среди items[0] ... items[i-1]
            var j = i;
            while (j > 0 && lessThan(x, items[j - 1])) {
                items[j] = items[j - 1];
                j--;
            }
            items[j] = x;
        }
    }
}
