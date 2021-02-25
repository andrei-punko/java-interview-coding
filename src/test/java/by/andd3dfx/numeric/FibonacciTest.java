package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FibonacciTest {

  @Test
  public void get() {
    assertThat("Expected F(2) = 1", Fibonacci.get(2), is(1L));
    assertThat("Expected F(4) = 3", Fibonacci.get(4), is(3L));
    assertThat("Expected F(1) = 1", Fibonacci.get(1), is(1L));
    assertThat("Expected F(8) = 21", Fibonacci.get(8), is(21L));
    assertThat("Expected F(9) = 34", Fibonacci.get(9), is(34L));
    assertThat("Expected F(3) = 2", Fibonacci.get(3), is(2L));
    assertThat("Expected F(7) = 13", Fibonacci.get(7), is(13L));
    assertThat("Expected F(10) = 55", Fibonacci.get(10), is(55L));
    assertThat("Expected F(6) = 8", Fibonacci.get(6), is(8L));
    assertThat("Expected F(5) = 5", Fibonacci.get(5), is(5L));
  }

  @Test
  public void getForWrongParam() {
    checkIsExceptionThrown(0);
    checkIsExceptionThrown(-1);
    checkIsExceptionThrown(-10);
  }

  private void checkIsExceptionThrown(int n) {
    try {
      Fibonacci.get(n);
      fail("Exception should be thrown");
    } catch (IllegalArgumentException iae) {
      assertThat("Wrong message", iae.getMessage(), is("Number should be greater than 0!"));
    }
  }
}
