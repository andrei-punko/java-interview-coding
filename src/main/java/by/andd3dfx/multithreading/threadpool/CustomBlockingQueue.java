package by.andd3dfx.multithreading.threadpool;

public interface CustomBlockingQueue<Type> {

    void enqueue(Type item) throws InterruptedException;

    Type dequeue() throws InterruptedException;
}
