package by.andd3dfx.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class IntervalListIntersectionsTest {

    @Test
    public void testIntervalIntersection() {
        assertThat(IntervalListIntersections.intervalIntersection(
            new int[][]{{1, 3}, {5, 9}},
            new int[][]{}
        )).isEqualTo(new int[][]{});

        assertThat(IntervalListIntersections.intervalIntersection(
            new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
            new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}}
        )).isEqualTo(new int[][]{{1, 2}, {5, 5}, {8, 10}, {15, 23}, {24, 24}, {25, 25}});
    }
}
