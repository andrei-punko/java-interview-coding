package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GreatestCommonDivisorTest {

    @Test
    public void determineUsingRecursion() {
        assertThat(GreatestCommonDivisor.determineUsingRecursion(30, 21), is(3));
        assertThat(GreatestCommonDivisor.determineUsingRecursion(31, 17), is(1));
        assertThat(GreatestCommonDivisor.determineUsingRecursion(64, 48), is(16));
    }

    @Test
    public void determineUsingLoop() {
        assertThat(GreatestCommonDivisor.determineUsingLoop(30, 21), is(3));
        assertThat(GreatestCommonDivisor.determineUsingLoop(31, 17), is(1));
        assertThat(GreatestCommonDivisor.determineUsingLoop(64, 48), is(16));
    }
}
