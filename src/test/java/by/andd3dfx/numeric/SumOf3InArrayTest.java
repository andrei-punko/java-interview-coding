package by.andd3dfx.numeric;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SumOf3InArrayTest {

    private SumOf3InArray util;

    @Before
    public void setup() {
        util = new SumOf3InArray();
    }

    @Test
    public void find() {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        int[] c = {-1, 0, 1};

        var result = util.find(a, b, c, 22);

        assertThat(result.exists, is(true));
        assertThat("Wrong size", result.indexes.length, is(3));
        assertThat("Wrong i", result.indexes[0], is(0));
        assertThat("Wrong j", result.indexes[1], is(1));
        assertThat("Wrong k", result.indexes[2], is(2));
    }

    @Test
    public void findWhenNoSolution() {
        int[] a = {1, 2, 3};
        int[] b = {10, 20, 30};
        int[] c = {-1, 0, 1};

        var result = util.find(a, b, c, 45);

        assertThat(result.exists, is(false));
        assertThat(result.indexes, nullValue());
    }
}
