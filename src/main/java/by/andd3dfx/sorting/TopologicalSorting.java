package by.andd3dfx.sorting;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Решить задачу о нахождении цикла в графе.
 * <p>
 * See "Rod Stephens - Essential Algorithms: A Practical Approach to Computer Algorithms"
 */
public class TopologicalSorting {

    @Data
    public static class Dependency {
        private String task;
        private List<String> prerequisites;

        public Dependency(String task, List<String> prerequisites) {
            this.task = task;
            this.prerequisites = new ArrayList<>(prerequisites);
        }
    }

    public List<String> sort(List<String> tasks, List<Dependency> dependencies) {
        List<String> result = new ArrayList<>();
        tasks = new ArrayList<>(tasks);

        while (!tasks.isEmpty()) {
            var taskWithoutPrerequisites = findTaskWithoutPrerequisites(tasks, dependencies);
            if (taskWithoutPrerequisites == null) {
                return null;
            }

            result.add(taskWithoutPrerequisites);
            tasks.remove(taskWithoutPrerequisites);
            for (var dep : dependencies) {
                dep.prerequisites.remove(taskWithoutPrerequisites);
            }
        }
        return result;
    }

    /**
     * Нахождение цикла в графе
     */
    public boolean isCyclePresent(List<String> tasks, List<Dependency> dependencies) {
        return sort(tasks, dependencies) == null;
    }

    private String findTaskWithoutPrerequisites(List<String> tasks, List<Dependency> dependencies) {
        for (var task : tasks) {
            if (isTaskWithoutPrerequisites(task, dependencies)) {
                return task;
            }
        }
        return null;
    }

    private boolean isTaskWithoutPrerequisites(String task, List<Dependency> dependencies) {
        for (var dep : dependencies) {
            if (dep.task.equals(task)) {
                return dep.prerequisites == null || dep.prerequisites.isEmpty();
            }
        }
        return true;
    }
}
