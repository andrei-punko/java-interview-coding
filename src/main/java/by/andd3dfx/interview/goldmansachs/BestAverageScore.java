package by.andd3dfx.interview.goldmansachs;

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
 * In this example the best average has Name1 === 70
 * </pre>
 */
public class BestAverageScore {

    public static class Item {

        private String name;
        private int mark;

        public Item(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }

        public String getName() {
            return name;
        }

        public int getMark() {
            return mark;
        }
    }

    public static double calculate(Collection<Item> items) {
        Map<String, Double> nameToAvgMarkMap = items.stream()
            .collect(Collectors.groupingBy(Item::getName, Collectors.averagingInt(Item::getMark)));

        return nameToAvgMarkMap.entrySet().stream()
            .sorted(Collections.reverseOrder(Entry.comparingByValue()))
            .limit(1)
            .collect(Collectors.toList())
            .get(0).getValue();
    }

    public static class Accumulator {

        private double value;
        private int count;

        public Accumulator(double mark) {
            this.value = mark;
            count = 1;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public int getCount() {
            return count;
        }

        public void add(double mark) {
            value += mark;
            count++;
        }
    }

    public static double calculate2(Collection<Item> items) {
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
            value.setValue(value.getValue() / value.getCount());
            if (value.getValue() > maxAvg) {
                maxAvg = value.getValue();
            }
        }
        return maxAvg;
    }
}
