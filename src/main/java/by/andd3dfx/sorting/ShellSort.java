package by.andd3dfx.sorting;

public class ShellSort {

    public static <T extends Comparable> void apply(T[] array) {
        int d = 1;

        while (d <= array.length / 3) {
            d = d * 3 + 1;      // (1, 4, 13, 40, 121, ...)
        }

        while (d > 0) {
            for (int outer = d; outer < array.length; outer++) {
                var tmp = array[outer];
                int inner = outer;

                while (inner - d >= 0 && greaterThan(array[inner - d], tmp)) {
                    array[inner] = array[inner - d];
                    inner -= d;
                }
                array[inner] = tmp;
            }

            d = (d - 1) / 3;
        }
    }

    private static <T extends Comparable> boolean greaterThan(T a, T b) {
        return a.compareTo(b) > 0;
    }
}
