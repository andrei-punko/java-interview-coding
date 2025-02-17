package by.andd3dfx.core.creationorder;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ClassA {

    @Getter
    protected static List<String> logs = new ArrayList<>();
    private final int value = 100;

    {
        logs.add("A1 Usual block of class A, " + value);
    }

    static {
        logs.add("A2 Static block of class A");
    }

    public ClassA() {
        logs.add("A3 Class A constructor, " + value);
        showValue();
    }

    public void showValue() {
        logs.add("A4 Call of class A method, " + value);
    }
}
