package by.andd3dfx.common;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlatformerTest {

    @Test
    public void position() {
        Platformer platformer = new Platformer(6, 3);
        assertThat(platformer.position(), is(3));

        platformer.jumpLeft();
        assertThat(platformer.position(), is(1));

        platformer.jumpRight();
        assertThat(platformer.position(), is(4));

        platformer.jumpLeft();
        assertThat(platformer.position(), is(0));

        platformer.jumpRight();
        assertThat(platformer.position(), is(5));
        // One tile remains

        platformer.jumpLeft();
        assertThat("Could not jump more", platformer.position(), is(5));
        platformer.jumpRight();
        assertThat("Could not jump more 2", platformer.position(), is(5));
    }
}
