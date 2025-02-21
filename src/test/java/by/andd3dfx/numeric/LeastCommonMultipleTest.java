package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LeastCommonMultipleTest {

    @Test
    public void testFind() {
        assertThat(LeastCommonMultiple.find(new int[]{10}), is(10));
        assertThat(LeastCommonMultiple.find(new int[]{11}), is(11));

        assertThat(LeastCommonMultiple.find(new int[]{2, 3}), is(6));
        assertThat(LeastCommonMultiple.find(new int[]{4, 6}), is(12));
        // 6240 = 10*4*2*2*39
        // 6800 = 10*4*2*5*17
        assertThat(LeastCommonMultiple.find(new int[]{6240, 6800}), is(10 * 4 * 2 * 2 * 39 * 5 * 17));

        assertThat(LeastCommonMultiple.find(new int[]{6, 9, 20}), is(180));
    }

    @Test
    public void testFind_usingGCD() {
        assertThat(LeastCommonMultiple.find_usingGCD(new int[]{10}), is(10));
        assertThat(LeastCommonMultiple.find_usingGCD(new int[]{11}), is(11));

        assertThat(LeastCommonMultiple.find_usingGCD(new int[]{2, 3}), is(6));
        assertThat(LeastCommonMultiple.find_usingGCD(new int[]{4, 6}), is(12));
        // 6240 = 10*4*2*2*39
        // 6800 = 10*4*2*5*17
        assertThat(LeastCommonMultiple.find_usingGCD(new int[]{6240, 6800}), is(10 * 4 * 2 * 2 * 39 * 5 * 17));

        assertThat(LeastCommonMultiple.find_usingGCD(new int[]{6, 9, 20}), is(180));
    }
}
