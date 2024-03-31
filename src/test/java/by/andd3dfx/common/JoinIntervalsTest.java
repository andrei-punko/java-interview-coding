package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.JoinIntervals.transform;
import static org.assertj.core.api.Assertions.assertThat;

public class JoinIntervalsTest {

    @Test
    public void testTransform() {
        assertThat(transform(new int[]{}))
                .isEqualTo("");

        assertThat(transform(new int[]{1}))
                .isEqualTo("1");

        assertThat(transform(new int[]{1, 2}))
                .isEqualTo("1-2");

        assertThat(transform(new int[]{1, 3}))
                .isEqualTo("1,3");

        assertThat(transform(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}))
                .isEqualTo("1-10");

        assertThat(transform(new int[]{2, 3, 5, 6, 7, 8, 11, 20, 21, 22}))
                .isEqualTo("2-3,5-8,11,20-22");

        assertThat(transform(new int[]{1, 3, 5, 7, 9, 11, 20, 22}))
                .isEqualTo("1,3,5,7,9,11,20,22");
    }
}
