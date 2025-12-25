package by.andd3dfx.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Examples of groupingBy Stream API usage
 * <p>
 * Based on <a href="https://habr.com/ru/articles/348536/">article</a>
 */
public class GroupingByExamples {

    @Data
    @AllArgsConstructor
    public static class Worker {
        private String name;
        private int age;
        private int salary;
        private String position;
    }

    /**
     * 1. Группировка списка рабочих по их должности (деление на списки)
     */
    public static Map<String, List<Worker>> groupWorkersByPositionLists(List<Worker> workers) {
        return workers.stream()
            .collect(Collectors.groupingBy(Worker::getPosition));
    }

    /**
     * 2. Группировка списка рабочих по их должности (деление на множества)
     */
    public static Map<String, Set<Worker>> groupWorkersByPositionSets(List<Worker> workers) {
        return workers.stream().collect(
            Collectors.groupingBy(Worker::getPosition, Collectors.toSet())
        );
    }

    /**
     * 3. Подсчет количества рабочих, занимаемых конкретную должность
     */
    public static Map<String, Long> calculateAmountOfWorkersForEachPosition(List<Worker> workers) {
        return workers.stream().collect(
            Collectors.groupingBy(Worker::getPosition, Collectors.counting())
        );
    }

    /**
     * 4. Группировка списка рабочих по их должности, при этом нас интересуют только имена
     */
    public static Map<String, Set<String>> groupWorkersNamesByPosition(List<Worker> workers) {
        return workers.stream().collect(
            Collectors.groupingBy(Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.toSet()))
        );
    }

    /**
     * 5. Расчет средней зарплаты для данной должности
     */
    public static Map<String, Double> calculateAverageSalaryForEachPosition(List<Worker> workers) {
        return workers.stream().collect(
            Collectors.groupingBy(Worker::getPosition, Collectors.averagingInt(Worker::getSalary))
        );
    }

    /**
     * 6. Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой
     */
    public static Map<String, String> groupWorkersByPositionWhenWorkerRepresentedByString(List<Worker> workers) {
        return workers.stream().collect(
            Collectors.groupingBy(
                Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.joining(", ", "{", "}"))
            ));
    }

    /**
     * 7. Группировка списка рабочих по их должности и по возрасту.
     */
    public static Map<String, Map<Integer, List<Worker>>> groupWorkersByPositionAndAge(List<Worker> workers) {
        return workers.stream().collect(
            Collectors.groupingBy(Worker::getPosition, Collectors.groupingBy(Worker::getAge))
        );
    }
}
