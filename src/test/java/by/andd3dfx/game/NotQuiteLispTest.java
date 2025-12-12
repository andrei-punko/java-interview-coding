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

    @Test
    public void determinePosition() {
        assertThat(NotQuiteLisp.determinePosition(")")).isEqualTo(1);
        assertThat(NotQuiteLisp.determinePosition("()())")).isEqualTo(5);
        assertThat(NotQuiteLisp.determinePosition("((()()))))))")).isEqualTo(9);
    }
}
