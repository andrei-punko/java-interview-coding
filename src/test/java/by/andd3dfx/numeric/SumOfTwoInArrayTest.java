package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SumOfTwoInArrayTest {

    @Test
    public void testFind_2N() {
        var result = SumOfTwoInArray.find_2N(new int[]{1, 3, 5, 7, 9}, 12);

        assertThat(result, anyOf(
                equalTo(new int[]{1, 4}),
                equalTo(new int[]{2, 3}),
                equalTo(new int[]{3, 2}),
                equalTo(new int[]{4, 1})));
    }

    @Test
    public void testFind_N2() {
        var result = SumOfTwoInArray.find_N2(new int[]{1, 3, 5, 7, 9}, 12);

        assertThat(result, anyOf(
                equalTo(new int[]{1, 4}),
                equalTo(new int[]{2, 3}),
                equalTo(new int[]{3, 2}),
                equalTo(new int[]{4, 1})));
    }

    @Test
    public void testFind_2NForSameNumbers() {
        var result = SumOfTwoInArray.find_2N(new int[]{1, 1, 6, 6, 1}, 12);

        assertThat(result, anyOf(
                equalTo(new int[]{2, 3}),
                equalTo(new int[]{3, 2})
        ));
    }

    @Test
    public void testFind_N2ForSameNumbers() {
        var result = SumOfTwoInArray.find_N2(new int[]{1, 1, 6, 6, 1}, 12);

        assertThat(result, anyOf(
                equalTo(new int[]{2, 3}),
                equalTo(new int[]{3, 2})
        ));
    }

    @Test
    public void testFind_2NForAbsentSolution() {
        var result = SumOfTwoInArray.find_2N(new int[]{1, 1, 6, 3, 1}, 12);

        assertThat(result, nullValue());
    }

    @Test
    public void testFind_N2ForAbsentSolution() {
        var result = SumOfTwoInArray.find_N2(new int[]{1, 1, 6, 3, 1}, 12);

        assertThat(result, nullValue());
    }
}
