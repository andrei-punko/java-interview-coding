package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Предположить, что класса Enum в жава нету, реализовать свой класс WeekDaysEnum,
 * реализующий поведение enum с днями недели и всеми нужными методами: values(), valueOf(), ordinal(), name()
 * <p>
 * Постараться сделать класс расширяемым, чтобы можно легко можно было добавить новые значения
 */
public final class WeekDaysEnum {
    private static final List<WeekDaysEnum> items = new ArrayList<>();
    private static final Map<String, WeekDaysEnum> entityByValueMap = new HashMap<>();

    public static WeekDaysEnum SUNDAY = add("SUNDAY");
    public static WeekDaysEnum MONDAY = add("MONDAY");

    private final String value;
    private final int ordinal;

    public WeekDaysEnum(String value, int ordinal) {
        this.value = value;
        this.ordinal = ordinal;
    }

    public static WeekDaysEnum[] values() {
        return items.toArray(new WeekDaysEnum[0]);
    }

    public static WeekDaysEnum valueOf(String value) {
        return entityByValueMap.get(value);
    }

    public int ordinal() {
        return ordinal;
    }

    public String name() {
        return value;
    }

    private static WeekDaysEnum add(String value) {
        WeekDaysEnum item = new WeekDaysEnum(value, items.size());
        items.add(item);
        entityByValueMap.put(value, item);
        return item;
    }
}
