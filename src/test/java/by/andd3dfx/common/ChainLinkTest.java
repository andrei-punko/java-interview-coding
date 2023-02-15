package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.ChainLink.Side;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChainLinkTest {

    @Test
    public void longerSideWhenOneLink() {
        ChainLink chainLink = new ChainLink();
        assertThat(chainLink.longerSide(), is(Side.NONE));
    }

    @Test
    public void longerSide() {
        ChainLink left = new ChainLink();
        ChainLink one = new ChainLink();
        ChainLink two = new ChainLink();
        ChainLink three = new ChainLink();
        ChainLink right = new ChainLink();

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
        ChainLink left = new ChainLink();
        ChainLink one = new ChainLink();
        ChainLink two = new ChainLink();
        ChainLink three = new ChainLink();
        ChainLink right = new ChainLink();

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
