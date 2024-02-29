package by.andd3dfx.string;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LargeGroupPositionsTest {

    private LargeGroupPositions largeGroupPositions;

    @Before
    public void setUp() throws Exception {
        largeGroupPositions = new LargeGroupPositions();
    }

    @Test
    public void findForNull() {
        assertThat(largeGroupPositions.find(null)).isEqualTo(List.of());
    }

    @Test
    public void findForEmpty() {
        assertThat(largeGroupPositions.find("")).isEqualTo(List.of());
    }

    @Test
    public void findWhenAllGroupsLengthShorterThanThree() {
        assertThat(largeGroupPositions.find("abc")).isEqualTo(List.of());
        assertThat(largeGroupPositions.find("aabcc")).isEqualTo(List.of());
    }

    @Test
    public void find() {
        assertThat(largeGroupPositions.find("abbxxxxzzy")).isEqualTo(
                List.of(List.of(3, 6))
        );
        assertThat(largeGroupPositions.find("abcdddeeeeaabbbcd")).isEqualTo(
                List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14))
        );
        assertThat(largeGroupPositions.find("aaabbxxxxzzyyy")).isEqualTo(
                List.of(List.of(0, 2), List.of(5, 8), List.of(11, 13))
        );
    }
}
