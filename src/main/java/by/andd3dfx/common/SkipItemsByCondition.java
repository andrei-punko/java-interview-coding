package by.andd3dfx.common;

import java.util.Iterator;
import java.util.Map;

/*
We have class:
public class Condition<A> {
    public bool check(A a) {
        // ...
    }
}

Implement class with method to filter items in map in case if key satisfy to check() method
 */
public class SkipItemsByCondition {

    public interface Condition<A> {
        boolean check(A a);
    }

    public <A, B> Map<A, B> filter(Map<A, B> map, Condition<A> condition) {
        Iterator<A> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            A key = iterator.next();
            if (condition.check(key)) {
                iterator.remove();
            }
        }
        return map;
    }
}
