package by.andd3dfx.numeric;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaiseToPowerTest {

    @Test
    public void applyForZero() {
        assertThat(RaiseToPower.apply(3f, 0))
            .as("3^0 = 1")
            .isEqualTo(1f);
    }

    @Test
    public void applyForPositive() {
        assertThat(RaiseToPower.apply(3f, 3))
            .as("3^3 = 9")
            .isEqualTo(27f);
        assertThat(RaiseToPower.apply(3f, 5))
            .as("3^5 = 243")
            .isEqualTo(243f);
        assertThat(RaiseToPower.apply(2f, 13))
            .as("2^13 = 8192")
            .isEqualTo(8192f);
    }

    @Test
    public void applyForNegative() {
        assertThat(RaiseToPower.apply(2f, -2))
            .as("2^-2 = 0.25")
            .isEqualTo(0.25f);
        assertThat(RaiseToPower.apply(3f, -3))
            .as("3^-3 = 0.037037037")
            .isEqualTo(0.037037037f);
    }

    @Test
    public void applyEnhancedForZero() {
        assertThat(RaiseToPower.applyEnhanced(3f, 0))
            .as("3^0 = 1")
            .isEqualTo(1f);
    }

    @Test
    public void applyEnhancedForPositive() {
        assertThat(RaiseToPower.applyEnhanced(3f, 3))
            .as("3^3 = 9")
            .isEqualTo(27f);
        assertThat(RaiseToPower.applyEnhanced(3f, 5))
            .as("3^5 = 243")
            .isEqualTo(243f);
        assertThat(RaiseToPower.applyEnhanced(2f, 13))
            .as("2^13 = 8192")
            .isEqualTo(8192f);
    }

    @Test
    public void applyEnhancedForNegative() {
        assertThat(RaiseToPower.applyEnhanced(2f, -2))
            .as("2^-2 = 0.25")
            .isEqualTo(0.25f);
        assertThat(RaiseToPower.applyEnhanced(3f, -3))
            .as("3^-3 = 0.037037037")
            .isEqualTo(0.037037037f);
    }
}
