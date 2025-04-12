package by.andd3dfx.dynamic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoriesTest {

    @Test
    public void combinations() {
        assertThat(Stories.combinations(1)).isEqualTo(1);
        assertThat(Stories.combinations(2)).isEqualTo(2);
        assertThat(Stories.combinations(3)).isEqualTo(3);
        assertThat(Stories.combinations(4)).isEqualTo(5);
        assertThat(Stories.combinations(5)).isEqualTo(8);
    }

    @Test
    public void fibonacci() {
        assertThat(Stories.fibonacci(1)).isEqualTo(1);
        assertThat(Stories.fibonacci(2)).isEqualTo(1);
        assertThat(Stories.fibonacci(3)).isEqualTo(2);
        assertThat(Stories.fibonacci(4)).isEqualTo(3);
        assertThat(Stories.fibonacci(5)).isEqualTo(5);
        assertThat(Stories.fibonacci(6)).isEqualTo(8);
    }
}
