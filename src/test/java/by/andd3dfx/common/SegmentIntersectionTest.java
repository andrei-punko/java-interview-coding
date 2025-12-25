package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SegmentIntersectionTest {

    @Test
    public void find() {
        assertThat(SegmentIntersection.find(new int[][]{
            {20, 30}, {19, 21}, {20, 26}, {29, 35}
        })).isEqualTo(new int[][]{
            {19, 21}, {29, 35}
        });
    }

    @Test
    public void findWhenNothingFound() {
        assertThat(SegmentIntersection.find(new int[][]{
            {20, 30}, {19, 21}, {20, 26}
        })).isEqualTo(new int[][]{
        });
    }
}
