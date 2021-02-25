package by.andd3dfx.numeric;

/*
  We have infinite row of numbers: 10100100010000100000...
  Write function that returns 0 or 1 by position number, for example:
  f(0)=1, f(1)=0, f(2)=1, f(14)=1, f(15)=0, ...
 */
public class BitsRow {

  public static int determineBit(int n) {
    int period = 1;
    int position = 0;

    for (; ; ) {
      if (position == n) {
        return 1;
      }
      position++;

      if (n < position + period) {
        return 0;
      }
      position += period;

      period++;
    }
  }
}
