package by.andd3dfx.sorting;

public class ShellSort {

    public static <T extends Comparable> void apply(T[] array) {
        int h = 1; // Вычисление исходного значения h
        while (h <= array.length / 3)
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)

        while (h > 0) // Последовательное уменьшение h до 1
        {
            // h-сортировка файла
            for (int outer = h; outer < array.length; outer++) {
                var temp = array[outer];
                int inner = outer;

                // Первый подмассив (0, 4, 8)
                while (inner > h - 1 && greaterOrEqualsThan(array[inner - h], temp)) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3; // Уменьшение h
        }
    }

    private static <T extends Comparable> boolean greaterOrEqualsThan(T a, T b) {
        return a.compareTo(b) >= 0;
    }
}
