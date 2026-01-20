package by.andd3dfx.tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/description/">Task description</a>
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *     The left of a node contains only nodes with keys strictly less than the node's key.
 *     The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 *     Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * <img src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg"/>
 * Input: root = [2,1,3]
 * Output: true
 *
 * Example 2:
 * <img src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg"/>
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * </pre>
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return allLessThan(root.val, root.left) && isValidBST(root.left)
            && allGreaterThan(root.val, root.right) && isValidBST(root.right);
    }

    private boolean allLessThan(int value, TreeNode node) {
        if (node == null) {
            return true;
        }
        return node.val < value && allLessThan(value, node.left) && allLessThan(value, node.right);
    }

    private boolean allGreaterThan(int value, TreeNode node) {
        if (node == null) {
            return true;
        }
        return node.val > value && allGreaterThan(value, node.left) && allGreaterThan(value, node.right);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
