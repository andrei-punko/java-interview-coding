package by.andd3dfx.tree;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/symmetric-tree/description/">Task description</a>
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1:
 * <img src="https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg"/>
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * <img src="https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg"/>
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * </pre>
 *
 * @see <a href="https://youtu.be/pZJ852c2CAE">Video solution</a>
 */
public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        var left = root.left;
        var right = root.right;
        return equals(left, right);
    }

    private static boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2 == null;
        }
        if (node2 == null) {
            return false;
        }
        return node1.val == node2.val && equals(node1.left, node2.right) && equals(node1.right, node2.left);
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
