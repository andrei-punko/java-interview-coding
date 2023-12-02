package by.andd3dfx.core;

import lombok.SneakyThrows;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrickyFinallyTest {

    private TrickyFinally trickyFinally;

    @Before
    public void setUp() {
        trickyFinally = new TrickyFinally();
    }

    @SneakyThrows
    @Test(expected = TrickyFinally.Exception3.class)
    public void case1() {
        trickyFinally.case1();
    }

    @Test
    public void case2() {
        assertThat(trickyFinally.case2()).isEqualTo(3);
    }
}
