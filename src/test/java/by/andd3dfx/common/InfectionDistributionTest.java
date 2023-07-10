package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.InfectionDistribution.weeksToInfectAllCities_usingIterationByInfectedCities;
import static by.andd3dfx.common.InfectionDistribution.weeksToInfectAllCities_usingIterationByRoads;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class InfectionDistributionTest {

    @Test
    public void weeksToInfectAllCitiesPositive_usingIterationByRoads() {
        assertThat(weeksToInfectAllCities_usingIterationByRoads(
                1,
                new int[][]{},
                new int[]{0}
        )).isEqualTo(0);

        assertThat(weeksToInfectAllCities_usingIterationByRoads(
                2,
                new int[][]{new int[]{0, 1}},
                new int[]{0}
        )).isEqualTo(1);

        assertThat(weeksToInfectAllCities_usingIterationByRoads(
                5,
                new int[][]{
                        new int[]{0, 2},
                        new int[]{1, 2},
                        new int[]{3, 4},
                },
                new int[]{0, 3}
        )).isEqualTo(2);

        assertThat(weeksToInfectAllCities_usingIterationByRoads(
                7,
                new int[][]{
                        new int[]{0, 2},
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{6, 4},
                        new int[]{6, 5},
                        new int[]{1, 5},
                },
                new int[]{0}
        )).isEqualTo(6);
    }

    @Test
    public void weeksToInfectAllCitiesNegative_usingIterationByRoads() {
        assertThrows("Could not infect all cities!", IllegalArgumentException.class,
                () -> weeksToInfectAllCities_usingIterationByRoads(
                        1,
                        new int[][]{},
                        new int[]{}
                ));

        assertThrows("Could not infect all cities!", IllegalArgumentException.class,
                () -> weeksToInfectAllCities_usingIterationByRoads(
                        5,
                        new int[][]{
                                new int[]{0, 2},
                                new int[]{1, 4},
                        },
                        new int[]{0, 3}
                ));
    }

    @Test
    public void weeksToInfectAllCitiesPositive_usingIterationByCities() {
        assertThat(weeksToInfectAllCities_usingIterationByInfectedCities(
                1,
                new int[][]{},
                new int[]{0}
        )).isEqualTo(0);

        assertThat(weeksToInfectAllCities_usingIterationByInfectedCities(
                2,
                new int[][]{new int[]{0, 1}},
                new int[]{0}
        )).isEqualTo(1);

        assertThat(weeksToInfectAllCities_usingIterationByInfectedCities(
                5,
                new int[][]{
                        new int[]{0, 2},
                        new int[]{1, 2},
                        new int[]{3, 4},
                },
                new int[]{0, 3}
        )).isEqualTo(2);

        assertThat(weeksToInfectAllCities_usingIterationByInfectedCities(
                7,
                new int[][]{
                        new int[]{0, 2},
                        new int[]{1, 2},
                        new int[]{3, 4},
                        new int[]{6, 4},
                        new int[]{6, 5},
                        new int[]{1, 5},
                },
                new int[]{0}
        )).isEqualTo(6);
    }

    @Test
    public void weeksToInfectAllCitiesNegative_usingIterationByCities() {
        assertThrows("Could not infect all cities!", IllegalArgumentException.class,
                () -> weeksToInfectAllCities_usingIterationByInfectedCities(
                        1,
                        new int[][]{},
                        new int[]{}
                ));

        assertThrows("Could not infect all cities!", IllegalArgumentException.class,
                () -> weeksToInfectAllCities_usingIterationByInfectedCities(
                        5,
                        new int[][]{
                                new int[]{0, 2},
                                new int[]{1, 4},
                        },
                        new int[]{0, 3}
                ));
    }
}
