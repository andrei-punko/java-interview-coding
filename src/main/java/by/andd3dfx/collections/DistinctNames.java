package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Есть коллекция persons объектов класса Person, у которого есть поле List&lt;String&gt; names.
 * Предложить способы вывести набор уникальных имен для данной коллекции List&lt;Person&gt;.
 */
public class DistinctNames {

    @Data
    @AllArgsConstructor
    public static class Person {
        private List<String> names;
    }

    public static List<String> way1(List<Person> persons) {
        return persons.stream()
                .map(Person::getNames)
                .flatMap(Collection::stream)
                .distinct().toList();
    }

    public static List<String> way2(List<Person> persons) {
        return persons.stream()
                .map(Person::getNames)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .stream().toList();
    }
}
