package by.andd3dfx.tree;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

/**
 * <pre>
 * Binary search tree (BST) is a binary tree where the value of each node is larger or equal to the values in all
 * the nodes in that node's left subtree and is smaller than the values in all the nodes in that node's right subtree.
 * Write a function that checks if a given binary search tree contains a given value.
 *
 * For example, for the following tree:
 * n1 (Value: 1, Left: null, Right: null)
 * n2 (Value: 2, Left: n1, Right: n3)
 * n3 (Value: 3, Left: null, Right: null)
 * Call contains(n2, 3) should return true since a tree with root at n2 contains number 3.
 * </pre>
 *
 * @see <a href="https://youtu.be/DGLiObeU04A">Video solution</a>
 */
public class BinarySearchTree {

    @Builder
    @RequiredArgsConstructor
    public static class Node {

        private final int value;
        private final Node left, right;

        public boolean contains(int value) {
            return contains(this, value);
        }

        public static boolean contains(Node node, int value) {
            if (node == null) {
                return false;
            }
            if (node.value == value) {
                return true;
            }
            var nextNode = (value < node.value) ? node.left : node.right;
            return contains(nextNode, value);
        }
    }
}
