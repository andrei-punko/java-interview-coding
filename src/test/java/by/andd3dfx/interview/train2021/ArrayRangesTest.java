package by.andd3dfx.interview.train2021;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ArrayRangesTest {

    private ArrayRanges ranges;

    @Before
    public void setup() {
        ranges = new ArrayRanges();
    }

    @Test
    public void compact() {
        assertThat("Wrong ranges for one number", ranges.compact(new int[]{1}), is("1"));
        assertThat("Wrong ranges when no intervals", ranges.compact(new int[]{1, 4}), is("1,4"));
        assertThat("Wrong ranges for one interval", ranges.compact(new int[]{1, 4, 3, 2}), is("1-4"));
        assertThat("Wrong ranges for intervals", ranges.compact(new int[]{1, 4, 5, 2, 3, 9, 8, 11, 0}), is("0-5,8-9,11"));
    }
}
