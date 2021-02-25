package by.andd3dfx.sorting;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class FindTopNNumbersTest {

  @Test
  public void find() {
    assertThat("{4,3} expected", FindTopNNumbers.find(new int[]{1, 3, 4}, 2), is(new int[]{4, 3}));
    assertThat("{90,56,44,34,5}",
        FindTopNNumbers.find(new int[]{1, 34, 56, 44, 0, -3, 90, 5, 3, 4}, 5),
        is(new int[]{90, 56, 44, 34, 5}));
  }
}
