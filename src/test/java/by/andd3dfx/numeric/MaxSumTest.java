package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

import by.andd3dfx.numeric.MaxSum;
import org.junit.Test;

public class MaxSumTest {

  @Test
  public void findMaxSum() {
    assertThat("20 expected", MaxSum.findMaxSum(Arrays.asList(5, 9, 7, 11)), is(20));
    assertThat("18 expected", MaxSum.findMaxSum(Arrays.asList(5, 9, 1, 9)), is(18));
  }
}
