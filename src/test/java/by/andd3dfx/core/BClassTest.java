package by.andd3dfx.core;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BClassTest {

    @Test
    public void checkCallOrder() {
        BClass bClass = new BClass();
        bClass.showValue();

        String outContent = BClass.getWriter().toString();
        assertThat("Wrong console output", outContent, is(""
            + "Static block of class A"
            + "Static block of class B"
            + "Usual block of class A, 100"
            + "Class A constructor, 100"
            + "Call of class B method, 0"
            + "Usual block of class B, 1000"
            + "Class B constructor, 1000"
            + "Call of class B method, 1000"
            + "Call of class B method, 1000"));
    }
}
