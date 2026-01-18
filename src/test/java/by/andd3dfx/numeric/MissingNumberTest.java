package by.andd3dfx.numeric;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MissingNumberTest {

    private final MissingNumber missingNumber = new MissingNumber();

    @Test
    public void testMissingNumber() {
        assertThat(missingNumber.missingNumber(new int[]{3, 0, 1})).isEqualTo(2);
        assertThat(missingNumber.missingNumber(new int[]{0, 1})).isEqualTo(2);
        assertThat(missingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
    }

    @Test
    public void testMissingNumber2() {
        assertThat(missingNumber.missingNumber2(new int[]{3, 0, 1})).isEqualTo(2);
        assertThat(missingNumber.missingNumber2(new int[]{0, 1})).isEqualTo(2);
        assertThat(missingNumber.missingNumber2(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
    }
}
