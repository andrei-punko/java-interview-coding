package by.andd3dfx.core.creationorder;

/**
 * Describe what will be printed into log after BClass creation and call showValue() method on it
 */
public class ClassB extends ClassA {

    private int value = 1000;

    {
        logs.add("B1 Usual block of class B, " + value);
    }

    static {
        logs.add("B2 Static block of class B");
    }

    public ClassB() {
        logs.add("B3 Class B constructor, " + value);
        showValue();
    }

    @Override
    public void showValue() {
        logs.add("B4 Call of class B method, " + value);
    }
}
