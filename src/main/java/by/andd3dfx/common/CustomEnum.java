package by.andd3dfx.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Imagine situation when Enum isn't present in Java and write its custom implementation.
 *
 * @see <a href="https://youtu.be/41sJn7MQFc4">Video solution</a>
 */
public class CustomEnum {

    private static List<CustomEnum> items = new ArrayList<>();
    private static Map<String, CustomEnum> lookup = new HashMap<>();
    private final String value;
    private final int ordinal;

    public static final CustomEnum MONDAY = add("MONDAY");
    public static final CustomEnum TUESDAY = add("TUESDAY");
    public static final CustomEnum WEDNESDAY = add("WEDNESDAY");
    public static final CustomEnum THURSDAY = add("THURSDAY");
    public static final CustomEnum FRIDAY = add("FRIDAY");
    public static final CustomEnum SATURDAY = add("SATURDAY");
    public static final CustomEnum SUNDAY = add("SUNDAY");

    public CustomEnum(String value, int ordinal) {
        this.value = value;
        this.ordinal = ordinal;
    }

    public static CustomEnum[] values() {
        return items.toArray(new CustomEnum[0]);
    }

    public static CustomEnum valueOf(String value) {
        return lookup.get(value);
    }

    public String name() {
        return value;
    }

    public int ordinal() {
        return ordinal;
    }

    private static CustomEnum add(String value) {
        CustomEnum customEnum = new CustomEnum(value, items.size());
        items.add(customEnum);
        lookup.put(value, customEnum);
        return customEnum;
    }
}
