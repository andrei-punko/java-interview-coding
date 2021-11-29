package by.andd3dfx.masking;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Helper for masking secure string fields.
 * <p>
 * Annotate required class with {@link Masked}
 * and its fields with {@link MaskedProperty}.
 * Use {@link MaskedProperty#pattern()} and {@link MaskedProperty#replacement()} when needed.
 */
public class MaskingHelper {

    private MaskingHelper() {
    }

    @SneakyThrows
    public static <T> T mask(T object) {
        if (extractMaskedAnnotation(object).isEmpty()) {
            return object;
        }

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object fieldValue = field.get(object);
            if (fieldValue != null) {
                Optional<Annotation> annotationOptional = extractMaskedPropertyAnnotation(field);
                field.set(object, determineNewValue(fieldValue, annotationOptional));
            }
        }
        return object;
    }

    private static Object determineNewValue(Object fieldValue, Optional<Annotation> annotationOptional) {
        if (fieldValue instanceof String) {
            return maskString((String) fieldValue, annotationOptional);
        }

        if (fieldValue instanceof List) {
            return maskList((List) fieldValue, annotationOptional);
        }

        if (fieldValue instanceof Set) {
            return maskSet((Set) fieldValue, annotationOptional);
        }

        if (fieldValue instanceof Map) {
            return maskMap((Map) fieldValue, annotationOptional);
        }

        return mask(fieldValue);
    }

    private static Object maskString(String fieldValue, Optional<Annotation> annotationOptional) {
        if (annotationOptional.isEmpty()) {
            return fieldValue;
        }

        MaskedProperty maskedPropertyAnnotation = (MaskedProperty) annotationOptional.get();
        if (maskedPropertyAnnotation.pattern().isBlank()) {
            return maskedPropertyAnnotation.replacement();
        }
        return fieldValue.replaceAll(maskedPropertyAnnotation.pattern(), maskedPropertyAnnotation.replacement());
    }

    private static Object maskList(List list, Optional<Annotation> annotationOptional) {
        return list.stream().map(item -> mask(item, annotationOptional)).collect(Collectors.toList());
    }

    private static Object maskSet(Set set, Optional<Annotation> annotationOptional) {
        return set.stream().map(item -> mask(item, annotationOptional)).collect(Collectors.toSet());
    }

    private static Object maskMap(Map map, Optional<Annotation> annotationOptional) {
        return map.entrySet().stream().collect(Collectors.toMap(
                entry -> ((Map.Entry) entry).getKey(),
                entry -> mask(((Map.Entry) entry).getValue(), annotationOptional)
        ));
    }

    private static Object mask(Object fieldValue, Optional<Annotation> annotationOptional) {
        if (fieldValue instanceof String) {
            return maskString((String) fieldValue, annotationOptional);
        }

        return mask(fieldValue);
    }

    private static <T> Optional<Annotation> extractMaskedAnnotation(T object) {
        return Arrays.stream(object.getClass().getDeclaredAnnotations())
                .filter(annotation -> annotation.annotationType() == Masked.class)
                .findFirst();
    }

    private static Optional<Annotation> extractMaskedPropertyAnnotation(Field field) {
        return Arrays.stream(field.getDeclaredAnnotations())
                .filter(annotation -> annotation.annotationType() == MaskedProperty.class)
                .findFirst();
    }
}
