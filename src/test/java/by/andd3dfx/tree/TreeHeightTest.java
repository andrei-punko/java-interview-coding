package by.andd3dfx.tree;

import by.andd3dfx.tree.TreeHeight.Node;
import org.junit.Test;

import static by.andd3dfx.tree.TreeHeight.calcHeight;
import static org.assertj.core.api.Assertions.assertThat;

public class TreeHeightTest {

    @Test
    public void testCalcHeight() {
        var two = new Node(2);
        var three = new Node(3, new Node(4), null);
        var root = new Node(1, two, three);

        assertThat(calcHeight(root)).isEqualTo(3);
        assertThat(calcHeight(two)).isEqualTo(1);
        assertThat(calcHeight(three)).isEqualTo(2);
    }
}
