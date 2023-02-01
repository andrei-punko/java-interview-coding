package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AgeStatisticsTest {

    @Test
    public void findMaximum() {
        int result = AgeStatistics.findMaximum(new int[][]{
                {1980, 1991},
                {1990, 2001},
                {2000, 2011},
        });
        assertThat(result).isEqualTo(1990);
    }
}
