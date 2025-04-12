package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.Candies.countCandies;
import static org.assertj.core.api.Assertions.assertThat;


public class CandiesTest {

    @Test
    public void testCountCandies() {
        assertThat(countCandies(3, 2)).isEqualTo(5);
        assertThat(countCandies(1, 2)).isEqualTo(1);
        assertThat(countCandies(5, 2)).isEqualTo(9);
    }
}
