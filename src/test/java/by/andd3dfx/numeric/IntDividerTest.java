package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class IntDividerTest {

    @Test
    public void divide() {
        assertThat(IntDivider.divide(5, 2), is(2));
        assertThat(IntDivider.divide(36, 4), is(9));
        assertThat(IntDivider.divide(45, 7), is(6));
    }
}
