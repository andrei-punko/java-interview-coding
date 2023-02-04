package by.andd3dfx.interview.exam;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CandiesTest {

    @Test
    public void countCandies() {
        assertThat(Candies.countCandies(3, 2), is(5));
        assertThat(Candies.countCandies(1, 2), is(1));
        assertThat(Candies.countCandies(5, 2), is(9));
    }
}
