package by.andd3dfx.core;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

/**
 * Examples of object creation when it defined as generic type.
 *
 * According to: https://stackoverflow.com/questions/75175/create-instance-of-generic-type-in-java
 */
public class GenericClassCreation {

    public static class SomeContainer1<E> {

        public E createObject(Class<E> clazz)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            return clazz.getDeclaredConstructor().newInstance();
        }
    }

    public static class SomeContainer2<E> {

        private Supplier<E> supplier;

        public SomeContainer2(Supplier<E> supplier) {
            this.supplier = supplier;
        }

        public E createObject() {
            return supplier.get();
        }
    }
}
