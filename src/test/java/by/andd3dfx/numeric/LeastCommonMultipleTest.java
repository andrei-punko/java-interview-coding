package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.LeastCommonMultiple.find;
import static by.andd3dfx.numeric.LeastCommonMultiple.find_usingGCD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class LeastCommonMultipleTest {

    @Test
    public void testFind() {
        assertThrows("Numbers array should be populated!",
                IllegalArgumentException.class, () -> find(new int[]{}));

        assertThat(find(new int[]{10})).isEqualTo(10);
        assertThat(find(new int[]{11})).isEqualTo(11);

        assertThat(find(new int[]{2, 3})).isEqualTo(6);
        assertThat(find(new int[]{4, 6})).isEqualTo(12);
        // 6240 = 2^5 * 3 * 5 * 13
        // 6800 = 2^4 * 5^2 * 17
        // НОК(6240, 6800) = 2^5 * 3 * 5^2 * 13 * 17
        assertThat(find(new int[]{6240, 6800})).isEqualTo(530_400);

        assertThat(find(new int[]{6, 9, 20})).isEqualTo(180);
    }

    @Test
    public void testFind_usingGCD() {
        assertThrows("Numbers array should be populated!",
                IllegalArgumentException.class, () -> find_usingGCD(new int[]{}));

        assertThat(find_usingGCD(new int[]{10})).isEqualTo(10);
        assertThat(find_usingGCD(new int[]{11})).isEqualTo(11);

        assertThat(find_usingGCD(new int[]{2, 3})).isEqualTo(6);
        assertThat(find_usingGCD(new int[]{4, 6})).isEqualTo(12);
        // 6240 = 2^5 * 3 * 5 * 13
        // 6800 = 2^4 * 5^2 * 17
        // НОК(6240, 6800) = 2^5 * 3 * 5^2 * 13 * 17
        assertThat(find_usingGCD(new int[]{6240, 6800})).isEqualTo(530_400);

        assertThat(find_usingGCD(new int[]{6, 9, 20})).isEqualTo(180);
    }
}
