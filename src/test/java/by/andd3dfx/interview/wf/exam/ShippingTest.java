package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ShippingTest {

  @Test
  public void minimalNumberOfPackages() {
    assertThat("8 expected", Shipping.minimalNumberOfPackages(16, 2, 10), is(8));
    assertThat("4 expected", Shipping.minimalNumberOfPackages(16, 10, 10), is(4));
    assertThat("16 expected", Shipping.minimalNumberOfPackages(16, 0, 20), is(16));
    assertThat("-1 expected", Shipping.minimalNumberOfPackages(16, 0, 10), is(-1));
  }
}
