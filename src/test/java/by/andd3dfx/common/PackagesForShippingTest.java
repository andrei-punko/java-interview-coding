package by.andd3dfx.common;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PackagesForShippingTest {
  private PackagesForShipping shipping;

  @Before
  public void setUp() throws Exception {
    shipping = new PackagesForShipping(5, 2);
  }

  @Test
  public void minimalNumberOfPackages() {
    assertThat(shipping.minimalNumberOfPackages(16, 2, 10), is(5));
    assertThat(shipping.minimalNumberOfPackages(14, 10, 10), is(4));
  }

  @Test
  public void largePackagesOnly() {
    assertThat(shipping.minimalNumberOfPackages(15, 10, 0), is(3));
  }

  @Test
  public void largePackagesOnlyThatNotFit() {
    assertThat(shipping.minimalNumberOfPackages(16, 10, 0), is(-1));
  }

  @Test
  public void smallPackagesOnly() {
    assertThat(shipping.minimalNumberOfPackages(16, 0, 20), is(8));
  }

  @Test
  public void smallPackagesOnlyThatNotFit() {
    assertThat(shipping.minimalNumberOfPackages(17, 0, 20), is(-1));
  }

  @Test
  public void smallPackagesOnlyButNotEnoughPackages() {
    assertThat(shipping.minimalNumberOfPackages(16, 0, 7), is(-1));
  }

  @Test
  public void largePackagesOnlyButNotEnoughPackages() {
    assertThat(shipping.minimalNumberOfPackages(15, 2, 0), is(-1));
  }

  @Test
  public void notEnoughPackages() {
    assertThat(shipping.minimalNumberOfPackages(16, 1, 5), is(-1));
  }
}
