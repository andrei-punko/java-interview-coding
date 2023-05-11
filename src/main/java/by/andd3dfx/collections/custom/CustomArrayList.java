package by.andd3dfx.collections.custom;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Iterator;

public class CustomArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_INITIAL_SIZE = 10;
    private static final float RESIZE_FACTOR = 1.75f;
    private static final float INVERSE_RESIZE_FACTOR = 1 / RESIZE_FACTOR;

    private T[] array;
    private int size = 0;

    public CustomArrayList() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public CustomArrayList(int length) {
        array = (T[]) new Object[length];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Wrong index: %d", index));
        }

        array[index] = value;
    }

    public void add(T value) {
        add(size, value);
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == array.length) {
            int oldLength = array.length;
            int newLength = Math.round(RESIZE_FACTOR * oldLength);
            var newArray = (T[]) new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;

            System.out.println("Inner array size increased: %s->%s".formatted(oldLength, newLength));
        }

        if (index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = value;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Wrong index: %d", index));
        }

        return array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Wrong index: %d", index));
        }

        var result = array[index];
        System.arraycopy(array, index + 1, array, index, size - index);
        size--;

        if (size < array.length / 2 && array.length > DEFAULT_INITIAL_SIZE) {
            int oldLength = array.length;
            int newLength = Math.round(INVERSE_RESIZE_FACTOR * oldLength);
            var newArray = (T[]) new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;

            System.out.println("Inner array size decreased: %s->%s".formatted(oldLength, newLength));
        }

        return result;
    }

    public boolean remove(T value) {
        var i = 0;
        while (i < size) {
            T currValue = array[i];
            if (checkEquality(value, currValue)) {
                remove(i);
                return true;
            }
            i++;
        }
        return false;
    }

    private boolean checkEquality(T value1, T value2) {
        if (value1 == null) {
            return value2 == null;
        }
        return value1.equals(value2);
    }

    public void clear() {
        array = (T[]) new Object[DEFAULT_INITIAL_SIZE];
        size = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator(array, size);
    }

    @RequiredArgsConstructor
    public class CustomIterator<E> implements Iterator<E> {
        private final E[] array;
        private final int size;

        private int curr = 0;

        @Override
        public boolean hasNext() {
            return curr < size;
        }

        @Override
        public E next() {
            return array[curr++];
        }
    }
}
