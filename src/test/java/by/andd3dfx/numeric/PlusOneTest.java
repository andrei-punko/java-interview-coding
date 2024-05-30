package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.PlusOne.plusOne;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class PlusOneTest {

    @Test
    public void testPlusOne() {
        assertThat(plusOne(new int[]{0})).isEqualTo(new int[]{1});
        assertThat(plusOne(new int[]{1, 2, 3})).isEqualTo(new int[]{1, 2, 4});
        assertThat(plusOne(new int[]{4, 3, 2, 1})).isEqualTo(new int[]{4, 3, 2, 2});
        assertThat(plusOne(new int[]{9, 9, 9})).isEqualTo(new int[]{1, 0, 0, 0});
    }

    @Test
    public void testPlusOne_whenEmptyArray() {
        var ex = assertThrows(IllegalArgumentException.class, () -> plusOne(new int[]{}));
        assertThat(ex.getMessage()).isEqualTo("Array shouldn't be empty!");
    }
}
