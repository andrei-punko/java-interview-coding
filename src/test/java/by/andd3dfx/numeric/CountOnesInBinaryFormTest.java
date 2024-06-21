package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.CountOnesInBinaryForm.count_usingBitwiseAnd;
import static by.andd3dfx.numeric.CountOnesInBinaryForm.count_usingDivisionRemainder;
import static org.assertj.core.api.Assertions.assertThat;

public class CountOnesInBinaryFormTest {

    @Test
    public void testCount_usingBitwiseAnd() {
        assertThat(count_usingBitwiseAnd(1)).isEqualTo(1);
        assertThat(count_usingBitwiseAnd(2)).isEqualTo(1);
        assertThat(count_usingBitwiseAnd(3)).isEqualTo(2);
        assertThat(count_usingBitwiseAnd(255)).isEqualTo(8);
        assertThat(count_usingBitwiseAnd(984)).isEqualTo(6);
        assertThat(count_usingBitwiseAnd(8954)).isEqualTo(8);
        assertThat(count_usingBitwiseAnd(69587)).isEqualTo(10);
    }

    @Test
    public void testCount_usingDivisionRemainder() {
        assertThat(count_usingDivisionRemainder(1)).isEqualTo(1);
        assertThat(count_usingDivisionRemainder(2)).isEqualTo(1);
        assertThat(count_usingDivisionRemainder(3)).isEqualTo(2);
        assertThat(count_usingDivisionRemainder(255)).isEqualTo(8);
        assertThat(count_usingDivisionRemainder(984)).isEqualTo(6);
        assertThat(count_usingDivisionRemainder(8954)).isEqualTo(8);
        assertThat(count_usingDivisionRemainder(69587)).isEqualTo(10);
    }
}
