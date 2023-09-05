package by.andd3dfx.numeric;

import org.junit.Ignore;
import org.junit.Test;

import static by.andd3dfx.numeric.SumOfTwoIntegersWithoutUsingPlusMinus.getSum;
import static by.andd3dfx.numeric.SumOfTwoIntegersWithoutUsingPlusMinus.incNthBit;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * https://leetcode.com/problems/sum-of-two-integers/
 *
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Example 2:
 *
 * Input: a = 2, b = 3
 * Output: 5
 * </pre>
 */
public class SumOfTwoIntegersWithoutUsingPlusMinusTest {

    @Test
    public void testGetSum() {
        assertThat(getSum(1, 0)).isEqualTo(1);
        assertThat(getSum(1, 2)).isEqualTo(3);
        assertThat(getSum(4, 3)).isEqualTo(7);
        assertThat(getSum(5, 11)).isEqualTo(16);
        assertThat(getSum(234, 67)).isEqualTo(301);
    }

    @Ignore // TODO: add support of addition of negative numbers
    @Test
    public void testGetSumForNegative() {
        assertThat(getSum(-1, 1)).isEqualTo(0);
        assertThat(getSum(-5, 7)).isEqualTo(2);
        assertThat(getSum(-4, 2)).isEqualTo(-2);
        assertThat(getSum(-4, -5)).isEqualTo(-9);
    }

    @Test
    public void testIncNthBit() {
        assertThat(incNthBit(1, 0)).isEqualTo(2);
        assertThat(incNthBit(3, 1)).isEqualTo(5);
        assertThat(incNthBit(15, 2)).isEqualTo(19);
        assertThat(incNthBit(15, 4)).isEqualTo(31);
    }
}
