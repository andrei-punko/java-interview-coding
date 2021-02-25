package by.andd3dfx.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTreeWalkingTest {

    private BinaryTreeWalking binaryTreeWalking;

    @Before
    public void setup() {
        binaryTreeWalking = new BinaryTreeWalking();
    }

    @Test
    public void breadthWalk() {
        BinaryTreeWalking.Node<Integer> root = buildTree();

        List<BinaryTreeWalking.Node<Integer>> result = binaryTreeWalking.breadthWalk(root);

        checkResultList(result, new int[]{5, 4, 12, 11, 9, 34, 7});
    }

    @Test
    public void forwardVerticalWalk() {
        BinaryTreeWalking.Node<Integer> root = buildTree();

        List<BinaryTreeWalking.Node<Integer>> result = binaryTreeWalking.forwardVerticalWalk(root);

        checkResultList(result, new int[]{5, 4, 11, 12, 9, 7, 34});
    }

    @Test
    public void symmetricVerticalWalk() {
        BinaryTreeWalking.Node<Integer> root = buildTree();

        List<BinaryTreeWalking.Node<Integer>> result = binaryTreeWalking.symmetricVerticalWalk(root);

        checkResultList(result, new int[]{4, 11, 5, 7, 9, 12, 34});
    }

    @Test
    public void backwardVerticalWalk() {
        BinaryTreeWalking.Node<Integer> root = buildTree();

        List<BinaryTreeWalking.Node<Integer>> result = binaryTreeWalking.backwardVerticalWalk(root);

        checkResultList(result, new int[]{11, 4, 7, 9, 34, 12, 5});
    }

    private void checkResultList(List<BinaryTreeWalking.Node<Integer>> result, int[] expectedResult) {
        List<Integer> values = result.stream().map(node -> node.value).collect(Collectors.toList());
        assertThat(values.size(), is(expectedResult.length));
        assertThat(values.toArray(), is(expectedResult));
    }

    /**
     * <pre>
     *       5
     *   4      12
     *    11   9  34
     *        7
     * </pre>
     */
    private BinaryTreeWalking.Node<Integer> buildTree() {
        BinaryTreeWalking.Node eleven = new BinaryTreeWalking.Node(null, null, 11);
        BinaryTreeWalking.Node four = new BinaryTreeWalking.Node(null, eleven, 4);
        BinaryTreeWalking.Node seven = new BinaryTreeWalking.Node(null, null, 7);
        BinaryTreeWalking.Node nine = new BinaryTreeWalking.Node(seven, null, 9);
        BinaryTreeWalking.Node thirtyFour = new BinaryTreeWalking.Node(null, null, 34);
        BinaryTreeWalking.Node<Integer> root = new BinaryTreeWalking.Node(
                four, new BinaryTreeWalking.Node(nine, thirtyFour, 12), 5
        );
        return root;
    }
}
