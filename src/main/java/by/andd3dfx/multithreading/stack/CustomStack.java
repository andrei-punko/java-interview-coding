package by.andd3dfx.multithreading.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Implement custom stack with multithreading support without using blocking operations
 */
public class CustomStack<T> {

    private Deque<T> deque = new ArrayDeque<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public T push(T element) {
        lock.writeLock().lock();
        try {
            deque.push(element);
            return element;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T pop() {
        lock.writeLock().lock();
        try {
            return deque.pop();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public T peek() {
        lock.readLock().lock();
        try {
            return deque.peek();
        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean isEmpty() {
        lock.readLock().lock();
        try {
            return deque.isEmpty();
        } finally {
            lock.readLock().unlock();
        }
    }
}
