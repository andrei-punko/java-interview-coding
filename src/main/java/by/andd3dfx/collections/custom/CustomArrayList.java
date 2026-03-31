package by.andd3dfx.collections.custom;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @see <a href="https://youtu.be/u7Vyh567ljs">Video solution part1</a>, <a href="https://youtu.be/VBdYvDW8WL8">part2</a>
 */
public class CustomArrayList<T> implements List<T> {

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Wrong index: %d", index));
        }

        array[index] = value;
        return value;
    }

    @Override
    public boolean add(T value) {
        add(size, value);
        return true;
    }

    @Override
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

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("Wrong index: %d", index));
        }

        return array[index];
    }

    @Override
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

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new CustomListIterator<>(this);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return new CustomListIterator<>(this, index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        // TODO add implementation
        throw new NotImplementedException();
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
        if (array.length < size + c.size()) {
            var newLength = array.length;
            while (newLength < size + c.size()) {
                newLength *= RESIZE_FACTOR;
            }
            var newArray = (T[]) new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        System.arraycopy(incomingArray, 0, array, size, c.size());
        size += c.size();

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (c.isEmpty()) {
            return false;
        }

        var incomingArray = c.toArray();
        if (array.length < size + c.size()) {
            var newLength = array.length;
            while (newLength < size + c.size()) {
                newLength *= RESIZE_FACTOR;
            }
            var newArray = (T[]) new Object[newLength];

            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(incomingArray, 0, newArray, index, c.size());
            System.arraycopy(array, index, newArray, index + c.size(), size - index);
            array = newArray;
        } else {
            System.arraycopy(array, index, array, index + c.size(), size - index);
            System.arraycopy(incomingArray, 0, array, index, c.size());
        }
        size += c.size();

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

    @Override
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
        return new CustomArrayIterator<>(array, size);
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
    public static class CustomArrayIterator<E> implements Iterator<E> {

        private final E[] array;
        private final int size;
        private int curr = 0;

        @Override
        public boolean hasNext() {
            return curr < size;
        }

        @Override
        public E next() {
            if (curr == size) {
                throw new NoSuchElementException();
            }
            return array[curr++];
        }
    }

    public static class CustomListIterator<E> implements ListIterator<E> {

        private final E[] array;
        private final int size;
        private int curr;

        public CustomListIterator(CustomArrayList<E> list) {
            this(list, 0);
        }

        public CustomListIterator(CustomArrayList<E> list, int index) {
            this.array = list.array;
            this.size = list.size;
            this.curr = index;
        }

        @Override
        public boolean hasNext() {
            return curr < size;
        }

        @Override
        public E next() {
            if (curr == size) {
                throw new NoSuchElementException();
            }
            return array[curr++];
        }

        @Override
        public boolean hasPrevious() {
            return curr > 0;
        }

        @Override
        public E previous() {
            if (curr == 0) {
                throw new NoSuchElementException();
            }
            return array[--curr];
        }

        @Override
        public int nextIndex() {
            return curr + 1;
        }

        @Override
        public int previousIndex() {
            return curr - 1;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E e) {
            array[curr] = e;
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}
