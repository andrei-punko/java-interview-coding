package by.andd3dfx.collections.custom;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @see <a href="https://youtu.be/u7Vyh567ljs">Video solution part1</a>, <a href="https://youtu.be/VBdYvDW8WL8">part2</a>
 */
public class CustomArrayList<T> implements Collection<T> {

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

    public boolean add(T value) {
        add(size, value);
        return true;
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

    public boolean remove(Object value) {
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

    @Override
    public boolean contains(Object o) {
        for (var item : array) {
            if (item == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (var item : c) {
            if (!contains(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }

        var incomingArray = c.toArray();
        if (array.length >= size + c.size()) {
            System.arraycopy(incomingArray, 0, array, size, c.size());
        } else {
            int oldLength = array.length;
            var newLength = oldLength;
            while (newLength < size + c.size()) {
                newLength *= RESIZE_FACTOR;
            }
            var newArray = (T[]) new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            System.arraycopy(incomingArray, 0, array, size, c.size());
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        var result = false;
        for (var item : c) {
            if (remove(item)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        var result = false;

        var i = 0;
        while (i < size) {
            if (!c.contains(array[i])) {
                remove(i);
                result = true;
            } else {
                i++;
            }
        }
        return result;
    }

    private boolean checkEquality(Object value1, Object value2) {
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

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(array, size, a.getClass());
        }

        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
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
