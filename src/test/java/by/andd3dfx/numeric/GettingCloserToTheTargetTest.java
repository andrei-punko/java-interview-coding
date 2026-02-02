package by.andd3dfx.numeric;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.numeric.GettingCloserToTheTarget.Condition;
import org.junit.Test;

public class GettingCloserToTheTargetTest {

    @Test
    public void isPossibleToReachTheTarget() {
        Condition condition = Condition.builder()
            .x0(1)
            .y0(1)
            .vx(-0.5)
            .vy(0.5)
            .vRocket(0.6)
            .t(10)
            .distance(1)
            .build();
        assertThat(GettingCloserToTheTarget.isPossibleToReachTheTarget(condition)).isFalse();

        Condition condition2 = Condition.builder()
            .x0(1)
            .y0(1)
            .vx(-0.5)
            .vy(0.5)
            .vRocket(0.65)
            .t(10)
            .distance(1)
            .build();
        assertThat(GettingCloserToTheTarget.isPossibleToReachTheTarget(condition2)).isTrue();
    }
}
