package by.andd3dfx.search;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class FindSumOfTwoInArrayTest {

    @Test
    public void find() {
        assertThat(FindSumOfTwoInArray.find(new int[]{1, 4, 7, 2, 90}, 3), is(new int[]{0, 3}));
        assertThat(FindSumOfTwoInArray.find(new int[]{1, 4, 7, 2, 90}, 19), nullValue());
    }
}
