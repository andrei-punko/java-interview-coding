package by.andd3dfx.interview.wf.exam;

public class Candies {

  public static int countCandies(int startingAmount, int newEvery) {
    if (startingAmount < 0 || newEvery <= 0) {
      return 0;
    }

    int candiesAmount = startingAmount;
    int eaten = 0;

    while (candiesAmount >= newEvery) {
      int bonus = candiesAmount / newEvery;
      eaten += newEvery * bonus;
      candiesAmount -= newEvery * bonus;
      candiesAmount += bonus;
    }
    return eaten + candiesAmount;
  }

  public static void main(String[] args) {
    System.out.println(Candies.countCandies(3, 2));
  }
}
