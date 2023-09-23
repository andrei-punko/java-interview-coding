package by.andd3dfx.numeric;

import org.junit.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class AddDigitsTest {

    @Test
    public void testAddDigits() {
        makeTestsNCheckAssertions(AddDigits::addDigits);
    }

    @Test
    public void testAddDigits_usingDigitalRoot() {
        makeTestsNCheckAssertions(AddDigits::addDigits_usingDigitalRoot);
    }

    private static void makeTestsNCheckAssertions(Function<Integer, Integer> func) {
        for (int i = 0; i <= 9; i++) {
            assertThat(func.apply(i)).isEqualTo(i);
        }
        assertThat(func.apply(15)).isEqualTo(6);
        assertThat(func.apply(38)).isEqualTo(2);
    }
}
