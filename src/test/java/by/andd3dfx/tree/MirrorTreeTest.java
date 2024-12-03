package by.andd3dfx.tree;

import by.andd3dfx.tree.MirrorTree.Node;
import org.junit.Test;

import static by.andd3dfx.tree.MirrorTree.mirror;
import static org.assertj.core.api.Assertions.assertThat;

public class MirrorTreeTest {

    /**
     * <pre>
     *        4                  4
     *   3        5    =>    5      3
     * 1  2     6   7      7  6    2  1
     *     8   9 0           0 9  8
     *   -2                        -2
     * </pre>
     */
    @Test
    public void testMirror() {
        var _m2 = new Node(-2);
        var _8 = new Node(8, _m2, null);
        var _9 = new Node(9);
        var _0 = new Node(0);
        var _1 = new Node(1);
        var _2 = new Node(2, null, _8);
        var _6 = new Node(6, _9, _0);
        var _7 = new Node(7);
        var _3 = new Node(3, _1, _2);
        var _5 = new Node(5, _6, _7);
        var _4 = new Node(4, _3, _5);

        var result = mirror(_4);

        assertThat(result).isEqualTo(_4);
        check(_4, _5, _3);
        check(_5, _7, _6);
        check(_3, _2, _1);
        check(_7, null, null);
        check(_6, _0, _9);
        check(_2, _8, null);
        check(_1, null, null);
        check(_8, null, _m2);
    }

    private void check(Node node, Node expectedLeft, Node expectedRight) {
        assertThat(node.left).isEqualTo(expectedLeft);
        assertThat(node.right).isEqualTo(expectedRight);
    }
}