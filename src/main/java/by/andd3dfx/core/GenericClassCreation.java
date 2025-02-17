package by.andd3dfx.core;

import lombok.SneakyThrows;

import java.util.function.Supplier;

/**
 * <pre>
 * Examples of object creation when it defined as generic type.
 *
 * According to <a href="https://stackoverflow.com/questions/75175/create-instance-of-generic-type-in-java">article</a>
 * </pre>
 *
 * @see <a href="https://youtu.be/vkn_2w-oJIo">Video solution</a>
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
