package by.andd3dfx.numeric;

import java.util.ArrayList;
import java.util.List;

/*
  Determine simple dividers
  Based on "Stephens - Essential Algorithms"
 */
public class FindFactors {

  public static List<Integer> determine(Integer number) {
    List<Integer> factors = new ArrayList<>();

    // Проверяем делимость на 2:
    while (number % 2 == 0) {
      factors.add(2);
      number /= 2;
    }

    // Ищем нечетные множители:
    int i = 3;
    int maxFactor = (int) Math.sqrt(number);
    while (i <= maxFactor) {
      // Проверяем делимость на i:
      while (number % i == 0) {
        // i является множителем. Добавляем его в список:
        factors.add(i);
        // Делим число на i:
        number /= i;

        // Устанавливаем новую верхнюю границу:
        maxFactor = (int) Math.sqrt(number);
      }
      // Проверяем следующий возможный нечетный множитель:
      i += 2;
    }

    // Если от числа что-то осталось, остаток тоже множитель:
    if (number > 1) {
      factors.add(number);
    }

    return factors;
  }
}
