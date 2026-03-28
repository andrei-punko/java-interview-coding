package by.andd3dfx.common;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MergeIntervalsTest {

    private MergeIntervals mergeIntervals;

    @Before
    public void setUp() throws Exception {
        mergeIntervals = new MergeIntervals();
    }

    @Test
    public void merge() {
        assertThat(mergeIntervals.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
            .isEqualTo(new int[][]{{1, 6}, {8, 10}, {15, 18}});

        assertThat(mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}}))
            .isEqualTo(new int[][]{{1, 5}});

        assertThat(mergeIntervals.merge(new int[][]{{4, 7}, {1, 4}}))
            .isEqualTo(new int[][]{{1, 7}});
    }
}
