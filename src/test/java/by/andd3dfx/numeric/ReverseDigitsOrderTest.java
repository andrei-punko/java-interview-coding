package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ReverseDigitsOrderTest {

  @Test
  public void reverse() {
    assertThat("Wrong result", ReverseDigitsOrder.perform(12369), is(96321));
  }
}
