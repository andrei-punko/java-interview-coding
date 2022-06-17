package by.andd3dfx.interview.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.Test;

public class NeedleTest {

  @Test
  public void countOneLine() throws Exception {
    String inMessage = "Hello, there!";

    assertThat(Needle.count("there", buildStream(inMessage)), is(1));
    assertThat(Needle.count("small", buildStream(inMessage)), is(0));
  }

  @Test
  public void countMultiLine() throws Exception {
    String inMessage = "Hello, there!\nHow are you today?\nYes, you over there.";

    assertThat(Needle.count("there", buildStream(inMessage)), is(2));
    assertThat(Needle.count("today", buildStream(inMessage)), is(1));
    assertThat(Needle.count("small", buildStream(inMessage)), is(0));
  }

  private ByteArrayInputStream buildStream(String inMessage) {
    return new ByteArrayInputStream(inMessage.getBytes());
  }
}
