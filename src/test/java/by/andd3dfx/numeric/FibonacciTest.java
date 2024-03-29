package by.andd3dfx.numeric;

import org.junit.Test;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class FibonacciTest {

  @Test
  public void calculate() {
    assertThat("Expected F(2) = 1", Fibonacci.calculate(2), is(1));
    assertThat("Expected F(4) = 3", Fibonacci.calculate(4), is(3));
    assertThat("Expected F(1) = 1", Fibonacci.calculate(1), is(1));
    assertThat("Expected F(0) = 0", Fibonacci.calculate(0), is(0));
    assertThat("Expected F(8) = 21", Fibonacci.calculate(8), is(21));
    assertThat("Expected F(9) = 34", Fibonacci.calculate(9), is(34));
    assertThat("Expected F(3) = 2", Fibonacci.calculate(3), is(2));
    assertThat("Expected F(7) = 13", Fibonacci.calculate(7), is(13));
    assertThat("Expected F(10) = 55", Fibonacci.calculate(10), is(55));
    assertThat("Expected F(6) = 8", Fibonacci.calculate(6), is(8));
    assertThat("Expected F(5) = 5", Fibonacci.calculate(5), is(5));
  }

  @Test
  public void calculate2() {
    assertThat("Expected F(2) = 1", Fibonacci.calculate2(2), is(1));
    assertThat("Expected F(4) = 3", Fibonacci.calculate2(4), is(3));
    assertThat("Expected F(1) = 1", Fibonacci.calculate2(1), is(1));
    assertThat("Expected F(0) = 0", Fibonacci.calculate2(0), is(0));
    assertThat("Expected F(8) = 21", Fibonacci.calculate2(8), is(21));
    assertThat("Expected F(9) = 34", Fibonacci.calculate2(9), is(34));
    assertThat("Expected F(3) = 2", Fibonacci.calculate2(3), is(2));
    assertThat("Expected F(7) = 13", Fibonacci.calculate2(7), is(13));
    assertThat("Expected F(10) = 55", Fibonacci.calculate2(10), is(55));
    assertThat("Expected F(6) = 8", Fibonacci.calculate2(6), is(8));
    assertThat("Expected F(5) = 5", Fibonacci.calculate2(5), is(5));
  }

  @Test
  public void calculateForWrongParam() {
    checkIsExceptionThrown(Fibonacci::calculate, -1);
    checkIsExceptionThrown(Fibonacci::calculate, -10);
  }

  @Test
  public void calculate2ForWrongParam() {
    checkIsExceptionThrown(Fibonacci::calculate2, -1);
    checkIsExceptionThrown(Fibonacci::calculate2, -10);
  }

  private void checkIsExceptionThrown(Function<Integer, Integer> function, int n) {
    try {
      function.apply(n);
      fail("Exception should be thrown");
    } catch (IllegalArgumentException iae) {
      assertThat("Wrong message", iae.getMessage(), is("Number should be not less than 0!"));
    }
  }
}
