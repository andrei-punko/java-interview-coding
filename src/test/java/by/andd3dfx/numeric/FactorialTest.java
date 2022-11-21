package by.andd3dfx.numeric;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FactorialTest {

    @Test
    public void loop() {
        assertThat("0!=1", Factorial.loop(0), is(1));
        assertThat("1!=1", Factorial.loop(1), is(1));
        assertThat("2!=2", Factorial.loop(2), is(2));
        assertThat("3!=6", Factorial.loop(3), is(6));
        assertThat("8!=40320", Factorial.loop(8), is(40320));
    }


    @Test(expected = IllegalArgumentException.class)
    public void loopForNegativeParam() {
        Factorial.loop(-1);
    }

    @Test
    public void recursion() {
        assertThat("0!=1", Factorial.recursion(0), is(1));
        assertThat("1!=1", Factorial.recursion(1), is(1));
        assertThat("2!=2", Factorial.recursion(2), is(2));
        assertThat("3!=6", Factorial.recursion(3), is(6));
        assertThat("8!=40320", Factorial.recursion(8), is(40320));
    }

    @Test(expected = IllegalArgumentException.class)
    public void recursionForNegativeParam() {
        Factorial.recursion(-1);
    }

    @Test
    public void recursionWithCache() {
        assertThat("0!=1", Factorial.recursionWithCache(0), is(1));
        assertThat("1!=1", Factorial.recursionWithCache(1), is(1));
        assertThat("2!=2", Factorial.recursionWithCache(2), is(2));
        assertThat("3!=6", Factorial.recursionWithCache(3), is(6));
        assertThat("8!=40320", Factorial.recursionWithCache(8), is(40320));
    }

    @Test(expected = IllegalArgumentException.class)
    public void recursionWithCacheForNegativeParam() {
        Factorial.recursionWithCache(-1);
    }

    @Test
    public void loopWithCache() {
        assertThat("0!=1", Factorial.loopWithCache(0), is(1));
        assertThat("1!=1", Factorial.loopWithCache(1), is(1));
        assertThat("2!=2", Factorial.loopWithCache(2), is(2));
        assertThat("3!=6", Factorial.loopWithCache(3), is(6));
        assertThat("8!=40320", Factorial.loopWithCache(8), is(40320));
    }

    @Test(expected = IllegalArgumentException.class)
    public void loopWithCacheForNegativeParam() {
        Factorial.loopWithCache(-1);
    }
}
