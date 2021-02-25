package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StoriesTest {

  @Test
  public void combinations() {
    assertThat("1 expected", Stories.combinations(1), is(1));
    assertThat("2 expected", Stories.combinations(2), is(2));
    assertThat("3 expected", Stories.combinations(3), is(3));
    assertThat("5 expected", Stories.combinations(4), is(5));
  }

  @Test
  public void fibonacci() {
    assertThat("1 expected", Stories.fibonacci(1), is(1));
    assertThat("1 expected", Stories.fibonacci(2), is(1));
    assertThat("2 expected", Stories.fibonacci(3), is(2));
    assertThat("3 expected", Stories.fibonacci(4), is(3));
    assertThat("5 expected", Stories.fibonacci(5), is(5));
    assertThat("8 expected", Stories.fibonacci(6), is(8));
  }
}
