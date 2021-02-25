package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class UsernameTest {

  @Test
  public void validate() {
    assertThat("Valid username", Username.validate("Mike-Standish"), is(true));
    assertThat("Valid username with digits", Username.validate("Mike-Standish78"), is(true));
    assertThat("Invalid username: starts from digit", Username.validate("8MikeStand"), is(false));
    assertThat("Invalid username: 2 '-'", Username.validate("Mike--Standish"), is(false));
    assertThat("Invalid username: '-' at the end", Username.validate("MikeStandish-"), is(false));
    assertThat("Invalid username: space presents", Username.validate("Mike Standish"), is(false));
    assertThat("Invalid username: too long", Username.validate("MikegfhgfhgfhgfhgfhStandish"), is(false));
    assertThat("Invalid username: too short", Username.validate("Mik"), is(false));
  }
}
