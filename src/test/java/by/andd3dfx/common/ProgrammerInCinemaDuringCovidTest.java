package by.andd3dfx.common;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgrammerInCinemaDuringCovidTest {

    static Stream<Arguments> data() {
        return Stream.of(
            Arguments.of("Interval with length=3", new int[]{1, 0, 0, 0, 1}, 2),
            Arguments.of("Interval with length=4", new int[]{1, 0, 0, 0, 0, 1}, 2),
            Arguments.of("Interval with length=5", new int[]{1, 0, 0, 0, 0, 0, 1}, 3),
            Arguments.of("Two intervals", new int[]{1, 0, 0, 0, 0, 0, 1, 0, 0, 1}, 3),
            Arguments.of("Right interval", new int[]{1, 0, 0, 0}, 3),
            Arguments.of("Left interval", new int[]{0, 0, 1, 0}, 2)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("data")
    public void testFind(String name, int[] input, int expected) {
        assertEquals(expected, ProgrammerInCinemaDuringCovid.find(input));
    }
}
