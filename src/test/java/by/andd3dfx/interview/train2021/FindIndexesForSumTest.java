package by.andd3dfx.interview.train2021;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class FindIndexesForSumTest {

    private FindIndexesForSum util;

    @Before
    public void setup() {
        util = new FindIndexesForSum();
    }

    @Test
    public void find() {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        int[] c = {-1, 0, 1};

        int[] result = util.find(a, b, c, 22);

        assertThat("Wrong size", result.length, is(3));
        assertThat("Wrong i", result[0], is(0));
        assertThat("Wrong j", result[1], is(1));
        assertThat("Wrong k", result[2], is(2));
    }

    @Test
    public void findWhenNotFound() {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        int[] c = {-1, 0, 1};

        try {
            util.find(a, b, c, 45);
            fail("Exception should be thrown!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage(), is("Indexes set does not exist!"));
        }
    }
}
