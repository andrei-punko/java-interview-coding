package by.andd3dfx.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ProgrammerInCinemaDuringCovidTest {

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Interval with length=3", new int[]{1, 0, 0, 0, 1}, 2},
                {"Interval with length=4", new int[]{1, 0, 0, 0, 0, 1}, 2},
                {"Interval with length=5", new int[]{1, 0, 0, 0, 0, 0, 1}, 3},
                {"Two intervals", new int[]{1, 0, 0, 0, 0, 0, 1, 0, 0, 1}, 3},
                {"Right interval", new int[]{1, 0, 0, 0}, 3},
                {"Left interval", new int[]{0, 0, 1, 0}, 2},
        });
    }

    @Parameter
    public String name;

    @Parameter(1)
    public int[] input;

    @Parameter(2)
    public int expected;

    @Test
    public void testFind() {
        assertEquals(expected, ProgrammerInCinemaDuringCovid.find(input));
    }
}
