package by.andd3dfx.interview.goldmansachs;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a function that accept one argument of object type and print all values of own properties (that are not
 * inherited from prototype) except functions. If some properties are objects, then the function should print values of
 * the object’s keys. {key1: ‘A’, key2: ‘B’, key3: {deepKey1: ‘C’, deepKey2: ‘D’}, key4: function(){}} -> ‘A B C D’.
 */
public class PropertiesExtractor {

    public static String extract(Object obj) throws IllegalAccessException {
        List<String> result = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isSynthetic() || isStaticField(field)) {
                continue;
            }

            Object value = extractValue(field, obj);
            if (value == null) {
                continue;
            }

            if (isPrimitiveOrString(value)) {
                result.add(String.valueOf(value));
            } else {
                result.add(extract(value));
            }
        }
        return result.stream().collect(Collectors.joining(" "));
    }

    private static Object extractValue(Field field, Object obj) throws IllegalAccessException {
        boolean accessibleFlag = field.isAccessible();
        field.setAccessible(true);
        Object value = field.get(obj);
        field.setAccessible(accessibleFlag);
        return value;
    }

    private static boolean isStaticField(Field field) {
        return java.lang.reflect.Modifier.isStatic(field.getModifiers());
    }

    private static boolean isPrimitiveOrString(Object obj) {
        return obj.getClass().isPrimitive() || obj.getClass().getName().equals("java.lang.String");
    }
}
