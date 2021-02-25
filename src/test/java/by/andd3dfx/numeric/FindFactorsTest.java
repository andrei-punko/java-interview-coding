package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class FindFactorsTest {

  @Test
  public void determine() {
    assertThat("37 number expected", FindFactors.determine(37), hasItems(37));
    assertThat("3,7 numbers expected", FindFactors.determine(21), hasItems(3, 7));
    assertThat("2,2,3 numbers expected", FindFactors.determine(36), hasItems(2, 2, 3));
  }
}
