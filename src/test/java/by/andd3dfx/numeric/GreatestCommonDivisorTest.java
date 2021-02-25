package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class GreatestCommonDivisorTest {

  @Test
  public void determineGCD() {
    assertThat("GCD(30, 21) = 3", GreatestCommonDivisor.determineGCD(30, 21), is(3));
    assertThat("GCD(31, 17) = 1", GreatestCommonDivisor.determineGCD(31, 17), is(1));
    assertThat("GCD(64, 48) = 16", GreatestCommonDivisor.determineGCD(64, 48), is(16));
  }
}
