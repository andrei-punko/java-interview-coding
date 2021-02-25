package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class RaiseToPowerTest {

  @Test
  public void raise() {
    assertThat("3^3 = 9", RaiseToPower.raise(3f, 3), is(27f));
    assertThat("3^5 = 243", RaiseToPower.raise(3f, 5), is(243f));
    assertThat("2^13 = 8192", RaiseToPower.raise(2f, 13), is(8192f));
  }
}
