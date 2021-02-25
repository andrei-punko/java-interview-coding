package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.Test;

public class NeedleTest {

  @Test
  public void count() throws Exception {
    assertThat("2 expected", Needle.count("there", buildStream()), is(2));
    assertThat("1 expected", Needle.count("today", buildStream()), is(1));
    assertThat("0 expected", Needle.count("small", buildStream()), is(0));
  }

  private ByteArrayInputStream buildStream() {
    String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";
    return new ByteArrayInputStream(inMessage.getBytes());
  }
}
