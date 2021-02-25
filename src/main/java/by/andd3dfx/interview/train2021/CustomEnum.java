package by.andd3dfx.interview.train2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomEnum {

    private static List<CustomEnum> items = new ArrayList<>();
    private static Map<String, CustomEnum> lookup = new HashMap<>();
    private final String value;
    private final int ordinal;

    public static CustomEnum SUNDAY = add("SUNDAY");
    public static CustomEnum MONDAY = add("MONDAY");

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
