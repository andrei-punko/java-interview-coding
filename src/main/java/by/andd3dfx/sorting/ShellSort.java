package by.andd3dfx.sorting;

public class ShellSort extends AbstractSort {

    @Override
    public void sort() {
        int h = 1; // Вычисление исходного значения h
        while (h <= items.length / 3)
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)

        while (h > 0) // Последовательное уменьшение h до 1
        {
            // h-сортировка файла
            for (int outer = h; outer < items.length; outer++) {
                long temp = items[outer];
                int inner = outer;

                // Первый подмассив (0, 4, 8)
                while (inner > h - 1 && items[inner - h] >= temp) {
                    items[inner] = items[inner - h];
                    inner -= h;
                }
                items[inner] = temp;
            }
            h = (h - 1) / 3; // Уменьшение h
        }
    }
}
