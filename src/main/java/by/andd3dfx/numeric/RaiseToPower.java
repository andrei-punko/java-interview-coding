package by.andd3dfx.numeric;

import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

/*
  Raise number to power
  Based on "Stephens - Essential Algorithms"
 */
public class RaiseToPower {

  public static float raise(float a, int p) {
    if (p == 0) {
      return 1;
    }

    // Вычисляем a, a^2 , a^4 , a^8 и т.д., пока не получим значение a^N , где N + 1 > p
    Map<Integer, Float> map = new TreeMap<>();
    map.put(1, a);
    for (int power = 1; 2 * power <= p; power *= 2) {
      map.put(2 * power, map.get(power) * map.get(power));
    }

    // Используем эти степени a, чтобы вычислить a^P
    NavigableSet<Integer> descendingKeySet = ((TreeMap<Integer, Float>) map).descendingKeySet();
    float result = 1;
    for (Integer power : descendingKeySet) {
      while (p >= power) {
        result *= map.get(power);
        p -= power;
        System.out.println(power);
      }
    }

    return result;
  }
}
