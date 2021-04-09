package by.andd3dfx.core;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrickyFinallyTest {

    private TrickyFinally trickyFinally;

    @Before
    public void setUp() {
        trickyFinally = new TrickyFinally();
    }

    @Test(expected = TrickyFinally.Exception3.class)
    public void case1() throws TrickyFinally.Exception3 {
        trickyFinally.case1();
    }

    @Test
    public void case2() {
        assertThat(trickyFinally.case2(), is(3));
    }
}
