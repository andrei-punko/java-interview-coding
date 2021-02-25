package by.andd3dfx.search;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SortedSearchTest {

  @Test
  public void countNumbersWhenArrayDoesNotContainsTargetItem() {
    assertThat("2 elements less than 4", SortedSearch.countNumbers(new int[]{1, 3, 5, 7}, 4), is(2));
  }

  @Test
  public void countNumbersWhenArrayContainsTargetItem() {
    assertThat("2 elements less than 4", SortedSearch.countNumbers(new int[]{1, 3, 4, 5, 7}, 4), is(2));
  }

  @Test
  public void countNumbersWhenAllElementsGreaterThanTargetItem() {
    assertThat("0 elements less than 4", SortedSearch.countNumbers(new int[]{5, 6, 7, 8}, 4), is(0));
  }

  @Test
  public void countNumbersWhenAllElementsLessThanTargetItem() {
    assertThat("4 elements less than 4", SortedSearch.countNumbers(new int[]{1, 2, 3, 3}, 4), is(4));
  }
}