package by.andd3dfx.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <pre>
 * Необходимо создать стрим, который отфильтрует пользователей,
 * у которых дата последнего логина была не позже, чем 3 дня назад,
 * отобрать только уникальные имена, сгруппировать по количеству букв в имени
 * и вывести список имен с наибольшим количеством букв
 *
 * static class User {
 *     private String name;
 *     private LocalDate lastLogin;
 * }
 * </pre>
 */
public class FilterUsers {

    public static List<String> apply(List<User> users) {
        return users.stream()
            .filter(user -> !user.lastLogin
                .plusDays(3)
                .isBefore(LocalDate.now()))
            .map(User::getName)
            .distinct()
            .collect(Collectors.groupingBy(String::length)).entrySet().stream()
            .max(Comparator.comparingInt(Map.Entry::getKey))
            .map(Map.Entry::getValue)
            .orElseGet(List::of);
    }

    @Getter
    @AllArgsConstructor
    public static class User {
        private String name;
        private LocalDate lastLogin;
    }
}
