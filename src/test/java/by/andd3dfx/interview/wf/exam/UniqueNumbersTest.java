package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import org.junit.Test;

public class UniqueNumbersTest {

  @Test
  public void findUniqueNumbersWhenDuplicates() {
    assertThat("2,3 expected", UniqueNumbers.findUniqueNumbers(Arrays.asList(1, 2, 1, 3)), hasItems(2, 3));
  }

  @Test
  public void findUniqueNumbersWhenNoDuplicates() {
    assertThat("1,2,3 expected", UniqueNumbers.findUniqueNumbers(Arrays.asList(1, 2, 3)), hasItems(1, 2, 3));
  }

  @Test
  public void findUniqueNumbersWhenOnlyDuplicates() {
    assertThat("2 expected", UniqueNumbers.findUniqueNumbers(Arrays.asList(2, 2, 2, 2)).isEmpty(), is(true));
  }
}
