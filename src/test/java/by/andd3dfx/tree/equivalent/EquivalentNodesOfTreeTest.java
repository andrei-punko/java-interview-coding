package by.andd3dfx.tree.equivalent;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EquivalentNodesOfTreeTest {

    private EquivalentNodesOfTree equivalentNodesOfTree;

    @Before
    public void setUp() {
        equivalentNodesOfTree = new EquivalentNodesOfTree();
    }

    @Test
    public void findEquivalentNodesForNull() {
        assertThat(equivalentNodesOfTree.findEquivalentNodes(null)).isNull();
    }

    /**
     * <pre>
     *  A
     * </pre>
     */
    @Test
    public void findEquivalentNodesForRootNodeOnly() {
        Node node = new Node('A');
        assertThat(equivalentNodesOfTree.findEquivalentNodes(node)).isNull();
    }

    /**
     * <pre>
     *    A
     *   /
     *  B
     * </pre>
     */
    @Test
    public void findEquivalentNodesWhenNoCandidates() {
        Node node = new Node('A');
        node.left = new Node('B');
        assertThat(equivalentNodesOfTree.findEquivalentNodes(node)).isNull();
    }

    /**
     * <pre>
     *    A
     *   / \
     *  B   C
     * </pre>
     */
    @Test
    public void findEquivalentNodesWhenOneCandidate() {
        Node node = new Node('A');
        node.left = new Node('B');
        node.right = new Node('C');

        List<Node> result = equivalentNodesOfTree.findEquivalentNodes(node);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactlyInAnyOrder(node.left, node.right);
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
    public void findEquivalentNodesSymmetricCase() {
        Node node = new Node('A');
        node.left = new Node('B');
        node.left.left = new Node('X');
        node.right = new Node('B');
        node.right.right = new Node('X');

        List<Node> result = equivalentNodesOfTree.findEquivalentNodes(node);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactlyInAnyOrder(node.left, node.right);
    }

    /**
     * <pre>
     *      A
     *     / \
     *    B   B
     *   /     \
     *  X       C
     *           \
     *            X
     * </pre>
     */
    @Test
    public void findEquivalentNodesAsymmetricCase() {
        Node node = new Node('A');
        node.left = new Node('B');
        node.left.left = new Node('X');
        node.right = new Node('B');
        node.right.right = new Node('C');
        node.right.right.right = new Node('X');

        List<Node> result = equivalentNodesOfTree.findEquivalentNodes(node);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactlyInAnyOrder(node.left, node.right.right);
    }

    /**
     * <pre>
     *      A
     *     / \
     *    B   B
     *   /     \
     *  X       X
     *           \
     *            X
     * </pre>
     */
    @Test
    public void findEquivalentNodesAsymmetricCaseShouldChooseNodesWithMaxSubtreeSize() {
        Node node = new Node('A');
        node.left = new Node('B');
        node.left.left = new Node('X');
        node.right = new Node('B');
        node.right.right = new Node('X');
        node.right.right.right = new Node('X');

        List<Node> result = equivalentNodesOfTree.findEquivalentNodes(node);

        assertThat(result.size()).isEqualTo(2);
        assertThat(result).containsExactlyInAnyOrder(node.left, node.right);
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
     *             / \
     *            D   E
     *           /
     *          D
     * </pre>
     */
    @Test
    public void findEquivalentNodesComplexCase() {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');

        root.left.left = new Node('E');
        root.left.left.left = new Node('D');

        root.right.left = new Node('B');
        root.right.right = new Node('E');
        root.right.right.left = new Node('E');
        root.right.right.right = new Node('D');
        root.right.right.right.left = new Node('D');
        root.right.right.right.right = new Node('E');
        root.right.right.right.left.left = new Node('D');

        List<Node> result = equivalentNodesOfTree.findEquivalentNodes(root);

        assertThat(result.size()).as("Two nodes expected").isEqualTo(2);
        assertThat(result).containsExactlyInAnyOrder(root.right.right, root.right.right.right);
    }
}
