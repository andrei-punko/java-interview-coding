package by.andd3dfx.common;

import java.util.Arrays;
import java.util.HashSet;
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

    public static int weeksToInfectAllCities(int citiesAmount, int[][] roads, int[] infected) {
        var adjMatrix = new boolean[citiesAmount][citiesAmount];    // adjacency matrix
        Arrays.stream(roads).forEach(road -> {
            adjMatrix[road[0]][road[1]] = true;
            adjMatrix[road[1]][road[0]] = true;
        });

        var weeksAmount = 0;
        var infectedCities = Arrays.stream(infected).boxed().collect(Collectors.toSet());

        while (infectedCities.size() < citiesAmount) {
            var newCities = determineNewInfectedCities(infectedCities, adjMatrix);
            if (newCities.isEmpty()) {
                return -1;
            }

            infectedCities.addAll(newCities);

            weeksAmount++;
        }

        return weeksAmount;
    }

    private static Set<Integer> determineNewInfectedCities(Set<Integer> infectedCities, boolean[][] adjMatrix) {
        var n = adjMatrix.length;
        var newCities = new HashSet<Integer>();
        for (var city : infectedCities) {
            for (int i = 0; i < n; i++) {
                if (adjMatrix[city][i] && !infectedCities.contains(i)) {
                    newCities.add(i);
                }
            }
        }

        return newCities;
    }
}
