package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.GreatestCommonDivisor.determineUsingLoop;
import static by.andd3dfx.numeric.GreatestCommonDivisor.determineUsingRecursion;
import static org.assertj.core.api.Assertions.assertThat;

public class GreatestCommonDivisorTest {

    @Test
    public void testDetermineUsingRecursion() {
        assertThat(determineUsingRecursion(30, 21)).isEqualTo(3);
        assertThat(determineUsingRecursion(31, 17)).isEqualTo(1);
        assertThat(determineUsingRecursion(64, 48)).isEqualTo(16);
    }

    @Test
    public void testDetermineUsingLoop() {
        assertThat(determineUsingLoop(30, 21)).isEqualTo(3);
        assertThat(determineUsingLoop(31, 17)).isEqualTo(1);
        assertThat(determineUsingLoop(64, 48)).isEqualTo(16);
    }
}
