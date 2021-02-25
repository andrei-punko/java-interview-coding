package by.andd3dfx.numeric;

/*
  Determine greatest common divisor
  Based on "Stephens - Essential Algorithms"
 */
public class GreatestCommonDivisor {

  public static int determineGCD(int a, int b) {
    while (b != 0) {
      int remainder = a % b;
      a = b;
      b = remainder;
    }
    return a;
  }
}
