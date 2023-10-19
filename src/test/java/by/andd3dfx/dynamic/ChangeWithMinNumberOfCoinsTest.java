package by.andd3dfx.dynamic;

import org.junit.Test;

import static by.andd3dfx.dynamic.ChangeWithMinNumberOfCoins.determine_usingMemoization;
import static by.andd3dfx.dynamic.ChangeWithMinNumberOfCoins.determine_usingRecursion;
import static org.assertj.core.api.Assertions.assertThat;

public class ChangeWithMinNumberOfCoinsTest {

    @Test
    public void determineUsingRecursion() {
        assertThat(determine_usingRecursion(new int[]{9, 6, 5, 1}, 9)).isEqualTo(1);
        assertThat(determine_usingRecursion(new int[]{9, 6, 5, 1}, 11)).isEqualTo(2);
        assertThat(determine_usingRecursion(new int[]{9, 6, 5, 1}, 6)).isEqualTo(1);
        assertThat(determine_usingRecursion(new int[]{9, 6, 5, 1}, 25)).isEqualTo(4);

        assertThat(determine_usingRecursion(new int[]{25, 10, 5}, 30)).isEqualTo(2);
        assertThat(determine_usingRecursion(new int[]{25, 10, 5}, 55)).isEqualTo(3);
        assertThat(determine_usingRecursion(new int[]{25, 10, 5}, 4)).isEqualTo(-1);
        assertThat(determine_usingRecursion(new int[]{25, 10, 5}, 34)).isEqualTo(-1);
    }

    @Test
    public void determineUsingMemoization() {
        assertThat(determine_usingMemoization(new int[]{9, 6, 5, 1}, 9)).isEqualTo(1);
        assertThat(determine_usingMemoization(new int[]{9, 6, 5, 1}, 11)).isEqualTo(2);
        assertThat(determine_usingMemoization(new int[]{9, 6, 5, 1}, 6)).isEqualTo(1);
        assertThat(determine_usingMemoization(new int[]{9, 6, 5, 1}, 25)).isEqualTo(4);

        assertThat(determine_usingMemoization(new int[]{25, 10, 5}, 30)).isEqualTo(2);
        assertThat(determine_usingMemoization(new int[]{25, 10, 5}, 55)).isEqualTo(3);
        assertThat(determine_usingMemoization(new int[]{25, 10, 5}, 4)).isEqualTo(-1);
        assertThat(determine_usingMemoization(new int[]{25, 10, 5}, 34)).isEqualTo(-1);
    }
}
