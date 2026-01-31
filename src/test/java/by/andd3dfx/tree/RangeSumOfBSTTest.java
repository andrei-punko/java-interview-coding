package by.andd3dfx.tree;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.tree.RangeSumOfBST.TreeNode;
import org.junit.Test;

public class RangeSumOfBSTTest {

    @Test
    public void rangeSumBST() {
        TreeNode root = new TreeNode(10,
            new TreeNode(5, new TreeNode(3), new TreeNode(7)),
            new TreeNode(15, null, new TreeNode(18))
        );
        assertThat(RangeSumOfBST.rangeSumBST(root, 7, 15)).isEqualTo(32);

        TreeNode root2 = new TreeNode(10,
            new TreeNode(5,
                new TreeNode(3, new TreeNode(1), null),
                new TreeNode(7, new TreeNode(6), null)
            ),
            new TreeNode(15, new TreeNode(13), new TreeNode(18))
        );
        assertThat(RangeSumOfBST.rangeSumBST(root2, 6, 10)).isEqualTo(23);
    }
}
