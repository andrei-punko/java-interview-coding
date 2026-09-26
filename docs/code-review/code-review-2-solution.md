# Code Review 2 — Solution (Open Code)

## Задача

```java
public class DirectoryFolder {
    private Long id;
    private String name;
    private List<DirectoryFolder> subFolders;
}
```

---

## Решение с валидацией через Hibernate Validator

### Полная реализация класса

```java
import jakarta.validation.Valid;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.*;

@Getter
@ToString
@EqualsAndHashCode
public class DirectoryFolder {

    @NotNull(message = "id must not be null")
    private final Long id;

    @NotBlank(message = "name must not be blank")
    @Size(max = 255, message = "name must not exceed 255 characters")
    private final String name;

    @Valid
    @NotNull(message = "subFolders must not be null")
    private final List<@NotNull DirectoryFolder> subFolders;

    public DirectoryFolder(Long id, String name) {
        this.id = id;
        this.name = name;
        this.subFolders = new ArrayList<>();
    }

    /**
     * Добавляет подпапку с проверкой на циклические ссылки.
     *
     * @throws IllegalArgumentException если добавление создаёт цикл
     */
    public void addSubFolder(@NotNull DirectoryFolder folder) {
        Objects.requireNonNull(folder, "folder must not be null");

        // Прямой цикл: A -> A
        if (folder == this) {
            throw new IllegalArgumentException(
                "Cannot add folder as its own subfolder (direct cycle)"
            );
        }

        // Косвенный цикл: A -> B -> ... -> A
        if (folder.containsFolder(this)) {
            throw new IllegalArgumentException(
                "Cannot add folder: it already contains the current folder (indirect cycle)"
            );
        }

        subFolders.add(folder);
    }

    /**
     * Проверяет, содержит ли данная папка (рекурсивно) папку с указанным id.
     */
    public boolean containsFolder(Long targetId) {
        if (this.id.equals(targetId)) {
            return true;
        }
        for (DirectoryFolder sub : subFolders) {
            if (sub.containsFolder(targetId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверяет, содержит ли данная папка указанную папку (по ссылке).
     */
    public boolean containsFolder(DirectoryFolder target) {
        if (this == target) {
            return true;
        }
        for (DirectoryFolder sub : subFolders) {
            if (sub.containsFolder(target)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет подпапку по id.
     */
    public boolean removeSubFolder(Long folderId) {
        return subFolders.removeIf(f -> f.getId().equals(folderId));
    }

    /**
     * Находит папку по id (рекурсивный поиск в глубину).
     */
    public Optional<DirectoryFolder> findById(Long targetId) {
        if (this.id.equals(targetId)) {
            return Optional.of(this);
        }
        for (DirectoryFolder sub : subFolders) {
            Optional<DirectoryFolder> result = sub.findById(targetId);
            if (result.isPresent()) {
                return result;
            }
        }
        return Optional.empty();
    }
}
```

---

### Валидация через Hibernate Validator

```java
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class DirectoryFolderValidator {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    /**
     * Валидирует папку и все вложенные подпапки (рекурсивно).
     *
     * @return множество нарушений (пустое, если всё валидно)
     */
    public static Set<ConstraintViolation<DirectoryFolder>> validateTree(DirectoryFolder folder) {
        Set<ConstraintViolation<DirectoryFolder>> violations = validator.validate(folder);
        for (DirectoryFolder sub : folder.getSubFolders()) {
            violations.addAll(validateTree(sub));
        }
        return violations;
    }

    /**
     * Валидирует и выбрасывает исключение при наличии нарушений.
     */
    public static void validateAndThrow(DirectoryFolder folder) {
        Set<ConstraintViolation<DirectoryFolder>> violations = validateTree(folder);
        if (!violations.isEmpty()) {
            throw new ValidationException(formatViolations(violations));
        }
    }

    private static String formatViolations(Set<ConstraintViolation<DirectoryFolder>> violations) {
        StringBuilder sb = new StringBuilder("Validation failed:\n");
        for (ConstraintViolation<DirectoryFolder> v : violations) {
            sb.append("  - ")
                .append(v.getPropertyPath())
                .append(": ")
                .append(v.getMessage())
                .append("\n");
        }
        return sb.toString();
    }
}
```

---

### Пример использования

```java
public void usageExample() {
    DirectoryFolder root = new DirectoryFolder(1L, "root");

    DirectoryFolder docs = new DirectoryFolder(2L, "docs");
    root.addSubFolder(docs);   // OK

    DirectoryFolder src = new DirectoryFolder(3L, "src");
    docs.addSubFolder(src);    // OK

    // Валидация всего дерева
    Set<ConstraintViolation<DirectoryFolder>> violations = DirectoryFolderValidator.validateTree(root);
    if (violations.isEmpty()) {
        System.out.println("Validation passed");
    }

    // Попытка создать невалидный объект
    try {
        DirectoryFolder invalid = new DirectoryFolder(null, "");
    } catch (Exception e) {
        // ValidationException: id must not be null, name must not be blank
    }

    // Попытка создать цикл: src -> root
    src.addSubFolder(root);    // IllegalArgumentException: indirect cycle
}
```

---

### Аннотации Hibernate Validator на полях

| Поле         | Аннотация          | Проверка                               |
|--------------|--------------------|----------------------------------------|
| `id`         | `@NotNull`         | `id != null`                           |
| `name`       | `@NotBlank`        | `name != null && !name.isBlank()`      |
| `name`       | `@Size(max = 255)` | `name.length() <= 255`                 |
| `subFolders` | `@Valid`           | рекурсивная валидация элементов списка |
| `subFolders` | `@NotNull`         | `subFolders != null`                   |

---

### Зависимость (Maven)

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

---

### Итоговый чек-лист

| Проблема                       | Статус                         |
|--------------------------------|--------------------------------|
| Нет геттеров/сеттеров          | Исправлено                     |
| Нет `equals/hashCode/toString` | Исправлено                     |
| Циклические ссылки             | Добавлена проверка             |
| Нет валидации                  | Hibernate Validator + `@Valid` |
| Нет методов работы с деревом   | Добавлены                      |
