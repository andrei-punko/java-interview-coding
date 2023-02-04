package by.andd3dfx.sorting.others;

/**
 * По мотивам алгоритма из "Вирт - Алгоритмы и структуры данных"
 */
public class InsertionSort {

    public static <T extends Comparable> void apply(T[] array) {
        for (int i = 1; i < array.length; i++) {
            var x = array[i];

            // Вставить x в правильную позицию среди array[0]...array[i-1]
            var j = i;
            while (j > 0 && x.compareTo(array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = x;
        }
    }
}
