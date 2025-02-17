package by.andd3dfx.numeric;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * <pre>
 * Calculate the best average score from following array of marks:
 * [[Name1, 80], [Name2, 67], [Name1, 60]]
 *
 * In this example the best average has Name1 and equals to 70.
 * </pre>
 *
 * @see <a href="https://youtu.be/cdLSKHrfg4A">Video solution</a>
 */
public class BestAverageScore {

    @Getter
    @AllArgsConstructor
    public static class Item {
        private String name;
        private int mark;
    }

    public static double calculateUsingStreams(Collection<Item> items) {
        Map<String, Double> nameToAvgMarkMap = items.stream()
            .collect(Collectors.groupingBy(Item::getName, Collectors.averagingInt(Item::getMark)));

        return nameToAvgMarkMap.entrySet().stream()
            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
            .limit(1)
            .toList()
            .getFirst().getValue();
    }

    @Getter
    public static class Accumulator {
        private double value;
        private int count;

        public Accumulator(double mark) {
            this.value = mark;
            count = 1;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public void add(double mark) {
            value += mark;
            count++;
        }
    }

    public static double calculateUsualWay(Collection<Item> items) {
        Map<String, Accumulator> map = new HashMap<>();
        for (Item item : items) {
            String key = item.getName();
            if (map.containsKey(key)) {
                map.get(key).add(item.getMark());
            } else {
                map.put(key, new Accumulator(item.getMark()));
            }
        }
        double maxAvg = 0;
        for (Entry<String, Accumulator> entry : map.entrySet()) {
            Accumulator value = entry.getValue();
            var avg = value.getValue() / value.getCount();
            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }
        return maxAvg;
    }
}
