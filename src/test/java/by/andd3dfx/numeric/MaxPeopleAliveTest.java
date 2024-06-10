package by.andd3dfx.numeric;

import org.junit.Test;

import static by.andd3dfx.numeric.MaxPeopleAlive.findMaximum;
import static by.andd3dfx.numeric.MaxPeopleAlive.findMaximum2;
import static org.assertj.core.api.Assertions.assertThat;

public class MaxPeopleAliveTest {

    @Test
    public void findMaximum_whenNoIntersection() {
        final int[][] logs = {
                {1982, 1990},
                {1994, 1995},
                {2000, 2011}
        };
        assertThat(findMaximum(logs)).isEqualTo(1982);
        assertThat(findMaximum2(logs)).isEqualTo(1982);
    }

    @Test
    public void testFindMaximum() {
        final int[][] logs = {
                {1980, 1991},
                {1990, 2001},
                {2000, 2011}
        };
        assertThat(findMaximum(logs)).isEqualTo(1990);
        assertThat(findMaximum2(logs)).isEqualTo(1990);
    }

    @Test
    public void findMaximum_whenManySimultaneousIntersections() {
        final int[][] logs = {
                {1985, 2002},
                {1989, 2001},
                {1999, 2024}
        };
        assertThat(findMaximum(logs)).isEqualTo(1999);
        assertThat(findMaximum2(logs)).isEqualTo(1999);
    }
}
