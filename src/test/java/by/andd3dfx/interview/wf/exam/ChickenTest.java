package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ChickenTest {

  @Test
  public void testChickenHatch() throws Exception {
    Chicken chicken = new Chicken();
    Egg egg = chicken.lay();
    IBird hatchedBird = egg.hatch();

    assertThat("Chicken should be instance of IBird", chicken instanceof IBird, is(true));
    assertThat("Hatched bird should be instance of Chicken", hatchedBird instanceof Chicken, is(true));
    checkExceptionDuringSecondHatching(egg);
  }

  @Test
  public void testGooseHatch() throws Exception {
    Goose goose = new Goose();
    Egg egg = goose.lay();
    IBird hatchedBird = egg.hatch();

    assertThat("Goose should be instance of IBird", goose instanceof IBird, is(true));
    assertThat("Hatched bird should be instance of Goose", hatchedBird instanceof Goose, is(true));
    checkExceptionDuringSecondHatching(egg);
  }

  private void checkExceptionDuringSecondHatching(Egg egg) throws Exception {
    try {
      egg.hatch();
      fail("Exception after second hatch should be thrown!");
    } catch (IllegalStateException ise) {
      assertThat("Wrong exception message", ise.getMessage(), is("This egg already hatched!"));
    }
  }
}
