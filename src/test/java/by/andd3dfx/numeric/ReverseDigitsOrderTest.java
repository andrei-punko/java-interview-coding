package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseDigitsOrderTest {

    @Test
    public void usingString() {
        assertThat(ReverseDigitsOrder.usingString(0)).isEqualTo(0);
        assertThat(ReverseDigitsOrder.usingString(1)).isEqualTo(1);
        assertThat(ReverseDigitsOrder.usingString(23)).isEqualTo(32);
        assertThat(ReverseDigitsOrder.usingString(-23)).isEqualTo(-32);
        assertThat(ReverseDigitsOrder.usingString(123490)).isEqualTo(94321);
    }

    @Test
    public void usingNumber() {
        assertThat(ReverseDigitsOrder.usingNumber(0)).isEqualTo(0);
        assertThat(ReverseDigitsOrder.usingNumber(1)).isEqualTo(1);
        assertThat(ReverseDigitsOrder.usingNumber(23)).isEqualTo(32);
        assertThat(ReverseDigitsOrder.usingNumber(-23)).isEqualTo(-32);
        assertThat(ReverseDigitsOrder.usingNumber(123490)).isEqualTo(94321);
    }
}
