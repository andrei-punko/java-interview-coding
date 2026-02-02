package by.andd3dfx.numeric;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.numeric.GettingCloserToTheTarget.Condition;
import org.junit.Test;

public class GettingCloserToTheTargetTest {

    @Test
    public void isPossibleToReachTheTarget() {
        Condition condition = Condition.builder()
            .x0(1)  // 1 - 0.5*10 = 1-5 = -4
            .y0(1)  // 1 + 0.5*10 = 1+5 = 6, hypotenuse: 4^2 + 6^2 = 52 = (7.xx)^2
            .vx(-0.5)
            .vy(0.5)
            .vRocket(0.6)   // need to compare: 6 and 7.2
            .t(10)
            .distance(1)
            .build();
        assertThat(GettingCloserToTheTarget.isPossibleToReachTheTarget(condition)).isFalse();

        Condition condition2 = Condition.builder()
            .x0(1)  // 1 - 0.5*10 = 1-5 = -4
            .y0(1)  // 1 + 0.5*10 = 1+5 = 6, hypotenuse: 4^2 + 6^2 = 52 = (7.xx)^2
            .vx(-0.5)
            .vy(0.5)
            .vRocket(0.65)   // need to compare: 6.5 and 7.2
            .t(10)
            .distance(1)
            .build();
        assertThat(GettingCloserToTheTarget.isPossibleToReachTheTarget(condition2)).isTrue();
    }
}
