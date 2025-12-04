package by.andd3dfx.game;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class SecretEntranceTest {

    @Test
    public void determinePassword() {
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(SecretEntrance.determinePassword("/game/test-secret-entrance.txt"))
                    .isEqualTo(new SecretEntrance.Result(3, 6));
            softAssertions.assertThat(SecretEntrance.determinePassword("/game/test-secret-entrance-2.txt"))
                    .isEqualTo(new SecretEntrance.Result(2, 9));
            softAssertions.assertThat(SecretEntrance.determinePassword("/game/test-secret-entrance-3.txt"))
                    .isEqualTo(new SecretEntrance.Result(0, 4));
        });
    }
}