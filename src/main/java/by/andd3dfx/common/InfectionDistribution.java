package by.andd3dfx.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <pre>
 * В королевстве есть несколько городов, соединенных дорогами. Города называются соседними, если между ними есть прямая
 * дорога. Первоначально чума вспыхнула лишь в паре городов, однако каждую неделю соседние города чумного города также
 * подвергались заражению и становились чумными.
 * Задача определить через сколько недель все королевство будет заражено.
 *
 * Input:
 * - cities_amount: n
 * - roads: [[n_i, n_j], ...]
 * - infected: [m_1, m_2, ...]
 *
 * Output:
 * weeks_count
 * </pre>
 */
public class InfectionDistribution {

    public static int weeksToInfectAllCities(int citiesAmount, int[][] roads, int[] infected) {
        int weeksCount = 0;
        Set<Integer> infectedCitiesSet = new HashSet<>();
        Arrays.stream(infected).forEach(number -> infectedCitiesSet.add(number));
        var roadsSet = buildRoadsSet(roads);

        while (!isAllInfected(citiesAmount, infectedCitiesSet)) {
            var infectedOnThisIteration = processOneWeek(roadsSet, infectedCitiesSet);
            if (infectedOnThisIteration == 0) {
                throw new IllegalArgumentException("Could not infect all cities!");
            }
            weeksCount++;
        }

        return weeksCount;
    }

    @Data
    @AllArgsConstructor
    private static class Road {
        private int start;
        private int end;
    }

    private static Set<Road> buildRoadsSet(int[][] roads) {
        var result = new HashSet<Road>();
        Arrays.stream(roads)
                .forEach(road -> result.add(new Road(road[0], road[1])));
        return result;
    }

    private static int processOneWeek(Set<Road> roads, Set<Integer> infectedCitiesSet) {
        var initialCitiesSet = new HashSet<>(infectedCitiesSet);
        var it = roads.iterator();
        while (it.hasNext()) {
            var road = it.next();

            if (initialCitiesSet.contains(road.start)) {
                infectedCitiesSet.add(road.end);
                it.remove();
                continue;
            }

            if (initialCitiesSet.contains(road.end)) {
                infectedCitiesSet.add(road.start);
                it.remove();
            }
        }
        return infectedCitiesSet.size() - initialCitiesSet.size();
    }

    private static boolean isAllInfected(int citiesAmount, Set<Integer> infectedCitiesSet) {
        return infectedCitiesSet.size() == citiesAmount;
    }
}
