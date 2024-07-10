package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.LinkOfChain.Side;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkOfChainTest {

    @Test
    public void longerSideWhenOneLink() {
        LinkOfChain chainLink = new LinkOfChain();
        assertThat(chainLink.longerSide(), is(Side.NONE));
    }

    @Test
    public void longerSide() {
        LinkOfChain left = new LinkOfChain();
        LinkOfChain one = new LinkOfChain();
        LinkOfChain two = new LinkOfChain();
        LinkOfChain three = new LinkOfChain();
        LinkOfChain right = new LinkOfChain();

        left.append(one);
        one.append(two);
        two.append(three);
        three.append(right);

        assertThat(left.longerSide(), is(Side.RIGHT));
        assertThat(one.longerSide(), is(Side.RIGHT));
        assertThat(two.longerSide(), is(Side.NONE));
        assertThat(three.longerSide(), is(Side.LEFT));
        assertThat(right.longerSide(), is(Side.LEFT));
    }

    @Test
    public void longerSideWhenClosedChain() {
        LinkOfChain left = new LinkOfChain();
        LinkOfChain one = new LinkOfChain();
        LinkOfChain two = new LinkOfChain();
        LinkOfChain three = new LinkOfChain();
        LinkOfChain right = new LinkOfChain();

        left.append(one);
        one.append(two);
        two.append(three);
        three.append(right);
        right.append(left);

        assertThat(left.longerSide(), is(Side.NONE));
        assertThat(one.longerSide(), is(Side.NONE));
        assertThat(two.longerSide(), is(Side.NONE));
        assertThat(three.longerSide(), is(Side.NONE));
        assertThat(right.longerSide(), is(Side.NONE));
    }
}
