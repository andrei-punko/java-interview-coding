package by.andd3dfx.common.birdsfarm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
        assertTrue(chicken instanceof IBird, "Chicken should be instance of IBird");

        Egg egg = chicken.lay();
        IBird hatchedBird = egg.hatch();

        assertTrue(hatchedBird instanceof Chicken, "Hatched bird should be instance of Chicken");
        assertFalse(hatchedBird instanceof Goose, "Hatched bird shouldn't be instance of Goose");
        checkExceptionDuringSecondHatching(egg);
    }

    @Test
    public void testGooseHatch() throws Exception {
        Goose goose = new Goose();
        assertTrue(goose instanceof IBird, "Goose should be instance of IBird");

        Egg egg = goose.lay();
        IBird hatchedBird = egg.hatch();

        assertTrue(hatchedBird instanceof Goose, "Hatched bird should be instance of Goose");
        assertFalse(hatchedBird instanceof Chicken, "Hatched bird shouldn't be instance of Chicken");
        checkExceptionDuringSecondHatching(egg);
    }

    private void checkExceptionDuringSecondHatching(Egg egg) throws Exception {
        try {
            egg.hatch();
            fail("Exception after second hatch should be thrown!");
        } catch (IllegalStateException ise) {
            assertThat(ise.getMessage()).isEqualTo("This egg already hatched!");
        }
    }
}
