package by.andd3dfx.common;

import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
 *
 * @see <a href="https://youtu.be/Ei1uCCD_Iqg">Video solution</a>
 */
public class InfectionDistribution {

    /**
     * Initial solution
     */
    public static int weeksToInfectAllCities_usingIterationByRoads(int citiesAmount, int[][] roads, int[] infected) {
        int weeksCount = 0;
        var infectedCitiesSet = Arrays.stream(infected).boxed()
                .collect(Collectors.toSet());
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

    private static boolean isAllInfected(int citiesAmount, Set<Integer> infectedCitiesSet) {
        return infectedCitiesSet.size() == citiesAmount;
    }

    private static Set<Road> buildRoadsSet(int[][] roads) {
        return Arrays.stream(roads)
                .map(Road::new)
                .collect(Collectors.toSet());
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

    @Data
    private static class Road {
        private int start;
        private int end;

        public Road(int[] road) {
            this.start = road[0];
            this.end = road[1];
        }
    }

    /**
     * Enhanced solution
     */
    public static int weeksToInfectAllCities_usingIterationByInfectedCities(int citiesAmount, int[][] roads, int[] infected) {
        var routesMap = new HashMap<Integer, Set<Integer>>();
        Arrays.stream(roads).forEach(road -> {
            populate(routesMap, road, 0, 1);
            populate(routesMap, road, 1, 0);
        });

        var weeksAmount = 0;
        var infectedCities = Arrays.stream(infected).boxed().collect(Collectors.toSet());
        var sourceCities = new HashSet<>(infectedCities);

        while (!isAllInfected(citiesAmount, infectedCities)) {
            if (sourceCities.isEmpty()) {
                throw new IllegalArgumentException("Could not infect all cities!");
            }

            var newInfectedCities = determineNewInfectedCities(routesMap, infectedCities, sourceCities);
            infectedCities.addAll(newInfectedCities);
            sourceCities = newInfectedCities;
            weeksAmount++;
        }

        return weeksAmount;
    }

    private static HashSet<Integer> determineNewInfectedCities(
            Map<Integer, Set<Integer>> routesMap, Set<Integer> infectedCities, Set<Integer> sourceCities) {
        var newInfectedCities = new HashSet<Integer>();
        for (var city : sourceCities) {
            if (!routesMap.containsKey(city)) {
                continue;
            }

            var citiesToInfect = new HashSet<>(routesMap.get(city));
            citiesToInfect.removeAll(infectedCities);

            newInfectedCities.addAll(citiesToInfect);
        }
        return newInfectedCities;
    }

    private static void populate(Map<Integer, Set<Integer>> routesMap, int[] road, int i, int j) {
        if (!routesMap.containsKey(road[i])) {
            routesMap.put(road[i], new HashSet<>());
        }
        routesMap.get(road[i]).add(road[j]);
    }
}
