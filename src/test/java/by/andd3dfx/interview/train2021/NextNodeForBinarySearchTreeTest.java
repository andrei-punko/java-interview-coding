package by.andd3dfx.interview.train2021;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NextNodeForBinarySearchTreeTest {

    /**
     * <pre>
     *              20
     *           5
     *       3         7
     *   2      4     6 11
     * 1     3.5 4.5
     * </pre>
     */
    @Test
    public void next() {
        NodeImpl _1 = new NodeImpl(1);
        NodeImpl _2 = new NodeImpl(2);
        NodeImpl _3 = new NodeImpl(3);
        NodeImpl _3_5 = new NodeImpl(3.5);
        NodeImpl _4 = new NodeImpl(4);
        NodeImpl _4_5 = new NodeImpl(4.5);
        NodeImpl _5 = new NodeImpl(5);
        NodeImpl _6 = new NodeImpl(6);
        NodeImpl _7 = new NodeImpl(7);
        NodeImpl _11 = new NodeImpl(11);
        NodeImpl _20 = new NodeImpl(20);
        _20.setLeft(_5);
        _5.setLeft(_3);
        _5.setRight(_7);
        _3.setLeft(_2);
        _3.setRight(_4);
        _2.setLeft(_1);
        _4.setLeft(_3_5);
        _4.setRight(_4_5);
        _7.setLeft(_6);
        _7.setRight(_11);

        assertThat("Wrong node for 3", NextNodeForBinarySearchTree.next(_3), is(_3_5));
        assertThat("Wrong node for 4", NextNodeForBinarySearchTree.next(_4), is(_4_5));
        assertThat("Wrong node for 4.5", NextNodeForBinarySearchTree.next(_4_5), is(_5));
        assertThat("Wrong node for 7", NextNodeForBinarySearchTree.next(_7), is(_11));
        assertThat("Wrong node for 11", NextNodeForBinarySearchTree.next(_11), is(_20));
        assertThat("Wrong node for 20", NextNodeForBinarySearchTree.next(_20), is(_20));
    }

    class NodeImpl implements NextNodeForBinarySearchTree.Node {
        private final double value;
        private NextNodeForBinarySearchTree.Node parent;
        private NextNodeForBinarySearchTree.Node left;
        private NextNodeForBinarySearchTree.Node right;

        public NodeImpl(double value) {
            this.value = value;
        }

        @Override
        public NextNodeForBinarySearchTree.Node getParent() {
            return parent;
        }

        @Override
        public NextNodeForBinarySearchTree.Node getLeft() {
            return left;
        }

        @Override
        public NextNodeForBinarySearchTree.Node getRight() {
            return right;
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    '}';
        }

        public void setParent(NodeImpl parent) {
            this.parent = parent;
        }

        public void setLeft(NodeImpl left) {
            this.left = left;
            left.setParent(this);
        }

        public void setRight(NodeImpl right) {
            this.right = right;
            right.setParent(this);
        }
    }
}
