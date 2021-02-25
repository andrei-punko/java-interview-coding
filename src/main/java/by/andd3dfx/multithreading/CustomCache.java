package by.andd3dfx.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/*
Реализовать без использования конкурентных коллекций класс с 2 методами:
public class CustomCache {
    // Его вызывает большое кол-во конкурентных потоков
    public Object read(int idx) {
        //...
    }

    // Его вызывает один поток
    public void write(int idx, Object object) {
        //...
    }
}
Известно, что кол-во разных объектов в кеше - небольшое, не более 1000
*/
public class CustomCache {
    private List<AtomicReference> storage = new ArrayList<AtomicReference>() {{
        for (int i = 0; i < 1000; i++) {
            add(new AtomicReference());
        }
    }};

    public Object read(int idx) {
        return storage.get(idx).get();
    }

    public void write(int idx, Object object) {
        boolean result;
        do {
            Object oldValue = storage.get(idx).get();
            result = storage.get(idx).compareAndSet(oldValue, object);
        } while (!result);
    }
}
