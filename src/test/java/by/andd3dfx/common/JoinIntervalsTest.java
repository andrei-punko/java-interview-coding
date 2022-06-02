package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JoinIntervalsTest {

    @Test
    public void transform() {
        assertThat(JoinIntervals.transform(new int[]{}))
                .isEqualTo("");

        assertThat(JoinIntervals.transform(new int[]{1}))
                .isEqualTo("1");

        assertThat(JoinIntervals.transform(new int[]{1, 2}))
                .isEqualTo("1-2");

        assertThat(JoinIntervals.transform(new int[]{1, 3}))
                .isEqualTo("1,3");

        assertThat(JoinIntervals.transform(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))
                .isEqualTo("1-10");

        assertThat(JoinIntervals.transform(new int[]{2, 3, 5, 6, 7, 8, 11, 20, 21, 22}))
                .isEqualTo("2-3,5-8,11,20-22");

        assertThat(JoinIntervals.transform(new int[]{1, 3, 5, 7, 9, 11, 20, 22}))
                .isEqualTo("1,3,5,7,9,11,20,22");
    }

    @Test
    public void transform2() {
        /*
         * Not covered this case on interview
        assertThat(NumberIntervals.transform2(new int[]{}))
                .isEqualTo("");
         */

        assertThat(JoinIntervals.transform2(new int[]{1}))
                .isEqualTo("1");

        assertThat(JoinIntervals.transform2(new int[]{1, 2}))
                .isEqualTo("1-2");

        assertThat(JoinIntervals.transform2(new int[]{1, 3}))
                .isEqualTo("1,3");

        assertThat(JoinIntervals.transform2(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))
                .isEqualTo("1-10");

        assertThat(JoinIntervals.transform2(new int[]{2, 3, 5, 6, 7, 8, 11, 20, 21, 22}))
                .isEqualTo("2-3,5-8,11,20-22");

        assertThat(JoinIntervals.transform2(new int[]{1, 3, 5, 7, 9, 11, 20, 22}))
                .isEqualTo("1,3,5,7,9,11,20,22");
    }
}
