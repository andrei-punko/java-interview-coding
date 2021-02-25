package by.andd3dfx.numeric;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class BitsRowTest {

  @Test
  public void determineBit() {
    assertThat("f(0)=1 expected", BitsRow.determineBit(0), is(1));
    assertThat("f(1)=0 expected", BitsRow.determineBit(1), is(0));
    assertThat("f(2)=1 expected", BitsRow.determineBit(2), is(1));
    assertThat("f(14)=1 expected", BitsRow.determineBit(14), is(1));
    assertThat("f(15)=0 expected", BitsRow.determineBit(15), is(0));
  }
}
