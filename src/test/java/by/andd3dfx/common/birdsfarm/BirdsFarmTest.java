package by.andd3dfx.common.birdsfarm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Tests:
 * - Chicken is an IBird
 * - Chickens make other chickens
 * - Other birds don't make chickens
 * - Eggs can't hatch twice
 */
public class BirdsFarmTest {

    @Test
    public void testChickenHatch() throws Exception {
        Chicken chicken = new Chicken();
        assertTrue("Chicken should be instance of IBird", chicken instanceof IBird);

        Egg egg = chicken.lay();
        IBird hatchedBird = egg.hatch();

        assertTrue("Hatched bird should be instance of Chicken", hatchedBird instanceof Chicken);
        assertFalse("Hatched bird shouldn't be instance of Goose", hatchedBird instanceof Goose);
        checkExceptionDuringSecondHatching(egg);
    }

    @Test
    public void testGooseHatch() throws Exception {
        Goose goose = new Goose();
        assertTrue("Goose should be instance of IBird", goose instanceof IBird);

        Egg egg = goose.lay();
        IBird hatchedBird = egg.hatch();

        assertTrue("Hatched bird should be instance of Goose", hatchedBird instanceof Goose);
        assertFalse("Hatched bird shouldn't be instance of Chicken", hatchedBird instanceof Chicken);
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
