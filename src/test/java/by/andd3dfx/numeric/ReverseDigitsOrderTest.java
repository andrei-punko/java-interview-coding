package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReverseDigitsOrderTest {

    @Test
    public void usingString() {
        assertThat(ReverseDigitsOrder.usingString(1), is(1));
        assertThat(ReverseDigitsOrder.usingString(23), is(32));
        assertThat(ReverseDigitsOrder.usingString(123904), is(409321));
    }

    @Test
    public void usingNumber() {
        assertThat(ReverseDigitsOrder.usingNumber(1), is(1));
        assertThat(ReverseDigitsOrder.usingNumber(23), is(32));
        assertThat(ReverseDigitsOrder.usingNumber(123904), is(409321));
    }
}
