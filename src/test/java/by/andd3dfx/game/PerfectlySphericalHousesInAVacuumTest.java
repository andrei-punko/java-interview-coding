package by.andd3dfx.game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PerfectlySphericalHousesInAVacuumTest {

    @Test
    public void countHouses() {
        assertThat(PerfectlySphericalHousesInAVacuum.countHouses(">"))
                .isEqualTo(2);
        assertThat(PerfectlySphericalHousesInAVacuum.countHouses("^>v<"))
                .isEqualTo(4);
        assertThat(PerfectlySphericalHousesInAVacuum.countHouses("^v^v^v^v^v"))
                .isEqualTo(2);
    }

    @Test
    public void countHouses2() {
        assertThat(PerfectlySphericalHousesInAVacuum.countHouses2("^v"))
                .isEqualTo(3);
        assertThat(PerfectlySphericalHousesInAVacuum.countHouses2("^>v<"))
                .isEqualTo(3);
        assertThat(PerfectlySphericalHousesInAVacuum.countHouses2("^v^v^v^v^v"))
                .isEqualTo(11);
    }
}
