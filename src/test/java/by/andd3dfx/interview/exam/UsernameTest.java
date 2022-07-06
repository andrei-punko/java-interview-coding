package by.andd3dfx.interview.exam;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UsernameTest {

  @Test
  public void validate() {
    assertTrue("Valid username", Username.validate("Mike-Standish"));
    assertTrue("Valid username with digits", Username.validate("Mike-Standish78"));

    assertFalse("Invalid username: starts from digit", Username.validate("8MikeStand"));
    assertFalse("Invalid username: 2 '-'", Username.validate("Mike--Standish"));
    assertFalse("Invalid username: '-' at the end", Username.validate("MikeStandish-"));
    assertFalse("Invalid username: space presents", Username.validate("Mike Standish"));
    assertFalse("Invalid username: too long", Username.validate("MikegfhgfhgfhgfhgfhStandish"));
    assertFalse("Invalid username: too short", Username.validate("Mik"));
  }
}
