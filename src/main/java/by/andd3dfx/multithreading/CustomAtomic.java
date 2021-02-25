package by.andd3dfx.multithreading;

/*
Дан класс с методами
native int current(); и
native boolean compareAndSwap(int oldValue, int newValue);

Написать для него метод int getAndIncrement(), обладающий atomic функциональностью
 */
public abstract class CustomAtomic {
    public abstract int current();

    public abstract boolean compareAndSwap(int oldValue, int newValue);

    public int getAndIncrement() {
        int oldValue = current();

        while (!compareAndSwap(oldValue, oldValue + 1)) {
            oldValue = current();
        }

        return oldValue;
    }
}
