package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Предположить, что класса Enum в Java нет, реализовать свой класс WeekDaysEnum,
 * реализующий поведение enum с днями недели и всеми нужными методами: values(), valueOf(), ordinal(), name()
 * <p>
 * Постараться сделать класс расширяемым, чтобы можно легко можно было добавить новые значения.
 */
public final class WeekDaysEnum {

    private static final List<WeekDaysEnum> items = new ArrayList<>();
    private static final Map<String, WeekDaysEnum> map = new HashMap<>();
    private final String value;
    private final int ordinal;

    public static final WeekDaysEnum MONDAY = add("MONDAY");
    public static final WeekDaysEnum TUESDAY = add("TUESDAY");
    public static final WeekDaysEnum WEDNESDAY = add("WEDNESDAY");
    public static final WeekDaysEnum THURSDAY = add("THURSDAY");
    public static final WeekDaysEnum FRIDAY = add("FRIDAY");
    public static final WeekDaysEnum SATURDAY = add("SATURDAY");
    public static final WeekDaysEnum SUNDAY = add("SUNDAY");

    private WeekDaysEnum(String value, int ordinal) {
        this.value = value;
        this.ordinal = ordinal;
    }

    public static WeekDaysEnum[] values() {
        return items.toArray(new WeekDaysEnum[0]);
    }

    public static WeekDaysEnum valueOf(String value) {
        return map.get(value);
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
        map.put(value, item);
        return item;
    }
}
