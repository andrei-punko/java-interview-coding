package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrobeniusCoinProblemTest {

    @Test
    public void testFind() {
        // Formula g = a1*a2-a1-a2 works only for relatively prime numbers a1, a2
        assertThat(FrobeniusCoinProblem.find(new int[]{2, 5})).isEqualTo(2 * 5 - 2 - 5);
        assertThat(FrobeniusCoinProblem.find(new int[]{3, 7})).isEqualTo(3 * 7 - 3 - 7);
        assertThat(FrobeniusCoinProblem.find(new int[]{6, 7})).isEqualTo(6 * 7 - 6 - 7);

        // McNuggets problem
        assertThat(FrobeniusCoinProblem.find(new int[]{6, 9, 20})).isEqualTo(43);
    }
}
