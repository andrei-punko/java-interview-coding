package by.andd3dfx.tree;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.tree.SymmetricTree.TreeNode;
import org.junit.Test;

public class SymmetricTreeTest {

    @Test
    public void isSymmetricWhenMirroredLeftNRightNodes() {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        assertThat(SymmetricTree.isSymmetric(root)).isTrue();
    }

    @Test
    public void isSymmetricWhenTheSameLeftNRightNodes() {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(3))
        );
        assertThat(SymmetricTree.isSymmetric(root)).isFalse();
    }
}
