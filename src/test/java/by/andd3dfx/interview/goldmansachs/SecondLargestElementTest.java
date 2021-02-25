package by.andd3dfx.interview.goldmansachs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class SecondLargestElementTest {

    @Test
    public void find1() {
        assertThat(SecondLargestElement.find1(new int[]{3, 1, 2, 4}), is(3));
        assertThat(SecondLargestElement.find1(new int[]{3, 1, 2, 3}), is(3));
    }

    @Test
    public void find2() {
        assertThat(SecondLargestElement.find2(new int[]{3, 1, 2, 4}), is(3));
        assertThat(SecondLargestElement.find2(new int[]{3, 1, 1, 3}), is(3));
    }
}
