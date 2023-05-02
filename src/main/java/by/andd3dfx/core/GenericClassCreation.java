package by.andd3dfx.core;

import lombok.SneakyThrows;

import java.util.function.Supplier;

/**
 * <pre>
 * Examples of object creation when it defined as generic type.
 *
 * According to: https://stackoverflow.com/questions/75175/create-instance-of-generic-type-in-java
 * </pre>
 */
public class GenericClassCreation {

    public static class CreatorUsingDeclaredConstructor<E> {
        @SneakyThrows
        public E createObject(Class<E> clazz) {
            return clazz.getDeclaredConstructor().newInstance();
        }
    }

    public static class CreatorUsingSupplier<E> {
        private Supplier<E> supplier;

        public CreatorUsingSupplier(Supplier<E> supplier) {
            this.supplier = supplier;
        }

        public E createObject() {
            return supplier.get();
        }
    }
}
