package by.andd3dfx.interview.wf;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class UserInputTest {

  @Test
  public void test() {
    UserInput.TextInput input = new UserInput.NumericInput();
    input.add('1');
    input.add('a');
    input.add('0');

    assertThat("Unexpected string", input.getValue(), is("10"));
  }
}