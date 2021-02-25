package by.andd3dfx.interview.wf;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class TwoSumTest {

  @Test
  public void findTwoSum() {
    int[] result = TwoSum.findTwoSum(new int[]{1, 3, 5, 7, 9}, 12);

    assertThat("Any of these results expected", result, anyOf(
        equalTo(new int[]{1, 4}),
        equalTo(new int[]{2, 3}),
        equalTo(new int[]{3, 2}),
        equalTo(new int[]{4, 1})));
  }

  @Test
  public void findTwoSumForSameNumbers() {
    int[] result = TwoSum.findTwoSum(new int[]{1, 1, 6, 6, 1}, 12);

    assertThat("Any of these results expected", result, anyOf(
        equalTo(new int[]{2, 3}),
        equalTo(new int[]{3, 2})
    ));
  }

  @Test
  public void findTwoSumForAbsentSolution() {
    int[] result = TwoSum.findTwoSum(new int[]{1, 1, 6, 3, 1}, 12);

    assertThat("Solution should not be found", result, nullValue());
  }
}
