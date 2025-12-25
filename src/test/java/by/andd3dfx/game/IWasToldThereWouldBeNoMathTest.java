package by.andd3dfx.game;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IWasToldThereWouldBeNoMathTest {

    @Test
    public void calculate() {
        assertThat(IWasToldThereWouldBeNoMath.calculate(List.of("2x3x4")))
            .isEqualTo(58);
        assertThat(IWasToldThereWouldBeNoMath.calculate(List.of("1x1x10")))
            .isEqualTo(43);
        assertThat(IWasToldThereWouldBeNoMath.calculate(List.of("2x3x4", "1x1x10")))
            .isEqualTo(58 + 43);
    }
}
