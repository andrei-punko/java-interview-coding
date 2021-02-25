package by.andd3dfx.search;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

  @Test
  public void binarySearch() {
    assertThat("3 expected", BinarySearch.search(new int[]{1, 2, 3, 4, 5}, 4), is(3));
    assertThat("4 expected", BinarySearch.search(new int[]{1, 2, 3, 4, 5}, 5), is(4));
  }

  @Test
  public void binarySearchWhenNothingFound() {
    assertThat("Wrong result", BinarySearch.search(new int[]{1, 2, 3, 4, 5}, 89), is(-1));
  }
}
