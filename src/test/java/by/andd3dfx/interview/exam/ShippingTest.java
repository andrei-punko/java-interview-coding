package by.andd3dfx.interview.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ShippingTest {

  @Test
  public void minimalNumberOfPackages() {
    assertThat(Shipping.minimalNumberOfPackages(16, 2, 10), is(8));
    assertThat(Shipping.minimalNumberOfPackages(16, 10, 10), is(4));
  }

  @Test
  public void minimalNumberOfPackagesWhenLargePackagesOnly() {
    assertThat(Shipping.minimalNumberOfPackages(15, 10, 0), is(3));
  }

  @Test
  public void minimalNumberOfPackagesWhenLargePackagesOnlyThatNotFit() {
    assertThat(Shipping.minimalNumberOfPackages(16, 10, 0), is(-1));
  }

  @Test
  public void minimalNumberOfPackagesWhenSmallPackagesOnly() {
    assertThat(Shipping.minimalNumberOfPackages(16, 0, 20), is(16));
  }

  @Test
  public void minimalNumberOfPackagesWhenSmallPackagesOnlyButNotEnoughPackages() {
    assertThat(Shipping.minimalNumberOfPackages(16, 0, 10), is(-1));
  }

  @Test
  public void minimalNumberOfPackagesWhenNotEnoughPackages() {
    assertThat(Shipping.minimalNumberOfPackages(16, 1, 10), is(-1));
  }
}
