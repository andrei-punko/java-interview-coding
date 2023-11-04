package by.andd3dfx.numeric;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class MinMultiplicationTest {

    private MinMultiplication minMultiplication;

    @Before
    public void setUp() {
        minMultiplication = new MinMultiplication();
    }

    @Test
    public void determineWhenAllPositive() {
        assertThat(minMultiplication.determine(new int[]{9, 4, 2, 5, 3})).isEqualTo(6);
    }

    @Test
    public void determineWhenAllNegative() {
        assertThat(minMultiplication.determine(new int[]{-9, -4, -2, -5, -1, -3})).isEqualTo(2);
    }

    @Test
    public void determineWhenBothPositiveAndNegative() {
        assertThat(minMultiplication.determine(new int[]{9, 4, -2, 5, -1, 3})).isEqualTo(-18);
    }

    @Test
    public void determineWhenLessThan2ElementsInArray() {
        var ex1 = assertThrows(IllegalArgumentException.class, () -> minMultiplication.determine(new int[]{5}));
        assertThat(ex1.getMessage()).isEqualTo("Should be at least 2 elements in array!");

        var ex0 = assertThrows(IllegalArgumentException.class, () -> minMultiplication.determine(new int[]{}));
        assertThat(ex0.getMessage()).isEqualTo("Should be at least 2 elements in array!");
    }
}