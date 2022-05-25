package by.andd3dfx.search;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountSeaShipsTest {

    @Test
    public void countSmallField() {
        int[][] seaField = {
                { 0, 1, 0, 0},
                { 1, 0, 0, 0},
                { 1, 0, 1, 1},
                { 1, 0, 0, 0},
        };
        assertThat(CountSeaShips.count(seaField)).isEqualTo(3);
    }

    @Test
    public void countEmptyField() {
        int[][] seaField = {
                { 0, 0, 0, 0},
                { 0, 0, 0, 0},
                { 0, 0, 0, 0},
                { 0, 0, 0, 0},
        };
        assertThat(CountSeaShips.count(seaField)).isEqualTo(0);
    }

    @Test
    public void countBigField() {
        int[][] seaField = {
                { 0, 0, 1, 1, 0, 0, 1, 0},
                { 1, 0, 0, 0, 0, 0, 0, 0},
                { 0, 0, 1, 0, 1, 1, 1, 0},
                { 0, 0, 1, 0, 0, 0, 0, 0},
                { 1, 0, 1, 0, 0, 1, 0, 1},
                { 1, 0, 1, 0, 0, 0, 0, 1},
                { 0, 0, 0, 0, 1, 1, 0, 0},
                { 0, 1, 0, 0, 0, 0, 0, 0},
        };
        assertThat(CountSeaShips.count(seaField)).isEqualTo(10);
    }
}
