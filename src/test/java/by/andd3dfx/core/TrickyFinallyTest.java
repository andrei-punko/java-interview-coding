package by.andd3dfx.core;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrickyFinallyTest {

    private TrickyFinally trickyFinally;

    @BeforeEach
    public void setUp() {
        trickyFinally = new TrickyFinally();
    }

    @SneakyThrows
    @Test
    public void case1() {
        assertThrows(TrickyFinally.Exception3.class, () -> {
            trickyFinally.case1();
        });
    }

    @Test
    public void case2() {
        assertThat(trickyFinally.case2()).isEqualTo(3);
    }
}
