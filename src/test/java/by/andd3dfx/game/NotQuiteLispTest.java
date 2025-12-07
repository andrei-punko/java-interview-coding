package by.andd3dfx.game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotQuiteLispTest {

    @Test
    public void determineFloor() {
        assertThat(NotQuiteLisp.determineFloor("(())")).isEqualTo(0);
        assertThat(NotQuiteLisp.determineFloor("()()")).isEqualTo(0);
        assertThat(NotQuiteLisp.determineFloor("(((")).isEqualTo(3);
        assertThat(NotQuiteLisp.determineFloor("(()(()(")).isEqualTo(3);
        assertThat(NotQuiteLisp.determineFloor("())")).isEqualTo(-1);
        assertThat(NotQuiteLisp.determineFloor("))(")).isEqualTo(-1);
        assertThat(NotQuiteLisp.determineFloor(")))")).isEqualTo(-3);
        assertThat(NotQuiteLisp.determineFloor(")())())")).isEqualTo(-3);
    }
}
