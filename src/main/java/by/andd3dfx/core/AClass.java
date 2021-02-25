package by.andd3dfx.core;

import java.io.StringWriter;

public class AClass {

    protected static final StringWriter writer = new StringWriter();
    private int value = 100;

    {
        writer.write("Usual block of class A, " + value);
    }

    static {
        writer.write("Static block of class A");
    }

    public AClass() {
        writer.write("Class A constructor, " + value);
        showValue();
    }

    public void showValue() {
        writer.write("Call of class A method, " + value);
    }

    public static StringWriter getWriter() {
        return writer;
    }
}
