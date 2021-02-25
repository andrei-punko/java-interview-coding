package by.andd3dfx.search;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class InterpolationSearchTest {

  @Test
  public void interpolationSearch() {
    assertThat("3 expected", InterpolationSearch.perform(new int[]{1, 2, 3, 4, 5}, 4), is(3));
    assertThat("1 expected", InterpolationSearch.perform(new int[]{1, 2, 2, 3, 8}, 2), is(1));
    assertThat("0 expected", InterpolationSearch.perform(new int[]{2, 2, 2, 2, 2}, 2), is(0));
  }

  @Test
  public void interpolationSearchWhenNothingFound() {
    assertThat("Wrong result", InterpolationSearch.perform(new int[]{1, 2, 3, 4, 5}, 89), is(-1));
  }
}
