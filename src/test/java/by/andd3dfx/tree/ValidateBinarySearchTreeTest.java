package by.andd3dfx.tree;

import static org.assertj.core.api.Assertions.assertThat;

import by.andd3dfx.tree.ValidateBinarySearchTree.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class ValidateBinarySearchTreeTest {

    private ValidateBinarySearchTree binarySearchTree;

    @Before
    public void setUp() throws Exception {
        binarySearchTree = new ValidateBinarySearchTree();
    }

    @Test
    public void isValidBST() {
        TreeNode root = new TreeNode(2,
            new TreeNode(1),
            new TreeNode(3)
        );
        assertThat(binarySearchTree.isValidBST(root)).isTrue();

        TreeNode root2 = new TreeNode(5,
            new TreeNode(1),
            new TreeNode(4, new TreeNode(3), new TreeNode(6))
        );
        assertThat(binarySearchTree.isValidBST(root2)).isFalse();

        TreeNode root3 = new TreeNode(5,
            new TreeNode(1),
            new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );
        assertThat(binarySearchTree.isValidBST(root3)).isTrue();
    }
}
