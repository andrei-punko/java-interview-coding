package by.andd3dfx.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

public class SummaryRangesTest {

    @Test
    public void testSummaryRanges() {
        assertThat(SummaryRanges.summaryRanges(new int[]{}))
            .isEqualTo(List.of());

        assertThat(SummaryRanges.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}))
            .isEqualTo(List.of("0->2", "4->5", "7"));

        assertThat(SummaryRanges.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}))
            .isEqualTo(List.of("0", "2->4", "6", "8->9"));

        assertThat(SummaryRanges.summaryRanges(new int[]{-2147483648, 0, 2, 3, 4, 6, 8, 9}))
            .isEqualTo(List.of("-2147483648->0", "2->4", "6", "8->9"));
    }
}
