package by.andd3dfx.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class GroupingByExamplesTest {

    private static final GroupingByExamples.Worker WORKER1 = new GroupingByExamples.Worker("Иван", 30, 50000, "Разработчик");
    private static final GroupingByExamples.Worker WORKER2 = new GroupingByExamples.Worker("Петр", 25, 45000, "Разработчик");
    private static final GroupingByExamples.Worker WORKER3 = new GroupingByExamples.Worker("Мария", 28, 60000, "Менеджер");
    private static final GroupingByExamples.Worker WORKER4 = new GroupingByExamples.Worker("Анна", 32, 55000, "Менеджер");
    private static final GroupingByExamples.Worker WORKER5 = new GroupingByExamples.Worker("Сергей", 27, 40000, "Тестировщик");
    private static final GroupingByExamples.Worker WORKER6 = new GroupingByExamples.Worker("Иван", 35, 70000, "Разработчик");

    private List<GroupingByExamples.Worker> buildWorkersList() {
        return List.of(WORKER1, WORKER2, WORKER3, WORKER4, WORKER5, WORKER6);
    }

    @Test
    public void groupWorkersByPositionLists() {
        List<GroupingByExamples.Worker> workers = buildWorkersList();

        Map<String, List<GroupingByExamples.Worker>> result = GroupingByExamples.groupWorkersByPositionLists(workers);

        assertThat(result).hasSize(3);
        assertThat(result.get("Разработчик")).hasSize(3);
        assertThat(result.get("Разработчик")).containsExactlyInAnyOrder(WORKER1, WORKER2, WORKER6);
        assertThat(result.get("Менеджер")).hasSize(2);
        assertThat(result.get("Менеджер")).containsExactlyInAnyOrder(WORKER3, WORKER4);
        assertThat(result.get("Тестировщик")).hasSize(1);
        assertThat(result.get("Тестировщик")).containsExactly(WORKER5);
    }

    @Test
    public void groupWorkersByPositionListsForEmptyList() {
        List<GroupingByExamples.Worker> workers = List.of();

        Map<String, List<GroupingByExamples.Worker>> result = GroupingByExamples.groupWorkersByPositionLists(workers);

        assertThat(result).isEmpty();
    }

    @Test
    public void groupWorkersByPositionSets() {
        List<GroupingByExamples.Worker> workers = buildWorkersList();

        Map<String, Set<GroupingByExamples.Worker>> result = GroupingByExamples.groupWorkersByPositionSets(workers);

        assertThat(result).hasSize(3);
        assertThat(result.get("Разработчик")).hasSize(3);
        assertThat(result.get("Разработчик")).containsExactlyInAnyOrder(WORKER1, WORKER2, WORKER6);
        assertThat(result.get("Менеджер")).hasSize(2);
        assertThat(result.get("Менеджер")).containsExactlyInAnyOrder(WORKER3, WORKER4);
        assertThat(result.get("Тестировщик")).hasSize(1);
        assertThat(result.get("Тестировщик")).containsExactly(WORKER5);
    }

    @Test
    public void groupWorkersByPositionSetsForEmptyList() {
        List<GroupingByExamples.Worker> workers = List.of();

        Map<String, Set<GroupingByExamples.Worker>> result = GroupingByExamples.groupWorkersByPositionSets(workers);

        assertThat(result).isEmpty();
    }

    @Test
    public void calculateAmountOfWorkersForEachPosition() {
        List<GroupingByExamples.Worker> workers = buildWorkersList();

        Map<String, Long> result = GroupingByExamples.calculateAmountOfWorkersForEachPosition(workers);

        assertThat(result).hasSize(3);
        assertThat(result.get("Разработчик")).isEqualTo(3L);
        assertThat(result.get("Менеджер")).isEqualTo(2L);
        assertThat(result.get("Тестировщик")).isEqualTo(1L);
    }

    @Test
    public void calculateAmountOfWorkersForEachPositionForEmptyList() {
        List<GroupingByExamples.Worker> workers = List.of();

        Map<String, Long> result = GroupingByExamples.calculateAmountOfWorkersForEachPosition(workers);

        assertThat(result).isEmpty();
    }

    @Test
    public void groupWorkersNamesByPosition() {
        List<GroupingByExamples.Worker> workers = buildWorkersList();

        Map<String, Set<String>> result = GroupingByExamples.groupWorkersNamesByPosition(workers);

        assertThat(result).hasSize(3);
        // Set не содержит дубликатов, поэтому два "Иван" становятся одним
        assertThat(result.get("Разработчик")).hasSize(2);
        assertThat(result.get("Разработчик")).containsExactlyInAnyOrder("Иван", "Петр");
        assertThat(result.get("Менеджер")).hasSize(2);
        assertThat(result.get("Менеджер")).containsExactlyInAnyOrder("Мария", "Анна");
        assertThat(result.get("Тестировщик")).hasSize(1);
        assertThat(result.get("Тестировщик")).containsExactly("Сергей");
    }

    @Test
    public void groupWorkersNamesByPositionForEmptyList() {
        List<GroupingByExamples.Worker> workers = List.of();

        Map<String, Set<String>> result = GroupingByExamples.groupWorkersNamesByPosition(workers);

        assertThat(result).isEmpty();
    }

    @Test
    public void calculateAverageSalaryForEachPosition() {
        List<GroupingByExamples.Worker> workers = buildWorkersList();

        Map<String, Double> result = GroupingByExamples.calculateAverageSalaryForEachPosition(workers);

        assertThat(result).hasSize(3);
        // Разработчики: (50000 + 45000 + 70000) / 3 = 55000.0
        assertThat(result.get("Разработчик")).isEqualTo(55000.0);
        // Менеджеры: (60000 + 55000) / 2 = 57500.0
        assertThat(result.get("Менеджер")).isEqualTo(57500.0);
        // Тестировщик: 40000 / 1 = 40000.0
        assertThat(result.get("Тестировщик")).isEqualTo(40000.0);
    }

    @Test
    public void calculateAverageSalaryForEachPositionForEmptyList() {
        List<GroupingByExamples.Worker> workers = List.of();

        Map<String, Double> result = GroupingByExamples.calculateAverageSalaryForEachPosition(workers);

        assertThat(result).isEmpty();
    }

    @Test
    public void groupWorkersByPositionWhenWorkerRepresentedByString() {
        List<GroupingByExamples.Worker> workers = buildWorkersList();

        Map<String, String> result = GroupingByExamples.groupWorkersByPositionWhenWorkerRepresentedByString(workers);

        assertThat(result).hasSize(3);
        assertThat(result.get("Разработчик")).isEqualTo("{Иван, Петр, Иван}");
        assertThat(result.get("Менеджер")).isEqualTo("{Мария, Анна}");
        assertThat(result.get("Тестировщик")).isEqualTo("{Сергей}");
    }

    @Test
    public void groupWorkersByPositionWhenWorkerRepresentedByStringForEmptyList() {
        List<GroupingByExamples.Worker> workers = List.of();

        Map<String, String> result = GroupingByExamples.groupWorkersByPositionWhenWorkerRepresentedByString(workers);

        assertThat(result).isEmpty();
    }

    @Test
    public void groupWorkersByPositionAndAge() {
        List<GroupingByExamples.Worker> workers = buildWorkersList();

        Map<String, Map<Integer, List<GroupingByExamples.Worker>>> result = GroupingByExamples.groupWorkersByPositionAndAge(workers);

        assertThat(result).hasSize(3);

        // Проверяем группировку разработчиков по возрасту
        Map<Integer, List<GroupingByExamples.Worker>> developers = result.get("Разработчик");
        assertThat(developers).hasSize(3);
        assertThat(developers.get(30)).hasSize(1).containsExactly(WORKER1);
        assertThat(developers.get(25)).hasSize(1).containsExactly(WORKER2);
        assertThat(developers.get(35)).hasSize(1).containsExactly(WORKER6);

        // Проверяем группировку менеджеров по возрасту
        Map<Integer, List<GroupingByExamples.Worker>> managers = result.get("Менеджер");
        assertThat(managers).hasSize(2);
        assertThat(managers.get(28)).hasSize(1).containsExactly(WORKER3);
        assertThat(managers.get(32)).hasSize(1).containsExactly(WORKER4);

        // Проверяем группировку тестировщиков по возрасту
        Map<Integer, List<GroupingByExamples.Worker>> testers = result.get("Тестировщик");
        assertThat(testers).hasSize(1);
        assertThat(testers.get(27)).hasSize(1).containsExactly(WORKER5);
    }

    @Test
    public void groupWorkersByPositionAndAgeForEmptyList() {
        List<GroupingByExamples.Worker> workers = List.of();

        Map<String, Map<Integer, List<GroupingByExamples.Worker>>> result = GroupingByExamples.groupWorkersByPositionAndAge(workers);

        assertThat(result).isEmpty();
    }

    @Test
    public void groupWorkersByPositionAndAgeWithSameAge() {
        GroupingByExamples.Worker worker1 = new GroupingByExamples.Worker("Иван", 30, 50000, "Разработчик");
        GroupingByExamples.Worker worker2 = new GroupingByExamples.Worker("Петр", 30, 45000, "Разработчик");
        List<GroupingByExamples.Worker> workers = List.of(worker1, worker2);

        Map<String, Map<Integer, List<GroupingByExamples.Worker>>> result = GroupingByExamples.groupWorkersByPositionAndAge(workers);

        assertThat(result).hasSize(1);
        Map<Integer, List<GroupingByExamples.Worker>> developers = result.get("Разработчик");
        assertThat(developers).hasSize(1);
        assertThat(developers.get(30)).hasSize(2);
        assertThat(developers.get(30)).containsExactlyInAnyOrder(worker1, worker2);
    }
}
