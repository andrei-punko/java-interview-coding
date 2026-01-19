package by.andd3dfx.tree;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.tree.SymmetricTree.TreeNode;
import org.junit.Test;

public class SymmetricTreeTest {

    @Test
    public void isSymmetricMirroredLeftNRight() {
        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3))
        );
        assertThat(SymmetricTree.isSymmetric(root)).isTrue();
    }

    @Test
    public void isSymmetricTheSameLeftNRight() {
        TreeNode root2 = new TreeNode(1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(3))
        );
        assertThat(SymmetricTree.isSymmetric(root2)).isFalse();
    }
}
