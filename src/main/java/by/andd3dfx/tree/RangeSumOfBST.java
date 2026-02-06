package by.andd3dfx.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.AllArgsConstructor;

/**
 * <pre>
 * <a href="https://leetcode.com/problems/range-sum-of-bst/description/">Task description</a>
 *
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value
 * in the inclusive range [low, high].
 *
 * Example 1:
 * <img src="https://assets.leetcode.com/uploads/2020/11/05/bst1.jpg"/>
 *   Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 *   Output: 32
 *   Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 *
 * Example 2:
 * <img src="https://assets.leetcode.com/uploads/2020/11/05/bst2.jpg"/>
 *   Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 *   Output: 23
 *   Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 * </pre>
 *
 * @see <a href="https://youtu.be/gnSyhRpfHNU">Video solution</a>
 */
public class RangeSumOfBST {

    public static int rangeSumBST_usingQueue(TreeNode root, int low, int high) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        var sum = 0;
        while (!queue.isEmpty()) {
            var element = queue.pop();
            if (element.left != null && element.val >= low) {
                queue.add(element.left);
            }
            if (element.right != null && element.val <= high) {
                queue.add(element.right);
            }
            if (low <= element.val && element.val <= high) {
                sum += element.val;
            }
        }
        return sum;
    }

    public static int rangeSumBST_usingRecursion(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val >= low) {
            result += rangeSumBST_usingRecursion(root.left, low, high);
        }
        if (root.val <= high) {
            result += rangeSumBST_usingRecursion(root.right, low, high);
        }
        if (low <= root.val && root.val <= high) {
            result += root.val;
        }
        return result;
    }

    @AllArgsConstructor
    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
