package by.andd3dfx.numeric;

/*
  Revert order of digits in Integer number
 */
public class ReverseDigitsOrder {

  public static int perform(int number) {
    int result = 0;
    do {
      int digit = number % 10;
      result = result * 10 + digit;
      number /= 10;
    } while (number > 0);

    return result;
  }
}
