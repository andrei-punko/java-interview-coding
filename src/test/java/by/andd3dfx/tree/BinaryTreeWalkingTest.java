package by.andd3dfx.tree;

import by.andd3dfx.tree.BinaryTreeWalking.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTreeWalkingTest {

    private BinaryTreeWalking binaryTreeWalking;

    @Before
    public void setUp() throws Exception {
        binaryTreeWalking = new BinaryTreeWalking();
    }

    @Test
    public void breadthWalk() {
        Node<Integer> root = buildTree();

        List<Node<Integer>> result = binaryTreeWalking.breadthWalk(root);

        checkResultList(result, List.of(5, 4, 12, 11, 9, 34, 7));
    }

    @Test
    public void forwardVerticalWalk() {
        Node<Integer> root = buildTree();

        List<Node<Integer>> result = binaryTreeWalking.forwardVerticalWalk(root);

        checkResultList(result, List.of(5, 4, 11, 12, 9, 7, 34));
    }

    @Test
    public void symmetricVerticalWalk() {
        Node<Integer> root = buildTree();

        List<Node<Integer>> result = binaryTreeWalking.symmetricVerticalWalk(root);

        checkResultList(result, List.of(4, 11, 5, 7, 9, 12, 34));
    }

    @Test
    public void backwardVerticalWalk() {
        Node<Integer> root = buildTree();

        List<Node<Integer>> result = binaryTreeWalking.backwardVerticalWalk(root);

        checkResultList(result, List.of(11, 4, 7, 9, 34, 12, 5));
    }

    private void checkResultList(List<Node<Integer>> result, List<Integer> expectation) {
        var values = result.stream().map(Node::getValue).toList();
        assertThat(values).isEqualTo(expectation);
    }

    /**
     * <pre>
     *      5
     *  4      12
     *   11   9  34
     *       7
     * </pre>
     */
    private Node<Integer> buildTree() {
        var eleven = new Node<>(11, null, null);
        var four = new Node<>(4, null, eleven);

        var seven = new Node<>(7, null, null);
        var nine = new Node<>(9, seven, null);
        var thirtyFour = new Node<>(34, null, null);
        var twelve = new Node<>(12, nine, thirtyFour);

        return new Node<>(5, four, twelve);
    }
}