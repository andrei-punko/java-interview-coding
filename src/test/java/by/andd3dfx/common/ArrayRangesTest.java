package by.andd3dfx.common;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayRangesTest {

    private ArrayRanges ranges;

    @Before
    public void setup() {
        ranges = new ArrayRanges();
    }

    @Test
    public void compactWhenEmptyList() {
        assertThat(ranges.compact(new int[]{}))
                .isEqualTo("");
    }

    @Test
    public void compactWhenOneNumber() {
        assertThat(ranges.compact(new int[]{1}))
                .isEqualTo("1");
    }

    @Test
    public void compactWhenNoIntervals() {
        assertThat(ranges.compact(new int[]{1, 4}))
                .isEqualTo("1,4");
    }

    @Test
    public void compactForOneInterval() {
        assertThat(ranges.compact(new int[]{1, 4, 3, 2}))
                .isEqualTo("1-4");
    }

    @Test
    public void compactForIntervals() {
        assertThat(ranges.compact(new int[]{1, 4, 5, 2, 3, 9, 8, 11, 0}))
                .isEqualTo("0-5,8-9,11");
    }

    @Test
    public void compactForIntervalsWithDuplicates() {
        assertThat(ranges.compact(new int[]{1, 4, 5, 2, 3, 9, 5, 8, 2, 11, 0}))
                .isEqualTo("0-5,8-9,11");
    }
}
