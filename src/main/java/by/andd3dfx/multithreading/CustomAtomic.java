package by.andd3dfx.multithreading;

/**
 * <pre>
 * Дан класс с методами:
 * - native int current()
 * - native boolean compareAndSwap(int oldValue, int newValue)
 *
 * Написать для него метод, обладающий atomic функциональностью:
 * int getAndIncrement()
 * </pre>
 *
 * @see <a href="https://youtu.be/4SFuAGa6GfU">Video solution</a>
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
