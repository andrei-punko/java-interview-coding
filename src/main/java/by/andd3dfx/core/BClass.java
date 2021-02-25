package by.andd3dfx.core;

/**
 * Describe what will be printed into log after BClass creation and call showValue() method on it
 */
public class BClass extends AClass {

    private int value = 1000;

    {
        writer.write("Usual block of class B, " + value);
    }

    static {
        writer.write("Static block of class B");
    }

    public BClass() {
        writer.write("Class B constructor, " + value);
        showValue();
    }

    @Override
    public void showValue() {
        writer.write("Call of class B method, " + value);
    }
}
