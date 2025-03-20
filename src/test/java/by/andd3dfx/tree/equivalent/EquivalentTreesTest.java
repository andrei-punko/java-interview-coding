package by.andd3dfx.tree.equivalent;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class EquivalentTreesTest {

    private EquivalentTrees equivalentTrees;

    @Before
    public void setUp() {
        equivalentTrees = new EquivalentTrees();
    }

    @Test
    public void findEquivalentSubtreesForNull() {
        assertThat(equivalentTrees.findEquivalentSubtrees(null), is(nullValue()));
    }

    /**
     * <pre>
     *  A
     * </pre>
     */
    @Test
    public void findEquivalentSubtreesForRootNodeOnly() {
        Node node = new Node('A');
        assertThat(equivalentTrees.findEquivalentSubtrees(node), is(nullValue()));
    }

    /**
     * <pre>
     *    A
     *   /
     *  B
     * </pre>
     */
    @Test
    public void findEquivalentSubtreesWhenNoCandidates() {
        Node node = new Node('A');
        node.left = new Node('B');
        assertThat(equivalentTrees.findEquivalentSubtrees(node), is(nullValue()));
    }

    /**
     * <pre>
     *    A
     *   / \
     *  B   C
     * </pre>
     */
    @Test
    public void findEquivalentSubtreesWhenOneCandidate() {
        Node node = new Node('A');
        node.left = new Node('B');
        node.right = new Node('C');

        List<Node> result = equivalentTrees.findEquivalentSubtrees(node);

        assertThat(result.size(), is(2));
        assertThat(result, hasItems(node.left, node.right));
    }

    /**
     * <pre>
     *      A
     *     / \
     *    B   B
     *   /     \
     *  X       X
     * </pre>
     */
    @Test
    public void findEquivalentSubtreesWhenTwoCandidate() {
        Node node = new Node('A');
        node.left = new Node('B');
        node.left.left = new Node('X');
        node.right = new Node('B');
        node.right.right = new Node('X');

        List<Node> result = equivalentTrees.findEquivalentSubtrees(node);

        assertThat(result.size(), is(2));
        assertThat(result, hasItems(node.left, node.right));
    }

    /**
     * <pre>
     *        A
     *       / \
     *      B   C
     *     /   / \
     *    E   B   E
     *   /       / \
     *  D       E   D
     * </pre>
     */
    @Test
    public void findEquivalentSubtreesComplexCase() {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');

        root.left.left = new Node('E');
        root.left.left.left = new Node('D');

        root.right.left = new Node('B');
        root.right.right = new Node('E');
        root.right.right.left = new Node('E');
        root.right.right.right = new Node('D');

        List<Node> result = equivalentTrees.findEquivalentSubtrees(root);

        assertThat("Two nodes expected", result.size(), is(2));
        assertThat("Left node is absent", result, hasItem(root.left));
        assertThat("Right node is absent", result, hasItem(root.right.right));
    }
}
