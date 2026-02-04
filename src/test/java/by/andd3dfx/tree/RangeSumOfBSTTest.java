package by.andd3dfx.tree;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.tree.RangeSumOfBST.TreeNode;
import org.apache.commons.lang3.function.TriFunction;
import org.junit.Test;

public class RangeSumOfBSTTest {

    @Test
    public void rangeSumBST_usingQueue() {
        rangeSumBST(RangeSumOfBST::rangeSumBST_usingQueue);
    }

    @Test
    public void rangeSumBST_usingRecursion() {
        rangeSumBST(RangeSumOfBST::rangeSumBST_usingRecursion);
    }

    private void rangeSumBST(TriFunction<TreeNode, Integer, Integer, Integer> function) {
        TreeNode root = new TreeNode(10,
            new TreeNode(5, new TreeNode(3), new TreeNode(7)),
            new TreeNode(15, null, new TreeNode(18))
        );
        assertThat(function.apply(root, 7, 15)).isEqualTo(32);

        TreeNode root2 = new TreeNode(10,
            new TreeNode(5,
                new TreeNode(3, new TreeNode(1), null),
                new TreeNode(7, new TreeNode(6), null)
            ),
            new TreeNode(15, new TreeNode(13), new TreeNode(18))
        );
        assertThat(function.apply(root2, 6, 10)).isEqualTo(23);
    }
}
