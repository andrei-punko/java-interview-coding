package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class CandiesTest {

  @Test
  public void countCandies() {
    assertThat("5 candies expected", Candies.countCandies(3, 2), is(5));
    assertThat("1 candy expected", Candies.countCandies(1, 2), is(1));
    assertThat("9 candies expected", Candies.countCandies(5, 2), is(9));
  }
}
