package by.andd3dfx.dynamic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoriesTest {

    @Test
    public void combinations() {
        assertThat(Stories.combinations(1), is(1));
        assertThat(Stories.combinations(2), is(2));
        assertThat(Stories.combinations(3), is(3));
        assertThat(Stories.combinations(4), is(5));
        assertThat(Stories.combinations(5), is(8));
    }

    @Test
    public void fibonacci() {
        assertThat(Stories.fibonacci(1), is(1));
        assertThat(Stories.fibonacci(2), is(1));
        assertThat(Stories.fibonacci(3), is(2));
        assertThat(Stories.fibonacci(4), is(3));
        assertThat(Stories.fibonacci(5), is(5));
        assertThat(Stories.fibonacci(6), is(8));
    }
}
